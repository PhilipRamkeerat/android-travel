package com.philipramkeerat.travel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.philipramkeerat.travel.R;
import com.philipramkeerat.travel.model.Package;
import com.philipramkeerat.travel.util.CoinUtil;

import java.math.BigDecimal;

public class PaymentActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        setTitle(TITLE_APPBAR);

        Package packageSaoPaulo = new Package("São Paulo", "sao_paulo_sp", 2,
                new BigDecimal("243.99"));

        // Price bind
        ShowPrice(packageSaoPaulo);

        Button buttonFinishPurchase = findViewById(R.id.payment_button_finish_purchase);

        buttonFinishPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentActivity.this,
                        ResumePurchaseActivity.class);
                startActivity(intent);
            }
        });

    }

    private void ShowPrice(Package packageName) {
        TextView price = findViewById(R.id.payment_price_package);
        String brazilianCoin = CoinUtil
                .formatForBrazilian(packageName.getPrice());
        price.setText(brazilianCoin);
    }
}
