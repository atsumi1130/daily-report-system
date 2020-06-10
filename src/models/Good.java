package models;

import java.io.Serializable;

public class Good implements Serializable{
    private int goodCount = 0;

    public void setGoodCount(int goodCount){
        this.goodCount = goodCount;
    }

    public int getGoodCount() {
        return goodCount;
    }
}
