package com.example.ghopkins.circularprogressbar;


import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import at.grabner.circleprogress.CircleProgressView;
import at.grabner.circleprogress.TextMode;

public class MainActivity extends AppCompatActivity {

    CircleProgressView mCircleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCircleView = (CircleProgressView) findViewById(R.id.circleView);
        mCircleView.setOnProgressChangedListener(new CircleProgressView.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(float value) {
                Log.d("MainActivity", "Progress Changed: " + value);
            }
        });

        mCircleView.setValue(100);
        mCircleView.setText("30");
        mCircleView.setTextMode(TextMode.TEXT);


        mCircleView.setUnitVisible(false);

        mCircleView.setTextColor(Color.GREEN);
        mCircleView.setBarColor(Color.GREEN);
        mCircleView.setRimColor(Color.LTGRAY);


         CountDownTimer countDownTimer = new CountDownTimer(45000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {

                mCircleView.setValueAnimated(millisUntilFinished/1000);
                mCircleView.setText(String.valueOf(millisUntilFinished/1000));

                if (millisUntilFinished/1000 <= 30 && millisUntilFinished/1000 >15){
                    mCircleView.setTextColor(Color.YELLOW);
                    mCircleView.setBarColor(Color.YELLOW);
                };
                if(millisUntilFinished/1000 <=15){
                    mCircleView.setTextColor(Color.RED);
                    mCircleView.setBarColor(Color.RED);
                };
            }

            @Override
            public void onFinish() {

            }
        };

        countDownTimer.start();





    }
}
