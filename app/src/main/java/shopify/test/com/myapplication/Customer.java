package shopify.test.com.myapplication;

/**
 * Created by haris on 8/20/17.
 */

public class Customer {

    /**
     * Class that contains basic information about the customer
     */

    public static final String KEY_FIRST_NAME = "first_name";
    public static final String KEY_LAST_NAME = "last_name";

    private String firstName;
    private String lastName;


    public Customer (String first_name, String last_name){
        this.firstName = first_name;
        this.lastName = last_name;
    }

    public String getFirst_name() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
