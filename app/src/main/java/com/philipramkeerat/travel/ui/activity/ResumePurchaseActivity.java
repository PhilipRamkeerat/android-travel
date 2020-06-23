package com.philipramkeerat.travel.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.philipramkeerat.travel.R;
import com.philipramkeerat.travel.model.Package;
import com.philipramkeerat.travel.util.CoinUtil;
import com.philipramkeerat.travel.util.DateUtil;
import com.philipramkeerat.travel.util.ResourceUtil;

import static com.philipramkeerat.travel.ui.activity.PackageActivityConstants.KEY_PACKAGE;

public class ResumePurchaseActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_purchase);
        setTitle(TITLE_APPBAR);
        loadReceivedPackage();
    }

    private void loadReceivedPackage() {
        Intent intent = getIntent();
        if (intent.hasExtra(KEY_PACKAGE)) {
            Package receivedPackage = (Package) intent.getSerializableExtra(KEY_PACKAGE);
            initializateFields(receivedPackage);
        }
    }

    private void initializateFields(Package receivedPackage) {
        showLocal(receivedPackage);
        showImage(receivedPackage);
        showData(receivedPackage);
        showPrice(receivedPackage);
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
