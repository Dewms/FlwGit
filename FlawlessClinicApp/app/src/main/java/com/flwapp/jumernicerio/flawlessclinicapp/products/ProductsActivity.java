package com.flwapp.jumernicerio.flawlessclinicapp.products;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.flwapp.jumernicerio.flawlessclinicapp.BaseActivity;
import com.flwapp.jumernicerio.flawlessclinicapp.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Jumer Nicerio on 3/3/2016.
 */
public class ProductsActivity extends BaseActivity implements FragmentProductsList.Communicator{

    FragmentProductsList f1;
    FragmentProductsDesc f2;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/FertigoProRegular.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_products);
        manager=getFragmentManager();
        f1= (FragmentProductsList) manager.findFragmentById(R.id.fragment);
        f1.setCommunicator(this);
    }

    @Override
    public void respond(int index) {
        f2= (FragmentProductsDesc) manager.findFragmentById(R.id.fragment2);
        if(f2!=null && f2.isVisible())
        {
            f2.changeData(index);
        }
        else
        {
            Intent intent=new Intent(this,ProductsLandActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }
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
