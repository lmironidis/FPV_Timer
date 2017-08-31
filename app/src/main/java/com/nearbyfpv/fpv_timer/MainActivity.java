package com.nearbyfpv.fpv_timer;

import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer mChronometer;
    Button start, stop, reset, resume;

    private long timeWhenStopped = 0;
    private boolean stopClicked;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChronometer = (Chronometer) findViewById(R.id.Chronometer);
        start = (Button) findViewById(R.id.bStart);
        stop = (Button) findViewById(R.id.bStop);
        reset = (Button) findViewById(R.id.bReset);
        resume = (Button) findViewById(R.id.bResume);

        start.setVisibility(View.VISIBLE);
        stop.setVisibility(View.INVISIBLE);
        reset.setVisibility(View.INVISIBLE);
        resume.setVisibility(View.INVISIBLE);


    }

    public void StartButtonClick(View v) {
        mChronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        mChronometer.start();

        start.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.VISIBLE);
        reset.setVisibility(View.VISIBLE);


    }

    public void StopButtonClick(View v) {

        timeWhenStopped = mChronometer.getBase() - SystemClock.elapsedRealtime();
        mChronometer.stop();

        stop.setVisibility(View.INVISIBLE);
        reset.setVisibility(View.INVISIBLE);
        resume.setVisibility(View.VISIBLE);


    }


    public void ResetButtonClick(View v) {

        mChronometer.setBase(SystemClock.elapsedRealtime());
        timeWhenStopped = 0;
        mChronometer.stop();

        reset.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);
        start.setVisibility(View.VISIBLE);
    }

    public void ResumeButtonClick(View v) {

        /*
        timeWhenStopped = mChronometer.getBase() - SystemClock.elapsedRealtime();
        mChronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        mChronometer.start();
        */
        mChronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        mChronometer.start();

        resume.setVisibility(View.INVISIBLE);
        reset.setVisibility(View.VISIBLE);
        stop.setVisibility(View.VISIBLE);


    }




}
