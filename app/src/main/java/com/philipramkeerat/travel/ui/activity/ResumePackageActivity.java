package com.philipramkeerat.travel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.philipramkeerat.travel.R;
import com.philipramkeerat.travel.model.Package;
import com.philipramkeerat.travel.util.CoinUtil;
import com.philipramkeerat.travel.util.DaysUtil;
import com.philipramkeerat.travel.util.ResourceUtil;

import java.math.BigDecimal;

public class ResumePackageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_package);

        Package packageSaoPaulo = new Package("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        TextView local = findViewById(R.id.resume_package_local);
        local.setText(packageSaoPaulo.getLocal());

        ImageView image = findViewById(R.id.resume_package_image);
        Drawable packageDrawable = ResourceUtil
                .returnDrawable(this, packageSaoPaulo.getImage());
        image.setImageDrawable(packageDrawable);

        TextView days = findViewById(R.id.resume_package_days);
        String daysInText = DaysUtil.formatInText(packageSaoPaulo.getDays());
        days.setText(daysInText);

        TextView price = findViewById(R.id.resume_package_price);
        String brazilianCoin = CoinUtil.formatForBrazilian(packageSaoPaulo.getPrice());
        price.setText(brazilianCoin);


    }
}
