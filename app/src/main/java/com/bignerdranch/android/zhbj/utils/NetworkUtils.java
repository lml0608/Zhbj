package com.bignerdranch.android.zhbj.utils;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by liubin on 2017/5/2.
 */

public class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();


    private static final String SERVER_URL = "http://192.168.1.102:8080/zhbj";

    public static final String CATEGORY_URL = SERVER_URL + "/categories.json";





    /**
     * Builds the URL used to talk to the weather server using a location. This location is based
     * on the query capabilities of the weather provider that we are using.
     *
     * @param locationQuery The location that will be queried for.
     * @return The URL to use to query the weather server.
     */
//    public static URL buildUrl(String locationQuery) {
//        Uri builtUri = Uri.parse(FORECAST_BASE_URL).buildUpon()
//                .appendQueryParameter(QUERY_PARAM, locationQuery) //q=locationQuery
//                .appendQueryParameter(FORMAT_PARAM, format) //mode = json
//                .appendQueryParameter(UNITS_PARAM, units) //units = metric
//                .appendQueryParameter(DAYS_PARAM, Integer.toString(numDays)) //cnt = 14
//                .build();
//        //https://andfun-weather.udacity.com/staticweather?q=locationQuery&mode=json&units=metric&cnt=14
//
//        URL url = null;
//        try {
//            url = new URL(builtUri.toString());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        Log.v(TAG, "Built URI " + url);
//
//        return url;
//    }

    public static void sendOkHttpRequest(String url, okhttp3.Callback callback) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }



    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
