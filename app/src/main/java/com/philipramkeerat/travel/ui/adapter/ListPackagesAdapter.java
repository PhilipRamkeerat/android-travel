package com.philipramkeerat.travel.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

        // get package for bind process
        Package packageForBind = packages.get(position);

        TextView local = viewCreated.findViewById(R.id.item_pacote_local);
        local.setText(packageForBind.getLocal());

        // Image bind
        ImageView image = viewCreated.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idOfDrawable = resources.getIdentifier(packageForBind.getImage()
                , "drawable", context.getPackageName());
        Drawable drawableImagePackage = resources.getDrawable(idOfDrawable);
        image.setImageDrawable(drawableImagePackage);

        TextView days = viewCreated.findViewById(R.id.item_pacote_dias);
        days.setText(packageForBind.getDays() + " days");

        TextView price = viewCreated.findViewById(R.id.item_pacote_preco);
        price.setText(packageForBind.getPrice().toString());

        return viewCreated;
    }
}
