package data_access;

import entity.RankHistory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import use_case.query.QueryDataAccessInterface;

import java.io.IOException;

/**
 * The DAO for accessing user rank history stored in the database.
 */
public class QueryDataAccessObject implements QueryDataAccessInterface {
    @Override
    public RankHistory showRankHistory(String username) {

        final RankHistory rankHistory = new RankHistory();

        final String url = String.format("https://lichess.org/api/user/%s/rating-history", username);
        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {

            final String responseBody = response.body().string();
            final com.alibaba.fastjson.JSONArray jsonArray = com.alibaba.fastjson.JSONArray.parseArray(responseBody);

            jsonArray.stream().forEach(str -> {
                final com.alibaba.fastjson.JSONObject jsonObject =
                        com.alibaba.fastjson.JSONObject.parseObject(str.toString());

                final String name = (String) jsonObject.get("name");
                if ("Puzzles".equals(name)) {
                    final Object points = jsonObject.get("points");
                    final com.alibaba.fastjson.JSONArray pointarr =
                            com.alibaba.fastjson.JSONArray.parseArray(points.toString());

                    final Object[] objects = pointarr.toArray();

                    for (Object object : objects) {
                        final com.alibaba.fastjson.JSONArray ranks =
                                com.alibaba.fastjson.JSONArray.parseArray(object.toString());
                        final int year = (Integer) ranks.get(0);
                        final int month = (Integer) ranks.get(1);
                        final int day = (Integer) ranks.get(2);
                        final int rank = (Integer) ranks.get(3);
                        rankHistory.addRankHistory(year, month, day, rank);
                    }
                }
            });
            return rankHistory;
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
