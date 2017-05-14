package com.example.quoctuan.json;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 * Created by Admin on 4/28/2017.
 */

public class GetDataFromURL {

    public static String getDataFromURL(String url) {
                String result = "";
                int CONNECT_TIMEOUT = 6000;
                int SOCKET_TIMEOUT = 60000;
                HttpParams httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(httpParams, CONNECT_TIMEOUT);
                HttpConnectionParams.setSoTimeout(httpParams, SOCKET_TIMEOUT);


                HttpClient httpClient = new DefaultHttpClient(httpParams);
                HttpGet httpGet = new HttpGet(url);
                try {
                        HttpResponse httpResponse = httpClient.execute(httpGet);
                        if (httpResponse != null) {
                                InputStream inputStream = httpResponse.getEntity().getContent();
                                result = convertStreamToString(inputStream);
                            }
                    }
                catch (ConnectTimeoutException cx) {
                        result = "connection timeout";
                    }
                catch (SocketTimeoutException sx) {
                        result = "socket timeout";
                    }

                        catch (Exception ex) {
                        result = "exception timeout";
                    }
                return result;
            }

    public static String convertStreamToString(InputStream inputStream) {
        String line = "";
        StringBuilder builder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
                while ((line = bufferedReader.readLine()) != null) {
                        builder.append(line);
                }
            } catch (Exception ex) {

                }
            return builder.toString();
        }

         public static Drawable loadImageFromWebOperations(String url) {
            try {
                    InputStream is = (InputStream) new URL(url).getContent();
                    Drawable d = Drawable.createFromStream(is, "src name");
                    return d;
                } catch (Exception ex) {
                    System.out.println("Exc = " + ex);
                    return null;
                }
        }
    public static void setBitmapToImage (final String url, final ImageView imageView) {
        final Handler handler = new Handler() {
         @Override
         public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Drawable flag = (Drawable) msg.obj;
            if (flag != null) {
                imageView.setImageDrawable(flag);
                }
            }
         };

        try {
                Thread thread = new Thread() {
                @Override
                public void run() {
                                    super.run();
                                    Drawable drawable = loadImageFromWebOperations(url);
                                   Message msg = new Message();
                                    msg.obj = drawable;
                                    handler.sendMessage(msg);
                                }
                };
                        thread.start();
            } catch (Exception ex) {

                }
            }
    }

