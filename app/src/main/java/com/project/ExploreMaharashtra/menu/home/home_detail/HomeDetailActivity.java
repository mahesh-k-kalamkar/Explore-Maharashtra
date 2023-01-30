package com.project.ExploreMaharashtra.menu.home.home_detail;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.ExploreMaharashtra.R;
import com.project.ExploreMaharashtra.menu.Constants.Constants;

public class HomeDetailActivity extends AppCompatActivity {
    private ImageButton buttonBack, likedHeart, DislikedHeart;
    private TextView title;
    private TextView location;
    private ImageView detailpageImg;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
        setContentView(R.layout.activity_home_detail);

        buttonBack = findViewById(R.id.button_back);
        DislikedHeart = findViewById(R.id.DislikedHeart);
        likedHeart = findViewById(R.id.likedHeart);
        title = findViewById(R.id.txt_title);
        location = findViewById(R.id.txt_location);
        detailpageImg = findViewById(R.id.detailpageImg);


        buttonBack.setOnClickListener(view -> onBackPressed());


        title.setText(Constants.TitleForDetailPage);
        location.setText(Constants.LocationForDetailPage);
        detailpageImg.setImageResource(Constants.ImageForDetailPage);

    }

    @SuppressLint("ObsoleteSdkInt")
    private void hideStatusBar() {
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getWindow().getDecorView().setSystemUiVisibility(3328);
            } else {
                requestWindowFeature(Window.FEATURE_NO_TITLE);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void liked(View view) {
        DislikedHeart.setVisibility(View.VISIBLE);
        likedHeart.setVisibility(View.GONE);
    }

    public void Disliked(View view) {
        likedHeart.setVisibility(View.VISIBLE);
        DislikedHeart.setVisibility(View.GONE);
    }
}