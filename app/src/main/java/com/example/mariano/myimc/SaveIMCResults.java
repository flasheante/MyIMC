package com.example.mariano.myimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import com.example.mariano.myimc.IMC.IMCFactory;
import com.example.mariano.myimc.IMC.IMCAdapter;
public class SaveIMCResults extends AppCompatActivity {
    private ListView IMCList;
    private IMCFactory IMCFactory;
    private IMCAdapter IMCAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_imcresults);
        IMCList = (ListView) findViewById(R.id.ListOfIMC);
        IMCFactory = com.example.mariano.myimc.IMC.IMCFactory.getInstance(this);

        try{
            IMCAdapter = new IMCAdapter(IMCFactory.getIMCList());
            IMCList.setAdapter(IMCAdapter);
        }catch (Exception none){
            Log.e(SaveIMCResults.class.toString(), "something bad happened");
        }
    }
}
