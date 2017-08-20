package shopify.test.com.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.os.AsyncTask.THREAD_POOL_EXECUTOR;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetworkTask task = new NetworkTask();
        task.setTextView((TextView)findViewById(R.id.result));
        task.executeOnExecutor(THREAD_POOL_EXECUTOR);
    }
}
