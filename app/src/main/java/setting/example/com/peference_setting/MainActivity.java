package setting.example.com.peference_setting;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.prefs.Preferences;


public class MainActivity extends ActionBarActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button preferencesButton1 = (Button) findViewById(R.id.preferences1);
        preferencesButton1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent settingsActivity = new Intent(getBaseContext(),
                        Preferences.class);
                startActivity(settingsActivity);
            }
        });

        Button preferencesButton2 = (Button) findViewById(R.id.preferences2);
        preferencesButton2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent settingsActivity = new Intent(getBaseContext(),
                        Preferences3.class);
                startActivity(settingsActivity);
            }
        });

        Button preferencesButton3 = (Button) findViewById(R.id.preferences3);
        preferencesButton3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent settingsActivity = new Intent(getBaseContext(),
                        Preferences4.class);
                startActivity(settingsActivity);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }}
