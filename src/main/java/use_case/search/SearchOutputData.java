package use_case.search;

import org.json.JSONObject;

public class SearchOutputData {

    private final String jokeContent;

    public SearchOutputData(String jokeContent) {
        this.jokeContent = jokeContent;
    }

    public String getJokeContent() {
        return jokeContent;
    }

    public Boolean getError() {
        if ("No matching joke found".equals(jokeContent)) {
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
}