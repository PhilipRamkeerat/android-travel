package com.philipramkeerat.travel.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.philipramkeerat.travel.R;
import com.philipramkeerat.travel.model.Package;
import com.philipramkeerat.travel.util.CoinUtil;
import com.philipramkeerat.travel.util.DaysUtil;
import com.philipramkeerat.travel.util.ResourceUtil;

import java.util.List;

public class ListPackagesAdapter extends BaseAdapter {

    private final List<Package> packages;
    private final Context context;

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

        showLocal(viewCreated, packageForBind);
        showImage(viewCreated, packageForBind);
        showDays(viewCreated, packageForBind);
        showPrice(viewCreated, packageForBind);

        return viewCreated;
    }

    private void showPrice(View viewCreated, Package packageForBind) {
        // Price
        TextView price = viewCreated.findViewById(R.id.item_pacote_preco);
        String brazilianCoin = CoinUtil.formatForBrazilian(packageForBind.getPrice());
        price.setText(brazilianCoin);
    }


    private void showDays(View viewCreated, Package packageForBind) {
        // Days
        TextView days = viewCreated.findViewById(R.id.item_pacote_dias);
        String daysText = DaysUtil.formatInText(packageForBind.getDays());
        days.setText(daysText);
    }

    private void showImage(View viewCreated, Package packageForBind) {
        // Image bind
        ImageView image = viewCreated.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagePackage = ResourceUtil.returnDrawable(context, packageForBind.getImage());
        image.setImageDrawable(drawableImagePackage);
    }

    private void showLocal(View viewCreated, Package packageForBind) {
        TextView local = viewCreated.findViewById(R.id.item_pacote_local);
        local.setText(packageForBind.getLocal());
    }
}
