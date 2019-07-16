package com.example.hwx631346.myapplication;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private HttpResponse<JsonNode> response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.bt);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt:
                new DownloadUrl().execute();
                break;

        }
    }


    private class DownloadUrl extends AsyncTask<String, Void, HttpResponse<JsonNode>> {
        @Override
        protected HttpResponse<JsonNode> doInBackground(String... params) {

            return getUrlData();
        }

        @Override
        protected void onPostExecute(HttpResponse<JsonNode> response) {
            Log.d("linsheng", "onPostExecute: " + response.getBody());
        }
    }

    private HttpResponse<JsonNode> getUrlData() {

        try {
            response = Unirest.get("https://love-calculator.p.rapidapi.com/getPercentage?fname=fangman&sname=hulinsheng")
                    .header("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "f9f933997dmsh2a210bfd2ae5d48p107477jsn9540cb2ef437")
                    .asJson();
            Log.d("linsheng", "onClick: " + response);
        } catch (UnirestException e) {
            e.printStackTrace();
            Log.d("linsheng", "onClick:aaaaaaaaaaaaa " + e.getMessage());
        }
        return response;
    }

}
