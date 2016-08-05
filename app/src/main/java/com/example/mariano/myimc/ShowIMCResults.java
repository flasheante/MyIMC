package com.example.mariano.myimc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mariano.myimc.IMC.IMC;
import com.example.mariano.myimc.IMC.IMCFactory;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.NumberFormat;

public class ShowIMCResults extends AppCompatActivity {

    private String user_height;
    private String user_weight;
    private String user_message;
    private String user_IMC;
    private String user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_imcresults);
        user_height = (String) getIntent().getSerializableExtra("user_height");
        user_weight = (String) getIntent().getSerializableExtra("user_weight");
        double heightm = Double.parseDouble(user_height) / 100;
        double imc = Double.parseDouble(user_weight) / Math.pow(heightm, 2);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        user_IMC = nf.format(imc);
        if (imc >= 25) {
            user_message = "Tu IMC está arriba de lo Normal.";
        } else if (imc <= 18.5) {
            user_message = "Tu IMC está debajo de lo Normal.";
        } else {
            user_message = "Tu IMC está bien.";
        }
        ((TextView) findViewById(R.id.user_input_message)).setText(user_message);
        ((TextView) findViewById(R.id.user_input_imc)).setText(user_IMC);
        ((TextView) findViewById(R.id.user_input_height)).setText(user_height);
        ((TextView) findViewById(R.id.user_input_weight)).setText(user_weight);
    }

    public void saveIMC(View view) {
        EditText user_input_name = (EditText) findViewById(R.id.user_name);
        IMC newIMC = new IMC();
        newIMC.setUserName(user_input_name.getText().toString());
        newIMC.setUserWeight(user_weight);
        newIMC.setUserHeight(user_height);
        newIMC.setUserIMC(user_IMC);
        newIMC.setUserMessage(user_message);
        if(!IMCFactory.getInstance(getApplicationContext()).addIMC(newIMC)){
            Toast.makeText(getApplicationContext(), "Falló la creación", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(getApplicationContext(), SaveIMCResults.class);
            startActivity(intent);
        }
    }
}
