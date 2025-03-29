package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.generate.GenerateDataAccessInterface;
import use_case.search.SearchDataAccessInterface;

import java.io.IOException;


public class JokeDataAccessObject implements GenerateDataAccessInterface,
        SearchDataAccessInterface {

    private static final String MESSAGE = "message";
    private static final String API_URL = "https://v2.jokeapi.dev/joke/Any";
    private static final String API_SEARCH_URL = "https://v2.jokeapi.dev/joke/Any?contains=";

    @Override
    public String getJokeContent() {

        // Build client
        // Build the request to get joke.
        // client sends request
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        // add arguments to url, or add headers as needed
        final Request request = new Request.Builder()
                .url(String.format(API_URL))
                .build();

        // Hint: look at the API documentation to understand what the response looks like.
        try {
            // Client creates a Call with Request
            // Call returns the Response from execute()
            final Response response = client.newCall(request).execute();

            // JSONObject is a dictionary that can be written to a JSON file
            // a JSON file has multiple JSONObjects:
            // file -> String -> JSONArray -> JSONObject
            // String jsonString = Files.readString(Paths.get(getClass().getClassLoader().getResource(filename).toURI()))
            // JSONArray jsonArray = new JSONArray(jsonString);
            // JSONObject jsonObject = jsonArray.getJSONObject(i);
            final JSONObject responseBody = new JSONObject(response.body().string());

            // Response body (the JSONObject)  varies for API.
            if (responseBody.getBoolean("error")) {
                throw new RuntimeException(responseBody.getString(MESSAGE));
            } else {
                switch (responseBody.getString("type")) {
                    case "single":
                        return responseBody.getString("joke");
                    case "twopart":
                        return responseBody.getString("setup") + responseBody.getString("delivery");
                    default:
                        return "something funny";
                }
            }
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public String searchJoke(String keyword) {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(String.format(API_SEARCH_URL + keyword))
                .build();
        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            if (responseBody.getBoolean("error")) {
                return responseBody.getString(MESSAGE);
            }
            else {
                switch (responseBody.getString("type")) {
                    case "single":
                        return responseBody.getString("joke");
                    case "twopart":
                        return responseBody.getString("setup") + responseBody.getString("delivery");
                    default:
                        return "something funny";
                }
            }
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }
}
