package data_access;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import use_case.daily_puzzle.PuzzleAccessException;
import use_case.daily_puzzle.PuzzleDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;

public class PuzzleDataAccessObject implements PuzzleDataAccessInterface {
    private static final int SUCCESS_CODE = 200;
    private static final String LICHESS_PUZZLE_URL = "https://lichess.org/api/puzzle/";
    private static final String DAILY_PUZZLE_URL = "daily";
    private static String PUZZLE_FROM_ID_URL;

    public ArrayList<String> getDaily() throws PuzzleAccessException {
        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder().url(LICHESS_PUZZLE_URL + DAILY_PUZZLE_URL).build();
        ArrayList<String> output = null;

        try {
            final Response response = client.newCall(request).execute();

            final JSONObject responseBody = new JSONObject(response.body().string());

            JSONObject puzzle = responseBody.getJSONObject("puzzle");
            JSONArray solution = puzzle.getJSONArray("solution");
            output.add(puzzle.getString("id"));
            for (int i = 0; i < solution.length(); i++) {
                output.add(solution.getString(i));
            }
        }
        catch (final IOException | JSONException e) {
            throw new PuzzleAccessException(e.getMessage());
        }
        return output;
    }

    @Override
    public ArrayList<String> fetchPuzzle(String id) throws PuzzleAccessException {
        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder().url(LICHESS_PUZZLE_URL + PUZZLE_FROM_ID_URL).build();
        ArrayList<String> output = null;

        try {
            final Response response = client.newCall(request).execute();

            final JSONObject responseBody = new JSONObject(response.body().string());

            JSONArray solution = responseBody.getJSONArray("solution");
            output.add(responseBody.getJSONObject("game").getString("pgn"));
            for (int i = 0; i < solution.length(); i++) {
                output.add(solution.getString(i));
            }
        }
        catch (final IOException | JSONException e) {
            throw new PuzzleAccessException(e.getMessage());
        }
        return output;
    }
}
