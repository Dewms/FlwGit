package com.flwapp.jumernicerio.flawlessclinicapp.products;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flwapp.jumernicerio.flawlessclinicapp.R;

/**
 * Created by Jumer Nicerio on 3/3/2016.
 */
public class FragmentProductsDesc extends Fragment {
    TextView text_title_products;
    TextView text_details_products;
    TextView text_products_price;
    ImageView images;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products_desc, container, false);

        /*get TextView ID*/
        text_title_products = (TextView) view.findViewById(R.id.txt_product_title);
        text_products_price = (TextView) view.findViewById(R.id.txt_products_price);
        text_details_products = (TextView) view.findViewById(R.id.txt_product_details);
        /*Set Custom Font*/
        Typeface face_title = Typeface.createFromAsset(getActivity().getAssets(), "fonts/FertigoProRegular.otf");
        text_title_products.setTypeface(face_title);
        Typeface face_details = Typeface.createFromAsset(getActivity().getAssets(), "fonts/MelbourneRegularBasic.otf");
        text_details_products.setTypeface(face_details);
        /*get Image ID*/
        images = (ImageView) view.findViewById(R.id.imageView_products);

        return view;
    }

    public void changeData(int index) {

        int[] image_id =
                {
                        R.drawable.img_skinlitecream, R.drawable.img_skinwhitetherapy,
                        R.drawable.img_skinwhiteningsoap, R.drawable.img_skinlighteninglotion_sunblock,
                        R.drawable.img_whitepluscream, R.drawable.img_whiteningtoner,
                        R.drawable.img_agedefycream, R.drawable.img_oatmealsoap,
                        R.drawable.img_teatreesoap, R.drawable.img_porerefiner,
                        R.drawable.img_skinrenewcream, R.drawable.img_rgsoap,
                        R.drawable.img_rgcream, R.drawable.img_rgtoner,
                        R.drawable.img_sassoap, R.drawable.img_skinprotectgel,
                        R.drawable.img_collagensoap,
                        R.drawable.img_skinprotectcream, R.drawable.img_agedefytoner,
                        R.drawable.img_ahasoap, R.drawable.img_skinprotectmist,
                        R.drawable.img_skinprotectmist, R.drawable.img_whiteningsuperserum,
                        R.drawable.img_agedefysuperserum, R.drawable.img_nanowhitenessgluta,
                        R.drawable.img_skinliftcollagen, R.drawable.img_shapesculpt,
                };
        String[] titles = getResources().getStringArray(R.array.array_list_products_title);
        String[] prices = getResources().getStringArray(R.array.array_list_products_price);
        String[] descriptions = getResources().getStringArray(R.array.array_list_products_details);
        text_title_products.setText(titles[index]);
        text_products_price.setText(prices[index]);
        text_details_products.setText(descriptions[index]);
        images.setImageResource(image_id[index]);
    }
}