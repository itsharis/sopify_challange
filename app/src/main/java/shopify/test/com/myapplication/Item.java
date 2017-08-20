package shopify.test.com.myapplication;

/**
 * Created by haris on 8/20/17.
 */

public class Item {
    /**
     * Class to contain the types of orders contained within an order
     */

    public static final String KEY_TITLE = "title";

    private String name;

    public Item(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
