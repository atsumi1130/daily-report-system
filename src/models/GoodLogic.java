package models;

public class GoodLogic {
    public void goodPlus(Good g) {
        int count = g.getGoodCount();
        count = count + 1;
        g.setGoodCount(count);
    }
}
