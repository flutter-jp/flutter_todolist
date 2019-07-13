package com.example.orc_demo;

import android.os.Build;
import android.os.Bundle;

import com.example.orc_demo.util.ImageUtil;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.orc_demo.ui.main.SectionsPagerAdapter;
import com.youdao.ocr.online.ImageOCRecognizer;
import com.youdao.ocr.online.OCRListener;
import com.youdao.ocr.online.OCRParameters;
import com.youdao.ocr.online.OCRResult;
import com.youdao.ocr.online.OcrErrorCode;
import com.youdao.sdk.app.YouDaoApplication;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        YouDaoApplication.init(this, "466d4e9deb09a865");
//
//        //OCR识别
//        OCRParameters tps = new OCRParameters.Builder()
//                .source("youdaoocr").timeout(100000)
//                .type("10011").lanType("ja ").build();
//        String base64 = ImageUtil.loadAsBase64("a.png");
//        ImageOCRecognizer.getInstance(tps).recognize(base64,
//                new OCRListener() {
//
//                    @Override
//                    public void onResult(OCRResult result,
//                                         String input) {
//                        //识别成功
//                    }
//
//                    @Override
//                    public void onError(OcrErrorCode error) {
//                        //识别失败
//                    }
//                });


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }
}