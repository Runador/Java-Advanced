package exercisesworkingwithabstraction.cardswithpower;

public class Card {

    private RankPowers rankPowers;
    private SuitPowers suitPowers;

    public Card (RankPowers rankPowers, SuitPowers suitPowers) {
        this.rankPowers = rankPowers;
        this.suitPowers = suitPowers;
    }

    public RankPowers getRankPowers() {
        return rankPowers;
    }

    public SuitPowers getSuitPowers() {
        return suitPowers;
    }

}
