package com.philipramkeerat.travel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.philipramkeerat.travel.R;
import com.philipramkeerat.travel.dao.PackageDAO;
import com.philipramkeerat.travel.model.Package;
import com.philipramkeerat.travel.ui.adapter.ListPackagesAdapter;

import java.util.List;

public class ListPackageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_package);

        setTitle("Packages");

        ListView listOfPackages = findViewById(R.id.list_package_listview);

        List<Package> packages = new PackageDAO().list();

        listOfPackages.setAdapter(new ListPackagesAdapter(packages, this));
    }
}
