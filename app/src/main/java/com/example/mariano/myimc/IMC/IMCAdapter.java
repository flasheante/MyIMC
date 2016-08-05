package com.example.mariano.myimc.IMC;

import android.widget.BaseAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mariano.myimc.R;

import java.util.List;

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
