package address.model;

import java.awt.*;

public enum FontWeight {
    PLAIN(Font.PLAIN),
    BOLD(Font.BOLD),
    ITALIC(Font.ITALIC);

    private final int weight;


    FontWeight(final int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }
}
