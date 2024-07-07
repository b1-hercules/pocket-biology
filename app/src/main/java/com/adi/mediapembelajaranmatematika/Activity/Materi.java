package com.adi.mediapembelajaranmatematika.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.ParcelFileDescriptor;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.webkit.WebChromeClient;
import android.widget.LinearLayout;

import com.adi.mediapembelajaranmatematika.R;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Materi extends AppCompatActivity {
   // private PDFView pdfView;
    private LinearLayout linearImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        linearImage = findViewById(R.id.linear_image);
       // pdfView =  findViewById(R.id.pdfView);
         Button btnOpenVideo = findViewById(R.id.btn_open_video);
        ImageView btnKembali = findViewById(R.id.btn_kembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Go back to the previous activity
            }
        });

       btnOpenVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=pRLzqHAWTcs&ab_channel=GIAAcademy"));
                startActivity(intent);
            }
        });


        WebView webView = findViewById(R.id.webview);

        String frameVideo = "<html><body><iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/pRLzqHAWTcs\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        webView.loadData(frameVideo, "text/html","utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

     //   readPdf();
        readImageAsset();
    }

    private void readImageAsset() {
        for (int i = 0; i < 27; i++) {
            AssetManager assetManager = getAssets();
            ImageView imageView = new ImageView(this);
            String name = String.valueOf(i+1);
            try (
                    //declaration of inputStream in try-with-resources statement will automatically close inputStream
                    // ==> no explicit inputStream.close() in additional block finally {...} necessary
                    InputStream inputStream = assetManager.open("materi/"+name+".jpg")
            ) {
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setAdjustViewBounds(true);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                linearImage.addView(imageView);
            } catch (IOException ex) {
                //ignored
            }
        }


    }

}
