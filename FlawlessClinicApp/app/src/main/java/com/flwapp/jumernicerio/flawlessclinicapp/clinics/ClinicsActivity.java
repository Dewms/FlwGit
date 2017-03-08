package com.flwapp.jumernicerio.flawlessclinicapp.clinics;

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
 * Created by Jumer Nicerio on 3/11/2016.
 */
public class ClinicsActivity extends BaseActivity {


    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutmanager;
    ArrayList<ClinicsActivityList> list =new ArrayList<ClinicsActivityList>();
    int[] image_id ={R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,
            R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,
            R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,
            R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,
            R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,
            R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,
            R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,
            R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics,
            R.drawable.img_clinics,R.drawable.img_clinics,R.drawable.img_clinics};

    String[] title,header,content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MelbourneRegularBasic.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_clinics);

        title = getResources().getStringArray(R.array.array_list_clinics);
        header = getResources().getStringArray(R.array.array_list_clinics);
        content=getResources().getStringArray(R.array.array_details_clinics);
        int count =0;
        for (String Titles : title)
        {
            ClinicsActivityList clinics = new ClinicsActivityList(image_id[count],title[count],header[count],content[count]);
            count++;
            list.add(clinics);
        }
        recyclerview= (RecyclerView) findViewById(R.id.clinics_recyclerview);
        layoutmanager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutmanager);
        recyclerview.setHasFixedSize(true);
        adapter=new ClinicsActivityAdapter(list);
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
