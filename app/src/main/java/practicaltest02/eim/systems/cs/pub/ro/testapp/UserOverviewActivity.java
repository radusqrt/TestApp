package practicaltest02.eim.systems.cs.pub.ro.testapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserOverviewActivity extends AppCompatActivity {

    public static final int SUB_ACTIVITY_CREATE_USER = 10;
    public static final int SUB_ACTIVITY_LEARN = 20;
    private User user;
    private boolean userExists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_overview);

        // if no user found, create a new one
        if (!userExists) {
            Intent intent = new Intent(this, CreateUserActivity.class);
            startActivityForResult(intent, SUB_ACTIVITY_CREATE_USER);
        } else {
            updateUserInterface();
        }
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, LearnActivity.class);
        intent.putExtra(User.USER_SKILL_POINTS, user.skillPoints);
        startActivityForResult(intent, SUB_ACTIVITY_LEARN);
    }

    public void onShare(View view) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, user.skillPoints);

        startActivity(sharingIntent);
    }

    // This is the callback for the started sub-activities
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SUB_ACTIVITY_CREATE_USER && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                String name = extras.getString(User.USER_NAME);
                boolean gender = extras.getBoolean(User.USER_GENDER);
                user = new User(name, gender);
                userExists = true;
                updateUserInterface();
            }
        } else if (resultCode == RESULT_OK && requestCode == SUB_ACTIVITY_LEARN) {
            if (data.hasExtra("skillLevel")) {
                int result = data.getExtras().getInt("skillLevel");
                user.skillPoints = result;
                Toast.makeText(this, "New Skill level " + String.valueOf(result),
                        Toast.LENGTH_SHORT).show();
                updateUserInterface();
            }
        }
    }

    private void updateUserInterface() {
        EditText username = (EditText) findViewById(R.id.username);
        username.setText(user.name);
        TextView userpoints = (TextView) findViewById(R.id.userpoints);
        userpoints.setText(String.valueOf(user.skillPoints) + " points");
    }


}