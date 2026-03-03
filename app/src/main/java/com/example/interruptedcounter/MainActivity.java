package com.example.interruptedcounter;

import android.os.Bundle;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private int mCounter = 0;
    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.count);

        // SABOTAGE : This will likely cause a NullPointerException if not handled .
        if(myTextView != null){
            myTextView.setText(String.valueOf(mCounter));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState (outState);
        outState.putInt("COUNT_KEY", mCounter);
    }

    @Override
    protected void onRestoreInstanceState (@NonNull Bundle savedInstanceState ) {
        super.onRestoreInstanceState ( savedInstanceState ) ;
        mCounter = savedInstanceState.getInt("COUNT_KEY") ;
        myTextView.setText(String.valueOf(mCounter)) ;
    }
}