package use_case.search.adapter;

public class SearchState {
    // info that can change
    private String keyWord = "";

    @Override
    public String toString() {
        return "SearchState{"
                + "keyWord='" + getKeyWord() + '\''
                + '}';
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}