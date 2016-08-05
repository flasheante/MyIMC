package com.example.mariano.myimc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void saveIMC(View view) {
        //Intent newView = new Intent(this,SaveIMCResults.class);
        EditText user_input_name = (EditText) findViewById(R.id.user_name);


        IMCFactory.getInstance(this).addIMC(new IMC(
                user_input_name.toString(),
                user_height.toString(),
                user_weight.toString(),
                user_IMC.toString(),
                user_message.toString()
        ));

        //onBackPressed();
        /*newView.putExtra("user_height", user_height);
        newView.putExtra("user_weight",user_weight);
        newView.putExtra("user_message",user_message);
        newView.putExtra("user_IMC",user_IMC);
        newView.putExtra("user_name",user_name);
        startActivity(newView);*/
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ShowIMCResults Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.mariano.myimc/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ShowIMCResults Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.mariano.myimc/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
