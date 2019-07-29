package practicaltest02.eim.systems.cs.pub.ro.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CreateUserActivity extends AppCompatActivity {

    boolean male = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton maleButton = (RadioButton) findViewById(R.id.radioButton);
        RadioButton femaleButton = (RadioButton) findViewById(R.id.radioFemale);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        male = true;
                        femaleButton.setAlpha(0.5f);
                        break;
                    case R.id.radioFemale:
                        male = false;
                        maleButton.setAlpha(0.5f);
                        break;
                }
            }
        });
    }

    public void onClick(View view) {
        EditText input = (EditText) findViewById(R.id.username);
        String string = input.getText().toString();

        Toast.makeText(this, "User " + string + " created. It's a " + (male == true ? "male" : "female") + ".",
                Toast.LENGTH_LONG).show();
    }
}
