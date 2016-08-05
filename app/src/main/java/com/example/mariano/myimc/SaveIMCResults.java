package com.example.mariano.myimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SaveIMCResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_imcresults);
        Bundle information = getIntent().getExtras();
        ((TextView) findViewById(R.id.user_height)).setText(information.getString("user_height"));
        ((TextView) findViewById(R.id.user_weight)).setText(information.getString("user_weight"));
        ((TextView) findViewById(R.id.user_IMC)).setText(information.getString("user_IMC"));
        ((TextView) findViewById(R.id.user_message)).setText(information.getString("user_message"));
    }
}
