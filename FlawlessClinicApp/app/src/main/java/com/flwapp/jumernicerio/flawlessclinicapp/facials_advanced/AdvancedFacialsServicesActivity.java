package com.flwapp.jumernicerio.flawlessclinicapp.facials_advanced;

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
 * Created by Jumer Nicerio on 3/8/2016.
 */
public class AdvancedFacialsServicesActivity extends BaseActivity {
    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutmanager;
    ArrayList<AdvancedFacialsServicesActivityList> list =new ArrayList<AdvancedFacialsServicesActivityList>();
    int[] image_id ={R.mipmap.ic_body_facials,R.mipmap.ic_body_facials,R.mipmap.ic_body_facials,
                    R.mipmap.ic_body_facials,R.mipmap.ic_body_facials,R.mipmap.ic_body_facials,
                    R.mipmap.ic_body_facials,R.mipmap.ic_body_facials,R.mipmap.ic_body_facials,
                    R.mipmap.ic_body_facials,R.mipmap.ic_body_facials,R.mipmap.ic_body_facials,
                    R.mipmap.ic_body_facials};
    int[] image_id_details ={R.drawable.img_allnatural,R.drawable.img_facials_gil,
                    R.drawable.img_facials_gil,R.drawable.img_facials_gil,
                    R.drawable.img_facials_gil,R.drawable.img_facials_gil,
                    R.drawable.img_facials_gil,R.drawable.img_facials_gil,
                    R.drawable.img_facials_gil,R.drawable.img_facials_gil,
                    R.drawable.img_facials_gil,R.drawable.img_facials_gil,
                    R.drawable.img_facials_gil};
    String[] header,titles,prices,contents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MelbourneRegularBasic.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_advanced_facials);

        header = getResources().getStringArray(R.array.array_list_advanced_facials);
        titles = getResources().getStringArray(R.array.array_list_advanced_facials);
        prices = getResources().getStringArray(R.array.array_price_list_advanced_facials);
        contents=getResources().getStringArray(R.array.array_details_advanced_facials);
        int count =0;
        for (String Header : header)
        {
            AdvancedFacialsServicesActivityList services = new AdvancedFacialsServicesActivityList(image_id[count],image_id_details[count],header[count],titles[count],prices[count],contents[count]);
            count++;
            list.add(services);
        }
        recyclerview= (RecyclerView) findViewById(R.id.advanced_facials_recyclerview);
        layoutmanager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutmanager);
        recyclerview.setHasFixedSize(true);
        adapter=new AdvancedFacialsServicesActivityAdapter(list,this);
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
