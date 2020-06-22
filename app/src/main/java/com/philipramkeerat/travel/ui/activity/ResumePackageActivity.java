package com.philipramkeerat.travel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.philipramkeerat.travel.R;
import com.philipramkeerat.travel.model.Package;
import com.philipramkeerat.travel.util.CoinUtil;
import com.philipramkeerat.travel.util.DateUtil;
import com.philipramkeerat.travel.util.DaysUtil;
import com.philipramkeerat.travel.util.ResourceUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ResumePackageActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_package);

        setTitle(TITLE_APPBAR);

        Package packageSaoPaulo = new Package("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        showLocal(packageSaoPaulo);
        showImage(packageSaoPaulo);
        showDays(packageSaoPaulo);
        showPrice(packageSaoPaulo);
        showDate(packageSaoPaulo);

        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }

    private void showDate(Package packageName) {
        // Data calc
        TextView date = findViewById(R.id.resume_package_data);
        String travelDateFormated = DateUtil.periodToText(packageName.getDays());
        date.setText(travelDateFormated);
    }

    private void showPrice(Package packageName) {
        TextView price = findViewById(R.id.resume_package_price);
        String brazilianCoin = CoinUtil.formatForBrazilian(packageName.getPrice());
        price.setText(brazilianCoin);
    }

    private void showDays(Package packageName) {
        TextView days = findViewById(R.id.resume_package_days);
        String daysInText = DaysUtil.formatInText(packageName.getDays());
        days.setText(daysInText);
    }

    private void showImage(Package packageName) {
        ImageView image = findViewById(R.id.resume_package_image);
        Drawable packageDrawable = ResourceUtil
                .returnDrawable(this, packageName.getImage());
        image.setImageDrawable(packageDrawable);
    }

    private void showLocal(Package packageName) {
        TextView local = findViewById(R.id.resume_package_local);
        local.setText(packageName.getLocal());
    }
}
