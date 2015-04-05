package setting.example.com.peference_setting;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * Created by Madasamy on 05-04-2015.
 */
public class Preferences extends PreferenceActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new PrefsFragment()).commit();
        PreferenceManager.setDefaultValues(Preferences.this, R.xml.preferences, false);

    }

    public class PrefsFragment extends PreferenceFragment
    {

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

            // Get the custom preference
            Preference customPref = (Preference) findPreference("customPref");
            customPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

                public boolean onPreferenceClick(Preference preference) {
                    Toast.makeText(getBaseContext(), "The custom preference has been clicked",
                            Toast.LENGTH_LONG).show();
                    SharedPreferences customSharedPreference = getSharedPreferences(
                            "myCustomSharedPrefs", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = customSharedPreference.edit();
                    editor.putString("myCustomPref", "The preference has been clicked");
                    editor.commit();
                    return true;
                }

            });

        }

    }
}
