package com.philipramkeerat.travel.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.philipramkeerat.travel.R;
import com.philipramkeerat.travel.model.Package;
import com.philipramkeerat.travel.util.CoinUtil;

import static com.philipramkeerat.travel.ui.activity.PackageActivityConstants.KEY_PACKAGE;

public class PaymentActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle(TITLE_APPBAR);
        loadReceivedPackage();
    }

    private void loadReceivedPackage() {
        Intent intent = getIntent();
        if (intent.hasExtra(KEY_PACKAGE)) {
            final Package receivedPackage = (Package) intent.getSerializableExtra(KEY_PACKAGE);
            ShowPrice(receivedPackage);
            configureButton(receivedPackage);
        }
    }

    private void configureButton(final Package receivedPackage) {
        Button buttonFinishPurchase = findViewById(R.id.payment_button_finish_purchase);
        buttonFinishPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToResumePurchase(receivedPackage);
            }
        });
    }

    private void goToResumePurchase(Package receivedPackage) {
        Intent intent = new Intent(PaymentActivity.this,
                ResumePurchaseActivity.class);
        intent.putExtra(KEY_PACKAGE, receivedPackage);
        startActivity(intent);
    }

    private void ShowPrice(Package packageName) {
        TextView price = findViewById(R.id.payment_price_package);
        String brazilianCoin = CoinUtil
                .formatForBrazilian(packageName.getPrice());
        price.setText(brazilianCoin);
    }
}
