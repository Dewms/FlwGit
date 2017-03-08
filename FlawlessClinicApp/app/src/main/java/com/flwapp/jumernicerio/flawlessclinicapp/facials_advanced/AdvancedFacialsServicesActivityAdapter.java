package com.flwapp.jumernicerio.flawlessclinicapp.facials_advanced;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flwapp.jumernicerio.flawlessclinicapp.R;

import java.util.ArrayList;

/**
 * Created by Jumer Nicerio on 3/8/2016.
 */
public class AdvancedFacialsServicesActivityAdapter extends RecyclerView.Adapter<AdvancedFacialsServicesActivityAdapter.AdvancedFacialsServicesViewholder> {



    ArrayList<AdvancedFacialsServicesActivityList> services=new ArrayList<AdvancedFacialsServicesActivityList>();
    Context advanced_facial_service_details;

    public AdvancedFacialsServicesActivityAdapter(ArrayList<AdvancedFacialsServicesActivityList> services, Context advanced_facial_service_details)
    {
        this.services=services;
        this.advanced_facial_service_details=advanced_facial_service_details;

    }

    @Override
    public AdvancedFacialsServicesViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_advanced_facials_details_cardview,parent,false);
        AdvancedFacialsServicesViewholder advancedfacialsservicesviewholder = new AdvancedFacialsServicesViewholder(view,advanced_facial_service_details,services);
        return advancedfacialsservicesviewholder;
    }

    @Override
    public void onBindViewHolder(AdvancedFacialsServicesViewholder holder, int position) {
        AdvancedFacialsServicesActivityList services_text =services.get(position);

        holder.services_image_id.setImageResource(services_text.getImage_id());
        holder.services_header.setText(services_text.getHeader());
        holder.services_title.setText(services_text.getTitle());
        holder.services_price.setText(services_text.getPrices());
        holder.services_content.setText(services_text.getContents());
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public static class AdvancedFacialsServicesViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView services_image_id;
        TextView services_header;
        TextView services_title;
        TextView services_price;
        TextView services_content;
        ArrayList<AdvancedFacialsServicesActivityList> services=new ArrayList<AdvancedFacialsServicesActivityList>();
        Context advanced_facial_service_details;


        public AdvancedFacialsServicesViewholder(View view,Context advanced_facial_service_details,ArrayList<AdvancedFacialsServicesActivityList> services)
        {
            super(view);
            this.services=services;
            this.advanced_facial_service_details=advanced_facial_service_details;
            view.setOnClickListener(this);
            services_image_id= (ImageView) view.findViewById(R.id.img_advancedfacials_list);
            services_header= (TextView) view.findViewById(R.id.txt_advanced_facials_header);
            services_title= (TextView) view.findViewById(R.id.txt_title_advanced_facials);
            services_price= (TextView) view.findViewById(R.id.txt_advanced_facials_price);
            services_content= (TextView) view.findViewById(R.id.txt_advanced_facials_details);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            AdvancedFacialsServicesActivityList afacialsActivityList =this.services.get(position);
            Intent intent =new Intent(this.advanced_facial_service_details,AdvancedFacialsServicesDetailsActivity.class);
            intent.putExtra("image_id",afacialsActivityList.getImage_id());
            intent.putExtra("image_id_details",afacialsActivityList.getImage_id_details());
            intent.putExtra("titles",afacialsActivityList.getTitles());
            intent.putExtra("prices",afacialsActivityList.getPrices());
            intent.putExtra("contents",afacialsActivityList.getContents());
            this.advanced_facial_service_details.startActivity(intent);
        }
    }
}
