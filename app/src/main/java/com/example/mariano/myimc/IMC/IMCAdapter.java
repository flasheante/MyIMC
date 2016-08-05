package com.example.mariano.myimc.IMC;

import android.content.ClipData;
import android.widget.BaseAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mariano.myimc.R;

import java.util.List;
import java.util.logging.StreamHandler;

/**
 * Created by Mariano on 3/8/16.
 */
public class IMCAdapter extends BaseAdapter {

    private List<IMC> imcs;

    public IMCAdapter(List<IMC> imcs) {
        this.imcs = imcs;
    }
    @Override
    public int getCount()  {
        return imcs.size();
    }

    @Override
    public IMC getItem(int position) {
        return imcs.get(position);
    }
    @Override
    public long getItemId(int position)  {
        return imcs.get(position).getMyId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View currentView;

        if (convertView == null) {
            currentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_save_imcresults, parent, false);
        } else {
            currentView = convertView;
        }

        IMC imc = getItem(position);

        TextView userName = (TextView) currentView.findViewById(R.id.user_name);
        TextView userWeight = (TextView) currentView.findViewById(R.id.user_weight);
        TextView userIMC = (TextView) currentView.findViewById(R.id.user_IMC);
        TextView userMessage = (TextView) currentView.findViewById(R.id.user_message);

        userName.setText(String.valueOf(imc.getUserName()));
        userWeight.setText(String.valueOf(imc.getUserWeight()));
        userIMC.setText(String.valueOf(imc.getUserIMC()));
        userMessage.setText(String.valueOf(imc.getUserMessage()));
        return currentView;
    }

    public void setNewElements(List<IMC> newElements) {
        imcs = newElements;
    }
}
