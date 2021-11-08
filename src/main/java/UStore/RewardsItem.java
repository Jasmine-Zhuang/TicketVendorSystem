package UStore;

public interface RewardsItem<T> {

    T createItem(float points);

    String redeem();

}
