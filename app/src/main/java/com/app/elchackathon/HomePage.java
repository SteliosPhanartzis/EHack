package com.app.elchackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        WebView htmlWebView = (WebView)findViewById(R.id.webView);
        htmlWebView.setWebViewClient(new CustomWebViewClient());
        WebSettings webSetting = htmlWebView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);
        webSetting.setAllowContentAccess(true);
        webSetting.setAppCacheEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setUseWideViewPort(true);
        htmlWebView.loadUrl("https://www.adweek.com/brand-marketing/estee-lauders-origins-brand-asks-consumers-recycle-105597/");
        TextView pts = findViewById(R.id.points);
        getPts();
        FloatingActionButton cameraFab = (FloatingActionButton) findViewById(R.id.camera);
        cameraFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });



    }
    private class CustomWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    public void goToAnActivity(View view) {
        Intent intent = new Intent(this, StatPage.class);
        startActivity(intent);
    }
    public void goToAnActivity2(View view){
        Intent intent = new Intent(this, Donation.class);
        startActivity(intent);
    }
    public void goToAnActivity3(View view){
        Intent intent = new Intent(this, MapPage.class);
        startActivity(intent);
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        sendPic();
    }
    public void getPts(){
        final TextView pts = findViewById(R.id.points);
// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://refillestee.herokuapp.com/rewards?data=testuser@gmail.com";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            pts.setText(jsonObject.get("points").toString());
                        }
                        catch(JSONException e) {
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                return "failed";
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
    public void sendPic(){
// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String URL ="https://refillestee.herokuapp.com/rewards?data=testuser@gmail.com";
//        File file = new File("");
//        String imgurl = new String("https://raw.githubusercontent.com/SteliosPhanartzis/EHACK-Backend/master/pictures/barcodePic.jpg?token=AEMYO5ZZWO73VZCE7PUNKES5VNHWG");
//        Bitmap bm = BitmapFactory.decodeFile(imgurl);
//        ByteArrayOutputStream bao = new ByteArrayOutputStream();
//        bm.compress(Bitmap.CompressFormat.JPEG, 90, bao);
//        System.out.println(bao.toByteArray());
//        byte[] ba = bao.toByteArray();
//        try {
//            file = new File(imgurl.toURI());
//        }catch(Exception exc){}
//        final JSONObject jsonBody = new JSONObject();
//        try {
////            jsonBody.put("barcode", File = new File(new URL("http://google.com/logo.jpg")));
//            JsonObjectRequest jsonOblect = new JsonObjectRequest(Request.Method.POST, URL, new Response.Listener<JSONObject>() {
//                @Override
//                public void onResponse(JSONObject response) {
////                    System.out.println(jsonBody.toString());
//                    Toast.makeText(getApplicationContext(), "Response:  " + response.toString(), Toast.LENGTH_SHORT).show();
//                }
//            }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//
//                    onBackPressed();
//
//                }
//            });
//            queue.add(jsonOblect);

//        }
//        catch(JSONException ex){}
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(getApplicationContext(), "Response:  " + response.toString(), Toast.LENGTH_SHORT).show();
                        }
                        catch(JSONException e) {
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                return "failed";
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);


// Add the request to the RequestQueue.
        getPts();
    }
}
