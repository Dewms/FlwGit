package com.flwapp.jumernicerio.flawlessclinicapp.body_services;

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
 * Created by Jumer Nicerio on 3/15/2016.
 */
public class BodyActivityAdapter  extends RecyclerView.Adapter<BodyActivityAdapter.BodyViewholder> {


    ArrayList<BodyActivityList> body=new ArrayList<BodyActivityList>();
    Context body_service_details;

    public BodyActivityAdapter (ArrayList<BodyActivityList> body,Context body_service_details)
    {
        this.body=body;
        this.body_service_details=body_service_details;
    }

    @Override
    public BodyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_body_cardview,parent,false);
        BodyViewholder bodyviewholder = new BodyViewholder(view,body_service_details,body);
        return bodyviewholder;
    }

    @Override
    public void onBindViewHolder(BodyViewholder holder, int position) {
        BodyActivityList body_text =body.get(position);
      //  holder.body_image_details.setImageResource(body_text.getImage_id_details());
        holder.body_image_header.setImageResource(body_text.getImage_id());
        holder.body_header.setText(body_text.getHeader());
        holder.body_title.setText(body_text.getTitle());
        holder.body_price.setText(body_text.getPrices());
        holder.body_content.setText(body_text.getContents());
    }

    @Override
    public int getItemCount() {
        return body.size();
    }

    public static class BodyViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView body_image_header;
      //  ImageView body_image_details;
        TextView body_header;
        TextView body_title;
        TextView body_price;
        TextView body_content;
        ArrayList<BodyActivityList> body = new ArrayList<BodyActivityList>();
        Context body_service_details;

        public BodyViewholder(View view,Context body_service_details,ArrayList<BodyActivityList> body)
        {
            super(view);
            this.body=body;
            this.body_service_details=body_service_details;
            view.setOnClickListener(this);
            body_image_header= (ImageView) view.findViewById(R.id.img_body_services_List);
          //  body_image_details= (ImageView) view.findViewById(R.id.img_body_detailsview);
            body_header= (TextView) view.findViewById(R.id.txt_body_header);
            body_title= (TextView) view.findViewById(R.id.txt_title_body);
            body_price= (TextView) view.findViewById(R.id.txt_body_price);
            body_content= (TextView) view.findViewById(R.id.txt_body_details);
        }

        @Override
        public void onClick(View view) {

        int position=getAdapterPosition();
            BodyActivityList bodyActivityList =this.body.get(position);

            Intent intent =new Intent(this.body_service_details,BodyServicesDetailsActivity.class);
            intent.putExtra("image_id",bodyActivityList.getImage_id());
            intent.putExtra("image_id_details",bodyActivityList.getImage_id_details());
            intent.putExtra("titles",bodyActivityList.getTitles());
            intent.putExtra("prices",bodyActivityList.getPrices());
            intent.putExtra("contents",bodyActivityList.getContents());
            this.body_service_details.startActivity(intent);
        }
    }
}
