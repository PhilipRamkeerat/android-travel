package com.philipramkeerat.travel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.philipramkeerat.travel.R;
import com.philipramkeerat.travel.model.Package;
import com.philipramkeerat.travel.util.CoinUtil;
import com.philipramkeerat.travel.util.DateUtil;
import com.philipramkeerat.travel.util.DaysUtil;
import com.philipramkeerat.travel.util.ResourceUtil;

import java.io.Serializable;
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

        Intent intent = getIntent();
        if (intent.hasExtra("package")) {
            final Package receivedPackage = (Package) intent.getSerializableExtra("package");

            showLocal(receivedPackage);
            showImage(receivedPackage);
            showDays(receivedPackage);
            showPrice(receivedPackage);
            showDate(receivedPackage);

            Button buttonMakePayment = findViewById(R.id.resume_package_button_confirm_payment);
            buttonMakePayment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResumePackageActivity.this,
                            PaymentActivity.class);
                    intent.putExtra("package", receivedPackage);
                    startActivity(intent);
                }
            });
        }


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
