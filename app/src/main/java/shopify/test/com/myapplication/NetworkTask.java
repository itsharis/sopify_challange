package shopify.test.com.myapplication;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


public class NetworkTask extends AsyncTask<Void, String, Void> {

    private TextView information;


    private int counter = 0;
    private double totalAmount = 0;


    public NetworkTask(){

    }

    /**
     * This method makes take the request and runs it on anoter thread to avoid NetworkOnMainStack exception
     * First fetch the entire JSON then parse it to create Order Objects for easier data manipulation.
     * @param params None
     * @return
     */
    @Override
    protected Void doInBackground(Void... params) {
        try {
            JSONObject object = RequestHandler.makeRequest("https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6");

            JSONArray array = object.getJSONArray(Order.KEY_ORDERS);


            for(int i = 0; i < array.length(); i++){
                JSONObject innerObject = array.getJSONObject(i);

                Customer tempCustomer = null;
                ArrayList<Item> listOfItems = new ArrayList<>();


                if(innerObject.has(Order.KEY_CUSTOMER)){
                    JSONObject customer = innerObject.getJSONObject(Order.KEY_CUSTOMER);
                    tempCustomer = new Customer(customer.getString(Customer.KEY_FIRST_NAME),customer.getString(Customer.KEY_LAST_NAME));
                }

                if(innerObject.has(Order.KEY_ITEMS)){
                    JSONArray items = innerObject.getJSONArray(Order.KEY_ITEMS);
                    for(int k = 0; k < items.length(); k++){
                        JSONObject item = items.getJSONObject(k);
                        listOfItems.add(new Item(item.getString(Item.KEY_TITLE)));
                        if(item.getString(Item.KEY_TITLE).equals("Awesome Bronze Bag")){
                            counter++;
                        }
                    }
                }


                Order order = new Order(
                        tempCustomer,
                        innerObject.getString(Order.KEY_ID),
                        innerObject.getString(Order.KEY_EMAIL),
                        innerObject.getDouble(Order.KEY_TOTAL),
                        innerObject.getBoolean(Order.KEY_CONFIRMED),
                        listOfItems);

                if(order.getCustomer() != null) {
                    if (tempCustomer.getFirst_name().equals("Napoleon") && tempCustomer.getLastName().equals("Batz") && order.isConfirmed()) {
                        totalAmount += order.getTotal();
                    }
                }

            }
            Log.d("NetworkTask", "doInBackground: Total Bronze Bags:" + counter);
            Log.d("NetworkTask", "doInBackground: Total Bronze Bags:" + totalAmount);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException j){
            j.printStackTrace();
        }

        return null;
    }

    public void setTextView(TextView view){
        this.information = view;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        information.setText("Total bought by Naploean Bats:" + counter + "\nTotal Amount spent on  for Awesome Bronze Bags: " + totalAmount);
    }
}
