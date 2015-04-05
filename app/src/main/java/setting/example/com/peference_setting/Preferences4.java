package setting.example.com.peference_setting;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Madasamy on 05-04-2015.
 */
public class Preferences4 extends Activity
{
    private EditText prefEditText;
    private CheckBox prefCheckbox;
    private RadioGroup prefRadioGroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre);

        SharedPreferences customSharedPreference = getSharedPreferences("myCustomSharedPrefs", Activity.MODE_PRIVATE);

        prefEditText = (EditText) findViewById(R.id.editText1);
        prefEditText.setText(customSharedPreference.getString("myEditTextPref", ""));

        prefCheckbox = (CheckBox) findViewById(R.id.checkBox1);
        prefCheckbox.setChecked(customSharedPreference.getBoolean("myCheckBoxPref", false));

        prefRadioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioButton radioButton0 = (RadioButton) findViewById(R.id.radio0);
        prefRadioGroup.check(customSharedPreference.getInt("myRadioGroupPref",radioButton0.getId()));

        Button mClose = (Button)findViewById(R.id.close);
        mClose.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                finish();
            }
        });

        Button mSave = (Button)findViewById(R.id.save);
        mSave.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                savePreferences();
                finish();
            }
        });

    }

    private void savePreferences(){

        SharedPreferences customSharedPreference = getSharedPreferences("myCustomSharedPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = customSharedPreference.edit();
        editor.putString("myEditTextPref", prefEditText.getText().toString());
        editor.putBoolean("myCheckBoxPref",prefCheckbox.isChecked());
        editor.putInt("myRadioGroupPref", prefRadioGroup.getCheckedRadioButtonId());
        editor.commit();

        RadioButton radioButton = (RadioButton) findViewById(prefRadioGroup.getCheckedRadioButtonId());
        Log.v("Preferences:", "Radio Text: " + radioButton.getText());
    }
}
