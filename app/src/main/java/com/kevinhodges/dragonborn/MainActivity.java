package com.kevinhodges.dragonborn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRecyclerView;
    private ArrayList<String> raceList = new ArrayList<>();
    private ArrayList<String> chapter1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        raceList.add("From where do your people come?");
        raceList.add("Urth, the land of the Uman. Brave and courageous, these people make up the majority of Evon. The Uman have waged millennia of war against the Loken in defense of it's people. Though the Uman front is weakening from many years of war against the Loken and Risen, they have developed the strongest resilience in all of Avon - Uman have much higher health than the other races and have the ability to heal in combat.");
        raceList.add("Talion, home of the magical and secretive Faerie. Nearly wiped out by the Loken many years ago if not for the Uman assistance, Talion is only just now becoming what it once was. Although small in stature and only representing a very small portion of Evon's people, they are the most feared in Avon because of their mastery of black magic. Faerie also excel in areas of stealth and luck and have the ability to flee from combat.");
        raceList.add("Duunbar is the home of the Loken - massive brutes that thrive in combat and are driven by the destruction of Evon's people. Duunbar's proximity to Urth has allowed nearly 3 millenia of war between these two factions. The Loken have survived through their pillaging of Uman towns and homes. While not the most intelligent beings, their superior weapon training and size allows them to wield massive weapons at their foes.");
        raceList.add("Beneath Urth lie the Urthen Crypts, here rest the corpses of all ancient Urthen warriors. Crossed many years ago by the Uman King 'Uther', these warriors lie in wait for the day they may avenge their death. In an attempt at destroying Urth, Loken Shaman have raised them from the dead and forced them to wage war against the Urth and Talion. Although the Risen are fairly weak, the dead do not tire, they do not have the burden of stamina");
        raceList.add("Your adventure begins...");






        //UI Declarations///////////////////////////////////////////////////////////
        mainRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main);
        ///////////////////////////////////////////////////////////////////////////
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
}
