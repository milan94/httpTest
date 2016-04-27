package com.example.milan.httptest;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Connection;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MyTask().execute();

    }
    private class MyTask extends AsyncTask<Integer, Integer,String> {
        @Override
        protected String doInBackground(Integer... params) {
            try

            {
                URL url = new URL("http://android.ogosense.net/interns/milan/test.php");
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                System.out.println(connection.getResponseCode());

            }
            catch(Exception e){
                System.out.println(e.toString());
            }
            return "";
        }
        @Override
        protected void onPostExecute(String result) {

        }
        @Override

        protected void onProgressUpdate(Integer... pro) {


        }
    }
}

