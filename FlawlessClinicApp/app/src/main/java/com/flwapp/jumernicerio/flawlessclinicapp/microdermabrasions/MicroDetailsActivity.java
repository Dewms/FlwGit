package com.flwapp.jumernicerio.flawlessclinicapp.microdermabrasions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.flwapp.jumernicerio.flawlessclinicapp.BaseActivity;
import com.flwapp.jumernicerio.flawlessclinicapp.R;
import com.flwapp.jumernicerio.flawlessclinicapp.facials_advanced.AdvancedFacialsServicesActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Jumer Nicerio on 3/21/2016.
 */
public class MicroDetailsActivity  extends BaseActivity implements View.OnClickListener{
    ImageView img_serv;
    TextView tx_title;
    TextView tx_price;
    TextView tx_contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MelbourneRegularBasic.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_micro_details);

        img_serv= (ImageView) findViewById(R.id.img_micro_details);
        tx_title= (TextView) findViewById(R.id.txt_micro_details_title);
        tx_price= (TextView) findViewById(R.id.txt_micro_details_price);
        tx_contents= (TextView) findViewById(R.id.txt_micro_details_content);

        img_serv.setImageResource(getIntent().getIntExtra("image_id_details",00));
        tx_title.setText(getIntent().getStringExtra("titles"));
        tx_price.setText(getIntent().getStringExtra("prices"));
        tx_contents.setText(getIntent().getStringExtra("contents"));

        ImageButton micro_facials = (ImageButton) findViewById(R.id.imgbtn_micro_details_facials);
        micro_facials.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.imgbtn_micro_details_facials:
                Intent micro_df = new Intent(MicroDetailsActivity.this, AdvancedFacialsServicesActivity.class);
                startActivity(micro_df);
                break;
        }
    }
}
