package com.adi.mediapembelajaranmatematika.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.adi.mediapembelajaranmatematika.R;
import com.github.barteksc.pdfviewer.PDFView;

public class KompetensiDasar extends AppCompatActivity {

    private ImageView btn_kembali;
    private PDFView  pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kompetensi_dasar);
        pdfView =  findViewById(R.id.pdfView);
        init();
        readPdf();
    }

    private void readPdf() {
        pdfView.fromAsset("bahan_materi.pdf")
                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                // allows to draw something on the current page, usually visible in the middle of the screen
              /*  .onDraw(onDrawListener)
                // allows to draw something on all pages, separately for every page. Called only for visible pages
                .onDrawAll(onDrawListener)
                .onLoad(onLoadCompleteListener) // called after document is loaded and starts to be rendered
                .onPageChange(onPageChangeListener)
                .onPageScroll(onPageScrollListener)
                .onError(onErrorListener)
                .onPageError(onPageErrorListener)
                .onRender(onRenderListener) // called after document is rendered for the first time
                // called on single tap, return true if handled, false to toggle scroll handle visibility
                .onTap(onTapListener)
                .onLongPress(onLongPressListener)*/
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
               // .autoSpacing(false) // add dynamic spacing to fit each page on its own on the screen
             /*   .linkHandler(DefaultLinkHandler)
                .pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view*/
              //  .fitEachPage(false) // fit each page to the view, else smaller pages are scaled relative to largest page.
             //   .pageSnap(false) // snap pages to screen boundaries
               // .pageFling(false) // make a fling change only a single page like ViewPager
               // .nightMode(false) // toggle night mode
                .load();
    }

    private void init() {

        btn_kembali = findViewById(R.id.btn_kembali);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KompetensiDasar.super.onBackPressed();
            }
        });
    }
}