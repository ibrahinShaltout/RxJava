package com.example.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<Long> coldObservable  = Observable.intervalRange(0,5,0,1, TimeUnit.SECONDS);
        coldObservable.subscribe(i-> Log.d(TAG, "onCreate: Student One:"+ i));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        coldObservable.subscribe(i-> Log.d(TAG, "onCreate: Student Two:"+ i));
    }
}
