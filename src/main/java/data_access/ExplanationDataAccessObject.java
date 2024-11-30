package data_access;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.explanation.ExplanationDataAccessInterface;

import java.io.IOException;

public class ExplanationDataAccessObject implements ExplanationDataAccessInterface {

    private static final String TOKEN = "token";
    private static final String GOOGLE_API_KEY = System.getenv(TOKEN);
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + GOOGLE_API_KEY;
    private static final String APPLICATION_JSON = "application/json";

    // uses java sdk instead of https
//    const genAI = new GoogleGenerativeAI(process.env.API_KEY);
//const model = genAI.getGenerativeModel({ model: "gemini-1.5-flash" });
//
//const prompt = "Write a story about a magic backpack.";
//
//const result = await model.generateContent(prompt);
//console.log(result.response.text());

    @Override
    public String getExplanation(String joke) {

        String prompt = "explain this joke" + joke;

        // Build client
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        // type of request body is json
        final MediaType mediaType = MediaType.parse(APPLICATION_JSON);
        //make request body
        final JSONObject requestBody = new JSONObject()
//                .put("generationConfig", new JSONObject().put("maxOutputTokens", 1))
                .put("contents", new JSONObject()
                        .put("parts", new JSONObject()
                                .put("text", prompt)
                        )
                );
        // RequestBody takes in type and content (string)
        final RequestBody body = RequestBody.create(mediaType, requestBody.toString());

        // add arguments to url, or add headers as needed
        final Request request = new Request.Builder()
                .url(String.format(API_URL))
                .post(body)
                .build();

        // Hint: look at the API documentation to understand what the response looks like.
        try {

            // Client creates a Call with Request
            // Call returns the Response from execute()
            final Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                final JSONObject responseBody = new JSONObject(response.body().string());

                JSONObject candidates = responseBody.getJSONArray("candidates").getJSONObject(0);
                if (candidates.getString("finishReason").equals("STOP")) {
                    return candidates
                            .getJSONObject("content")
                            .getJSONArray("parts").getJSONObject(0)
                            .getString("text");
                } else {
                    return "this joke is too inappropriate for me!";
                }
            } else {
                throw new RuntimeException(response.message());
            }
        } catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }
}