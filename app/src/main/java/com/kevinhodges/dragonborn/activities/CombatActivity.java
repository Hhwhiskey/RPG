package com.kevinhodges.dragonborn.activities;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.kevinhodges.dragonborn.R;
import com.kevinhodges.dragonborn.TitleActivity;
import com.kevinhodges.dragonborn.utils.MusicService;

public class CombatActivity extends AppCompatActivity {

    private static final String TAG = "Music";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Intent svc;
    private boolean isMusicPlaying;
    private boolean isActivityIntent;
    AlertDialog.Builder builder;
    private Button attackButton;
    private Button heroicButton;
    private Button potionsButton;
    private Button fleeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        builder = new AlertDialog.Builder(CombatActivity.this, R.style.MyAlertDialogStyle);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        editor = sharedPreferences.edit();

        isMusicPlaying = sharedPreferences.getBoolean("isMusicPlaying", false);

        //UI Declarations///////////////////////////////////////////////////////////
        attackButton = (Button) findViewById(R.id.button_attack);
        heroicButton = (Button) findViewById(R.id.button_heroic);
        potionsButton = (Button) findViewById(R.id.button_potions);
        fleeButton = (Button) findViewById(R.id.button_flee);
        ///////////////////////////////////////////////////////////////////////////



        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog attackDialog = new Dialog(CombatActivity.this);
                attackDialog.setContentView(R.layout.dialog_attack);

                Button weakAttackButton = (Button) attackDialog.findViewById(R.id.dialog_button_weak_attack);
                Button mediumAttackButton = (Button) attackDialog.findViewById(R.id.dialog_button_medium_attack);
                Button strongAttackButton = (Button) attackDialog.findViewById(R.id.dialog_button_strong_attack);

                weakAttackButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CombatActivity.this, "Weak attack", Toast.LENGTH_SHORT).show();
                        attackDialog.dismiss();
                    }
                });

                mediumAttackButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CombatActivity.this, "Medium attack", Toast.LENGTH_SHORT).show();
                        attackDialog.dismiss();
                    }
                });

                strongAttackButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CombatActivity.this, "Strong attack", Toast.LENGTH_SHORT).show();
                        attackDialog.dismiss();
                    }
                });

                attackDialog.show();

               /* builder.setTitle("Choose your Attack");
                builder.setMessage("Weak: 3 stamina \n Medium: 6 stamina \n Strong: 12 stamina");

                builder.setNeutralButton("Weak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CombatActivity.this, "Weak attack", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Medium", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CombatActivity.this, "Medium attack", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setPositiveButton("Strong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CombatActivity.this, "Strong attack", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();*/
            }
        });

        heroicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        potionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        fleeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "isMusicPlaying = " + isMusicPlaying);

        isActivityIntent = false;

        if (!isMusicPlaying) {
            svc = new Intent(this, MusicService.class);
            startService(svc);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (!isActivityIntent) {
            svc = new Intent(this, MusicService.class);
            stopService(svc);
            editor.putBoolean("isMusicPlaying", false);
            editor.commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isActivityIntent = true;

        Intent titleActivityIntent = new Intent(CombatActivity.this, TitleActivity.class);
        startActivity(titleActivityIntent);
    }


}