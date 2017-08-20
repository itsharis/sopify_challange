package shopify.test.com.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by haris on 8/20/17.
 */

public class RequestHandler {


    /**
     * This method makes a request to the given server using the OkHTTP library. Implemented
     * so that on method takes care of the entire call
     * @param url IRL location of the JSON object
     * @return Nothing
     * @throws IOException
     */
    public static JSONObject makeRequest (String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return new JSONObject(response.body().string());
        } catch (JSONException e){
            e.printStackTrace();
        }

        return null;
    }

}
