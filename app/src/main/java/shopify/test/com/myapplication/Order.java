package shopify.test.com.myapplication;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by haris on 8/20/17.
 */

public class Order {

    /**
     * contains information about the order
     * contains the key value for the colum name within a JSON object
     */


    public static final String KEY_ORDERS = "orders";

    public static final String KEY_ID = "id";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_TOTAL = "total_price";
    public static final String KEY_CONFIRMED = "confirmed";

    public static final String KEY_CUSTOMER = "customer";

    public static final String KEY_ITEMS = "line_items";


    private String id;
    private String email;
    private double total;
    private boolean confirmed;

    private Customer customer;

    private ArrayList<Item> items;

    public Order(Customer customer,  String id, String email, double total, boolean confirmed, ArrayList items){
        this.customer = customer;
        this.id = id;
        this.email = email;
        this.total = total;
        this.confirmed = confirmed;
        this.items = items;
    }


    public String getId(){
        return this.id;
    }

    public double getTotal() {
        return total;
    }

    public String getEmail() {
        return email;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public Customer getCustomer() {
        return customer;
    }
}
