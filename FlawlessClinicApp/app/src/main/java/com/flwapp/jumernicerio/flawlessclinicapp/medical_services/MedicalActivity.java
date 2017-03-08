package com.flwapp.jumernicerio.flawlessclinicapp.medical_services;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.flwapp.jumernicerio.flawlessclinicapp.BaseActivity;
import com.flwapp.jumernicerio.flawlessclinicapp.R;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Jumer Nicerio on 3/15/2016.
 */
public class MedicalActivity extends BaseActivity {
    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutmanager;
    ArrayList<MedicalActivityList> list =new ArrayList<MedicalActivityList>();

    String[] header,titles,prices,contents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/FertigoProRegular.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_medical);


        header = getResources().getStringArray(R.array.array_list_medical);
        titles = getResources().getStringArray(R.array.array_list_medical);
        prices = getResources().getStringArray(R.array.array_price_list_medical);
        contents=getResources().getStringArray(R.array.array_details_medical);
        int count =0;
        for (String Header : header)
        {
            MedicalActivityList med = new MedicalActivityList(header[count],titles[count],prices[count],contents[count]);
            count++;
            list.add(med);
        }
        recyclerview= (RecyclerView) findViewById(R.id.medical_recyclerview);
        layoutmanager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutmanager);
        recyclerview.setHasFixedSize(true);
        adapter=new MedicalActivityAdapter(list);
        recyclerview.setAdapter(adapter);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected boolean useDrawerToggle() {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_services)
            return true;

        if (item.getItemId() == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);
    }
}
