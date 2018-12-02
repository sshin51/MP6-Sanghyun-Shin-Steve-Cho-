package com.example.android.finalprojecttry1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class win extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
    }
    public void restart(View view) {
        Intent c = new Intent(win.this, firstQ.class);
        firstQ.wrongCounter = 5;
        startActivity(c);
    }
}
