package com.flwapp.jumernicerio.flawlessclinicapp.lifestyle_tips;

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
 * Created by Jumer Nicerio on 3/3/2016.
 */
public class LifestyleActivity extends BaseActivity {


    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutmanager;
    ArrayList<LifestyleActivityList> list =new ArrayList <LifestyleActivityList>();
    int[] image_id ={R.drawable.img_beautygoals,R.drawable.img_choose,R.drawable.img_lifestyle_fitness_regimen,
                    R.drawable.img_lifestyle_facelift,R.drawable.img_lifestyle_lips,R.drawable.img_lifestyle_lhr};
    String[] title,header,content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifestyle);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/MelbourneRegularBasic.otf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );

        title = getResources().getStringArray(R.array.array_list_lifestyle);
        header = getResources().getStringArray(R.array.array_list_lifestyle);
        content=getResources().getStringArray(R.array.array_content_lifestyle);
        int count =0;
        for (String Titles : title)
        {
            LifestyleActivityList lifestyle = new LifestyleActivityList(image_id[count],title[count],header[count],content[count]);
            count++;
            list.add(lifestyle);
        }
        recyclerview= (RecyclerView) findViewById(R.id.lifestyle_recyclerview);
        layoutmanager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutmanager);
        recyclerview.setHasFixedSize(true);
        adapter=new LifestyleActivityAdapter(list);
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
