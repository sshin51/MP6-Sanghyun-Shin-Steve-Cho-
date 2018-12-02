package com.example.android.finalprojecttry1;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.finalprojecttry1.R;

import java.util.Random;

public class finalQ extends AppCompatActivity {
    private static int wrongCounter = firstQ.wrongCounter;
    private int presCounter = 0;
    private int maxPressCounter = 8;
    private String[] keys = {"E","L", "M", "N", "O", "C", "U", "E", "L"};
    private String textAnswer = "MOLECULE";
    TextView textScreen, textQuestion, textTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_q);

        keys = shuffleArray(keys);

        for(String key : keys) {
            addView(((LinearLayout) findViewById(R.id.layoutParent)), key, ((EditText) findViewById(R.id.editText)));
        }
        maxPressCounter = 8;
    }

    private String[] shuffleArray(String[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }
    private void doValidate() {
        presCounter = 0;
        EditText editText = findViewById(R.id.editText);
        LinearLayout linearLayout = findViewById(R.id.layoutParent);

        if(editText.getText().toString().equals(textAnswer)) {
            Toast.makeText(finalQ.this, "Correct", Toast.LENGTH_SHORT).show();
            editText.setText("");
            Intent a = new Intent(finalQ.this, win.class);
            startActivity(a);
        } else {
            wrongCounter--;
            if (wrongCounter == 0) {
                Intent b = new Intent(finalQ.this, Fail.class);
                startActivity(b);
            }
            Toast.makeText(finalQ.this, "Wrong! Lives: " + String.valueOf(wrongCounter), Toast.LENGTH_SHORT).show();
            editText.setText("");
        }
        keys = shuffleArray(keys);
        linearLayout.removeAllViews();
        for (String key : keys) {
            addView(linearLayout, key, editText);
        }
    }
    private void addView(LinearLayout viewParent, final String text, final EditText editText) {
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        linearLayoutParams.rightMargin = 20;

        final TextView textView = new TextView(this);
        textView.setLayoutParams(linearLayoutParams);
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(32);

        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textScreen = (TextView) findViewById(R.id.textScreen);
        textTitle = (TextView) findViewById(R.id.textTitle);
        textQuestion.setTypeface(Typeface.DEFAULT);
        textScreen.setTypeface(Typeface.DEFAULT);
        textTitle.setTypeface(Typeface.DEFAULT);
        editText.setTypeface(Typeface.DEFAULT);
        textView.setTypeface(Typeface.DEFAULT);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presCounter < maxPressCounter) {
                    if (presCounter == 0)
                        editText.setText("");
                    editText.setText(editText.getText().toString() + text);
                    textView.animate().alpha(0).setDuration(300);
                    presCounter++;
                    if (presCounter == maxPressCounter)
                        doValidate();
                }
            }
        });

        viewParent.addView(textView);

    }

}
