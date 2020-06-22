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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_purchase);

        setTitle("Resumo da compra");

        Package packageSaoPaulo = new Package("São Paulo", "sao_paulo_sp", 2, new BigDecimal("255.99"));

        TextView local = findViewById(R.id.resume_purchase_local_package);
        local.setText(packageSaoPaulo.getLocal());

        ImageView image = findViewById(R.id.resume_purchase_image_package);
        Drawable drawablePackage = ResourceUtil.returnDrawable(this, packageSaoPaulo.getImage());
        image.setImageDrawable(drawablePackage);

        TextView data = findViewById(R.id.resume_purchase_date);
        String periodInText = DateUtil.periodToText(packageSaoPaulo.getDays());
        data.setText(periodInText);

        TextView price = findViewById(R.id.resume_purchase_price);
        String brazilianCoin = CoinUtil.formatForBrazilian(packageSaoPaulo.getPrice());
        price.setText(brazilianCoin);
    }
}
