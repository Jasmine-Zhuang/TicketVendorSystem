package UStore;

import java.io.Serializable;

public class Mug extends RewardsItem implements Redeemable, Serializable {
    /**
     * Construct a mug
     */
    public Mug() {
        super("Mug", 800);
    }


}
