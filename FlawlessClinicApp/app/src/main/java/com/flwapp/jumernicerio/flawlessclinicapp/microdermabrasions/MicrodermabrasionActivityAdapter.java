package com.flwapp.jumernicerio.flawlessclinicapp.microdermabrasions;

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
 * Created by Jumer Nicerio on 3/9/2016.
 */
public class MicrodermabrasionActivityAdapter extends RecyclerView.Adapter<MicrodermabrasionActivityAdapter.MicrodermabrasionViewholder> {


    ArrayList<MicrodermabrasionActivityList> micro=new ArrayList<MicrodermabrasionActivityList>();
    Context micro_service_details;

    public MicrodermabrasionActivityAdapter(ArrayList<MicrodermabrasionActivityList> micro, Context micro_service_details)
    {
        this.micro=micro;
        this.micro_service_details=micro_service_details;

    }

    @Override
    public MicrodermabrasionViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_microdermabrasion_details_cardview,parent,false);
        MicrodermabrasionViewholder microviewholder = new MicrodermabrasionViewholder(view,micro_service_details,micro);
        return microviewholder;
    }

    @Override
    public void onBindViewHolder(MicrodermabrasionViewholder holder, int position) {
        MicrodermabrasionActivityList micro_text =micro.get(position);

        holder.micro_header.setText(micro_text.getHeader());
        holder.micro_title.setText(micro_text.getTitle());
        holder.micro_price.setText(micro_text.getPrices());
        holder.micro_content.setText(micro_text.getContents());
    }

    @Override
    public int getItemCount() {
        return micro.size();
    }

    public static class MicrodermabrasionViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView micro_image_header;
        TextView micro_header;
        TextView micro_title;
        TextView micro_price;
        TextView micro_content;
        ArrayList<MicrodermabrasionActivityList> micro = new ArrayList<MicrodermabrasionActivityList>();
        Context micro_service_details;


        public MicrodermabrasionViewholder(View view,Context micro_service_details,ArrayList<MicrodermabrasionActivityList> micro)
        {
            super(view);
            this.micro=micro;
            this.micro_service_details=micro_service_details;
            view.setOnClickListener(this);
            micro_image_header= (ImageView) view.findViewById(R.id.img_micro_services_List);
            micro_header= (TextView) view.findViewById(R.id.txt_micro_header);
            micro_title= (TextView) view.findViewById(R.id.txt_title_body);
            micro_price= (TextView) view.findViewById(R.id.txt_micro_price);
            micro_content= (TextView) view.findViewById(R.id.txt_micro_details);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            MicrodermabrasionActivityList microActivityList =this.micro.get(position);
            Intent intent =new Intent(this.micro_service_details,MicroDetailsActivity.class);
            intent.putExtra("image_id",microActivityList.getImage_id());
            intent.putExtra("image_id_details",microActivityList.getImage_id_details());
            intent.putExtra("titles",microActivityList.getTitles());
            intent.putExtra("prices",microActivityList.getPrices());
            intent.putExtra("contents",microActivityList.getContents());
            this.micro_service_details.startActivity(intent);
        }
    }
}
