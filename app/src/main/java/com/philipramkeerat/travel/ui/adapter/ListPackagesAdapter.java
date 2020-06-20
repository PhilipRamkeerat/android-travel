package com.philipramkeerat.travel.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.philipramkeerat.travel.R;
import com.philipramkeerat.travel.model.Package;

import java.util.List;

import static android.view.LayoutInflater.from;

public class ListPackagesAdapter extends BaseAdapter {

    private final List<Package> packages;
    private Context context;

    public ListPackagesAdapter(List<Package> packages, Context context) {
        this.packages = packages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return packages.size();
    }

    @Override
    public Object getItem(int position) {
        return packages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Create layout inflater, attachToRoot false for adapter create the view
        View viewCreated = LayoutInflater.from(context)
                .inflate(R.layout.item_package, parent, false);
        return viewCreated;
    }
}
