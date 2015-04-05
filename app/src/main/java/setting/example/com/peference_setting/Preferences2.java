package setting.example.com.peference_setting;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

/**
 * Created by Madasamy on 05-04-2015.
 */
public class Preferences2 extends PreferenceActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new PrefsFragment()).commit();
        PreferenceManager.setDefaultValues(Preferences2.this, R.xml.preferences, false);

    }

    public static class PrefsFragment extends PreferenceFragment
    {

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences2);
        }
    }
}
