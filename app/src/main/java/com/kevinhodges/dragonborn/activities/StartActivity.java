package com.kevinhodges.dragonborn.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.kevinhodges.dragonborn.R;

public class StartActivity extends AppCompatActivity {

    private TextView beginTextView;
    private TextView continueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //UI Declarations///////////////////////////////////////////////////////////
        beginTextView = (TextView) findViewById(R.id.tv_begin);
        continueTextView = (TextView) findViewById(R.id.tv_continue);
        ///////////////////////////////////////////////////////////////////////////

        beginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beginIntent = new Intent(StartActivity.this, RaceSelectActivity.class);
                startActivity(beginIntent);
            }
        });

    }

}
