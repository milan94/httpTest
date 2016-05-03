package com.example.milan.httptest;

import android.app.ProgressDialog;
import android.media.FaceDetector;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Connection;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    String var1="";
    String var2="";
    String string="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClick(View v){
        EditText evar1=(EditText) findViewById(R.id.editText3);
        EditText evar2=(EditText) findViewById(R.id.editText);
        EditText eop=(EditText) findViewById(R.id.editText2);
        var1=evar1.getText().toString();
        var2=evar2.getText().toString();
       // op=eop.getText().toString();

        new MyTask().execute();

    }
    private class MyTask extends AsyncTask<Integer, Integer,String> {
        @Override
        protected String doInBackground(Integer... params) {
            String result="";

            try

            {

                JSONObject json = new JSONObject();
                json.put("var1",var1);
                json.put("var2", var2);
                System.out.println(json.toString());
                String u="http://android.ogosense.net/interns/milan/calculation.php?json="+json.toString();
                URL url = new URL(u);
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();
             //   connection.setRequestMethod("GET");
             //   System.out.println(connection.getResponseCode());
                BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((result=reader.readLine())!=null)
                string+=result+"\n";

                System.out.println(string);
//                StringBuffer response=new StringBuffer();
//                String responseData=response.toString();
                return (string);
            }
            catch(Exception e){
                System.out.println(e.toString());
                return (string);
            }



        }
        @Override
        protected void onPostExecute(String result) {
            TextView textView=(TextView) findViewById(R.id.textView);
            textView.setText(result);
        }
        @Override

        protected void onProgressUpdate(Integer... pro) {


        }
    }
}

