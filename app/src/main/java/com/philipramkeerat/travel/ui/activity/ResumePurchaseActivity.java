package com.philipramkeerat.travel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.philipramkeerat.travel.R;
import com.philipramkeerat.travel.model.Package;
import com.philipramkeerat.travel.util.CoinUtil;
import com.philipramkeerat.travel.util.DateUtil;
import com.philipramkeerat.travel.util.ResourceUtil;

import java.math.BigDecimal;

public class ResumePurchaseActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_purchase);

        setTitle(TITLE_APPBAR);

        Package packageSaoPaulo = new Package("São Paulo", "sao_paulo_sp", 2, new BigDecimal("255.99"));

        showLocal(packageSaoPaulo);

        showImage(packageSaoPaulo);

        showData(packageSaoPaulo);

        showPrice(packageSaoPaulo);
    }

    private void showPrice(Package packageName) {
        TextView price = findViewById(R.id.resume_purchase_price);
        String brazilianCoin = CoinUtil.formatForBrazilian(packageName.getPrice());
        price.setText(brazilianCoin);
    }

    private void showData(Package packageName) {
        TextView data = findViewById(R.id.resume_purchase_date);
        String periodInText = DateUtil.periodToText(packageName.getDays());
        data.setText(periodInText);
    }

    private void showImage(Package packageName) {
        ImageView image = findViewById(R.id.resume_purchase_image_package);
        Drawable drawablePackage = ResourceUtil.returnDrawable(this, packageName.getImage());
        image.setImageDrawable(drawablePackage);
    }

    private void showLocal(Package packageName) {
        TextView local = findViewById(R.id.resume_purchase_local_package);
        local.setText(packageName.getLocal());
    }
}
