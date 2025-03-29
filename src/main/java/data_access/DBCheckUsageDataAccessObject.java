package data_access;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import use_case.checkUsage.CheckUsageDataAccessInterface;
import use_case.translateText.DataAccessException;

/**
 * The DAO for getting usage using DeepL API.
 * API links: <a href="https://developers.deepl.com/docs/api-reference/translate">...</a>.
 */
public class DBCheckUsageDataAccessObject extends DeeplTranslator
        implements CheckUsageDataAccessInterface {

    public static final String CHARACTER_COUNT = "character_count";
    public static final String CHARACTER_LIMIT = "character_limit";

    public DBCheckUsageDataAccessObject() {
        try {
            checkUsage();
            getCharacterCount();
            getCharacterLimit();
        }
        catch (DataAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Get the character count and character limit as a Map.
     *
     * @return a set withs keys "character_count" and "character_limit" with their corresponding values
     * @throws DataAccessException if the usage cannot be accessed for any reason
     */
    private Map<String, String> checkUsage() throws DataAccessException {
        try {
            final String url = "https://api-free.deepl.com/v2/usage";
            final HttpClient client;
            final Map<String, String> usage = new HashMap<>();
            client = HttpClient.newHttpClient();
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization", "DeepL-Auth-Key " + super.getAuthKey())
                    .GET()
                    .build();

            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            final JSONObject jsonUsage = new JSONObject(response.body());
            usage.put(CHARACTER_COUNT, String.valueOf(jsonUsage.get(CHARACTER_COUNT)));
            usage.put(CHARACTER_LIMIT, String.valueOf(jsonUsage.get(CHARACTER_LIMIT)));
            return usage;
        }
        catch (IOException | InterruptedException ex) {
            throw new DataAccessException(ex.getMessage());
        }
    }
    /**
     * Return the character count.
     * If the character count is null, return an empty string.
     *
     * @return the character count of the usage
     */

    @Override
    public String getCharacterCount() throws DataAccessException {
        return this.checkUsage().get(CHARACTER_COUNT);
    }

    /**
     * Return the character limit.
     * If the character limit is null, return an empty string.
     *
     * @return the character limit of the usage
     */

    @Override
    public String getCharacterLimit() throws DataAccessException {
        return this.checkUsage().get(CHARACTER_LIMIT);
    }
}
