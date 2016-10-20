package com.aramlaka.hw6;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by akhil on 10/20/2016.
 */

public class GetForecast extends AsyncTask<String, Void, ArrayList<Forecast>> {

    SetForecast activity;
    ProgressDialog progressDialog;

    public GetForecast(SetForecast activity, ProgressDialog progressDialog) {
        this.activity = activity;
        this.progressDialog = progressDialog;
    }

    @Override
    protected ArrayList<Forecast> doInBackground(String... params) {
        InputStream in = null;

        try {
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int statusCode = con.getResponseCode();

            if(statusCode == HttpURLConnection.HTTP_OK){
                in = con.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                StringBuilder sb = new StringBuilder();

                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }

                return ForecastUtil.parseJSON(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Forecast> forecast) {
        progressDialog.hide();
        activity.setForecast(forecast);
    }

    public interface SetForecast {
        public void setForecast(ArrayList<Forecast> forecast);
    }
}


