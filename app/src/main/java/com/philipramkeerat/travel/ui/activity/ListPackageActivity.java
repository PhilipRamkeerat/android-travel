package com.philipramkeerat.travel.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.philipramkeerat.travel.R;
import com.philipramkeerat.travel.dao.PackageDAO;
import com.philipramkeerat.travel.model.Package;
import com.philipramkeerat.travel.ui.adapter.ListPackagesAdapter;

import java.util.List;

public class ListPackageActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Packages";
    public static final String KEY_PACKAGE = "package";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_package);
        setTitle(TITLE_APPBAR);
        configureList();
    }

    private void configureList() {
        ListView listOfPackages = findViewById(R.id.list_package_listview);
        final List<Package> packages = new PackageDAO().list();
        listOfPackages.setAdapter(new ListPackagesAdapter(packages, this));
        listOfPackages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Package clickedPackage = packages.get(position);
                goToResumePackage(clickedPackage);
            }
        });
    }

    private void goToResumePackage(Package clickedPackage) {
        Intent intent = new Intent(ListPackageActivity.this, ResumePackageActivity.class);
        intent.putExtra(KEY_PACKAGE, clickedPackage);
        startActivity(intent);
    }
}
