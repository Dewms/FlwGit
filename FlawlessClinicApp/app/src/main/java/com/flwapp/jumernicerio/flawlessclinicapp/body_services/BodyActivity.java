package com.flwapp.jumernicerio.flawlessclinicapp.body_services;

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
public class BodyActivity extends BaseActivity {
    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutmanager;
    ArrayList<BodyActivityList> list =new ArrayList<BodyActivityList>();
    int[] image_id ={R.mipmap.ic_body_services,R.mipmap.ic_body_services,R.mipmap.ic_body_services,
              R.mipmap.ic_body_services,R.mipmap.ic_body_services};
    int[] image_id_details ={R.drawable.img_body_gil,R.drawable.img_body_gil,R.drawable.img_body_gil,
                R.drawable.img_body_gil,R.drawable.img_body_gil};
    String[] header,titles,prices,contents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MelbourneRegularBasic.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_body);

        header = getResources().getStringArray(R.array.array_list_body_services);
        titles = getResources().getStringArray(R.array.array_list_body_services);
        prices = getResources().getStringArray(R.array.array_price_list_body);
        contents=getResources().getStringArray(R.array.array_details_body_services);
        int count =0;
        for (String Header : header)
        {
            BodyActivityList body = new BodyActivityList(image_id[count],image_id_details[count],header[count],titles[count],prices[count],contents[count]);
            count++;
            list.add(body);
        }
        recyclerview= (RecyclerView) findViewById(R.id.body_recyclerview);
        layoutmanager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutmanager);
        recyclerview.setHasFixedSize(true);
        adapter=new BodyActivityAdapter(list,this);
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

