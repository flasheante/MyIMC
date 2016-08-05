package com.example.mariano.myimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateIMC(View view){
        Intent newView = new Intent(this, ShowIMCResults.class);
        EditText userHeight = (EditText) findViewById(R.id.user_height);
        EditText userWeight = (EditText) findViewById(R.id.user_weight);
        newView.putExtra("user_height", userHeight.getText().toString());
        newView.putExtra("user_weight", userWeight.getText().toString());

        startActivity(newView);

    }
}
