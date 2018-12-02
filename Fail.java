package com.example.android.finalprojecttry1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);
    }
    public void browser(View view) {
        Intent browserIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/Merriam-Webster-Dictionary-New-2016/dp/087779295X/ref=sr_1_2?ie=UTF8&qid=1543737428&sr=8-2&keywords=dictionary"));
        startActivity(browserIntent);
    }
    public void restart(View view) {
        Intent c = new Intent(Fail.this, firstQ.class);
        firstQ.wrongCounter = 5;
        startActivity(c);
    }
}
