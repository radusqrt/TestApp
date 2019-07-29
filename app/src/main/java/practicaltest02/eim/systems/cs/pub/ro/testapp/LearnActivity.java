package practicaltest02.eim.systems.cs.pub.ro.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class LearnActivity extends AppCompatActivity implements View.OnClickListener {

    private int skillLevel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        List<Integer> buttons = Arrays.asList(R.id.one, R.id.two, R.id.three,
                R.id.four, R.id.five, R.id.six, R.id.seven,
                R.id.eight, R.id.nine, R.id.zero, R.id.delete);
        for (Integer i : buttons) {
            View b = findViewById(i);
            b.setOnClickListener(this); // calling onClick() method
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                skillLevel = 1;
                break;
            case R.id.two:
                skillLevel = 2;
                break;
            case R.id.three:
                skillLevel = 3;
                break;
            case R.id.four:
                skillLevel = 4;
                break;
            case R.id.five:
                skillLevel = 5;
                break;
            case R.id.six:
                skillLevel = 6;
                break;
            case R.id.seven:
                skillLevel = 7;
                break;
            case R.id.eight:
                skillLevel = 8;
                break;
            case R.id.nine:
                skillLevel = 9;
                break;
            case R.id.zero:
                skillLevel = 0;
                break;
            case R.id.delete:
                skillLevel = -1;
                break;
        }
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("skillLevel", skillLevel);
        setResult(RESULT_OK, intent);
        super.finish();
    }
}