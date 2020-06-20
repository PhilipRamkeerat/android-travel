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

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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
        BigDecimal packagePrice = packageForBind.getPrice();
        NumberFormat brazilianFormat = DecimalFormat.getCurrencyInstance(
                new Locale("pt", "br"));
        String brazilianCoin = brazilianFormat.format(packagePrice).replace("R$", "R$ ");
        price.setText(brazilianCoin);
    }

    private void showDays(View viewCreated, Package packageForBind) {
        // Days
        TextView days = viewCreated.findViewById(R.id.item_pacote_dias);
        String daysText = "";
        int quantityOfDays = packageForBind.getDays();
        if (quantityOfDays > 1) {
            daysText = quantityOfDays + " days";
        } else {
            daysText = quantityOfDays + " day";
        }
        days.setText(daysText);
    }

    private void showImage(View viewCreated, Package packageForBind) {
        // Image bind
        ImageView image = viewCreated.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idOfDrawable = resources.getIdentifier(packageForBind.getImage()
                , "drawable", context.getPackageName());
        Drawable drawableImagePackage = resources.getDrawable(idOfDrawable);
        image.setImageDrawable(drawableImagePackage);
    }

    private void showLocal(View viewCreated, Package packageForBind) {
        TextView local = viewCreated.findViewById(R.id.item_pacote_local);
        local.setText(packageForBind.getLocal());
    }
}
