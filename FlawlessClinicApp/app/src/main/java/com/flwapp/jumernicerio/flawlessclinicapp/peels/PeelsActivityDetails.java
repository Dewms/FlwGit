package com.flwapp.jumernicerio.flawlessclinicapp.peels;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.flwapp.jumernicerio.flawlessclinicapp.BaseActivity;
import com.flwapp.jumernicerio.flawlessclinicapp.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Jumer Nicerio on 3/21/2016.
 */
public class PeelsActivityDetails extends BaseActivity {
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
        setContentView(R.layout.activity_peels_details);

        img_serv= (ImageView) findViewById(R.id.img_peels_details);
        tx_title= (TextView) findViewById(R.id.txt_peels_details_title);
        tx_price= (TextView) findViewById(R.id.txt_peels_details_price);
        tx_contents= (TextView) findViewById(R.id.txt_peels_details_content);

        img_serv.setImageResource(getIntent().getIntExtra("image_id_details",00));
        tx_title.setText(getIntent().getStringExtra("titles"));
        tx_price.setText(getIntent().getStringExtra("prices"));
        tx_contents.setText(getIntent().getStringExtra("contents"));
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
