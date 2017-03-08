package com.flwapp.jumernicerio.flawlessclinicapp.hair_removal;

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
 * Created by Jumer Nicerio on 3/21/2016.
 */
public class HairActivity extends BaseActivity {
    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutmanager;
    ArrayList<HairActivityList> list =new ArrayList<HairActivityList>();
    int[] image_id ={R.mipmap.ic_body_hair,R.mipmap.ic_body_hair};
    int[] image_id_details ={R.drawable.img_hair_rmvl,R.drawable.img_hair_rmvl};
    String[] header,titles,prices,contents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MelbourneRegularBasic.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_hair);

        header = getResources().getStringArray(R.array.array_list_hair_removal);
        titles = getResources().getStringArray(R.array.array_list_hair_removal);
        prices = getResources().getStringArray(R.array.array_price_list_hair_removal);
        contents=getResources().getStringArray(R.array.array_details_hair_removal);
        int count =0;
        for (String Header : header)
        {
            HairActivityList hair = new HairActivityList(image_id[count],image_id_details[count],header[count],titles[count],prices[count],contents[count]);
            count++;
            list.add(hair);
        }
        recyclerview= (RecyclerView) findViewById(R.id.hair_recyclerview);
        layoutmanager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutmanager);
        recyclerview.setHasFixedSize(true);
        adapter=new HairActivityAdapter(list,this);
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

