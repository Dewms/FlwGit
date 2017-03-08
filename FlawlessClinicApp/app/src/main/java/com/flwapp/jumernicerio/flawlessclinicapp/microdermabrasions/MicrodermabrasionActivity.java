package com.flwapp.jumernicerio.flawlessclinicapp.microdermabrasions;

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
 * Created by Jumer Nicerio on 3/9/2016.
 */
public class MicrodermabrasionActivity extends BaseActivity {
    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutmanager;
    ArrayList<MicrodermabrasionActivityList> list =new ArrayList<MicrodermabrasionActivityList>();
    int[] image_id ={R.mipmap.ic_body_micro,R.mipmap.ic_body_micro,R.mipmap.ic_body_micro,R.mipmap.ic_body_micro,
            R.mipmap.ic_body_micro,R.mipmap.ic_body_micro,R.mipmap.ic_body_micro,R.mipmap.ic_body_micro,
            R.mipmap.ic_body_micro,R.mipmap.ic_body_micro,R.mipmap.ic_body_micro,R.mipmap.ic_body_micro,
            R.mipmap.ic_body_micro,};
    int[] image_id_details ={R.drawable.img_microderm,R.drawable.img_microderm,R.drawable.img_microderm,
            R.drawable.img_microderm,R.drawable.img_microderm,R.drawable.img_microderm,
            R.drawable.img_microderm,R.drawable.img_microderm,R.drawable.img_microderm,
            R.drawable.img_microderm,R.drawable.img_microderm,R.drawable.img_microderm,
            R.drawable.img_microderm,};
    String[] header,titles,prices,contents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/FertigoProRegular.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_microdermabrasion);


        header = getResources().getStringArray(R.array.array_list_microdermabrasion);
        titles = getResources().getStringArray(R.array.array_list_microdermabrasion);
        prices = getResources().getStringArray(R.array.array_price_list_microdermabrasion);
        contents=getResources().getStringArray(R.array.array_details_microdermabrasion);
        int count =0;
        for (String Header : header)
        {
            MicrodermabrasionActivityList micro = new MicrodermabrasionActivityList(image_id[count],image_id_details[count],header[count],titles[count],prices[count],contents[count]);
            count++;
            list.add(micro);
        }
        recyclerview= (RecyclerView) findViewById(R.id.micro_recyclerview);
        layoutmanager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutmanager);
        recyclerview.setHasFixedSize(true);
        adapter=new MicrodermabrasionActivityAdapter(list,this);
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
