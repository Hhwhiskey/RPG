package com.kevinhodges.dragonborn.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kevinhodges.dragonborn.R;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        
        //UI Declarations///////////////////////////////////////////////////////////
        Button beginButton = (Button) findViewById(R.id.button_begin);
        ///////////////////////////////////////////////////////////////////////////
        
        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beginIntent = new Intent(InfoActivity.this, CampActivity.class);
                startActivity(beginIntent);
            }
        });
    }
}
