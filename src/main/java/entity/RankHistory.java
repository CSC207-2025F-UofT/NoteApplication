package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * The representation of user rank history for our program.
 */

public class RankHistory {
    private final List<Rank> rankHistoryList;

    public RankHistory() {
        this.rankHistoryList = new ArrayList<>();
    }

    public List<Rank> getRanks() {
        return rankHistoryList;
    }

    /**
     * Print the RankHistory.
     */
    public void printRankHistory() {
        for (Rank rank : rankHistoryList) {
            System.out.println(rank);
        }
    }

    /**
     * Add user rank for our program.
     * @param year the rank year.
     * @param month the rank month.
     * @param day the rank day.
     * @param rank the rank .
     */
    public void addRankHistory(int year, int month, int day, int rank) {
        final Rank rh = new Rank(year, month, day, rank);
        this.rankHistoryList.add(rh);
    }

    /**
     * The representation of  user rank for our program.
     */
    public static class Rank {
        private final int year;
        private final int month;
        private final int day;
        private final int rank;

        public Rank(int year, int month, int day, int rank) {
            this.year = year;
            this.month = month + 1;
            this.day = day;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Year:" + year + " Month:" + month
                           + " Day:" + day + " Rank:" + rank;
        }
    }
}
