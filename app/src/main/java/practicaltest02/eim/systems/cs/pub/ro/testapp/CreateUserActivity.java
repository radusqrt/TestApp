package practicaltest02.eim.systems.cs.pub.ro.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CreateUserActivity extends AppCompatActivity {

    boolean male = true;
    private EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        userName = (EditText) findViewById(R.id.username);
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
        finish();
    }

    @Override
    public void finish() {
        Intent intent = new Intent();

        intent.putExtra(User.USER_NAME, userName.getText().toString());
        // TODO replace with real value
        intent.putExtra(User.USER_GENDER, true); // hard-code value for testing

        setResult(RESULT_OK, intent);
        super.finish();
    }
}
