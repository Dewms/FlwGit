package com.flwapp.jumernicerio.flawlessclinicapp.hair_removal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flwapp.jumernicerio.flawlessclinicapp.R;
import com.flwapp.jumernicerio.flawlessclinicapp.peels.PeelsActivityDetails;

import java.util.ArrayList;

/**
 * Created by Jumer Nicerio on 3/21/2016.
 */
public class HairActivityAdapter  extends RecyclerView.Adapter<HairActivityAdapter.HairViewholder> {



    ArrayList<HairActivityList> hair=new ArrayList<HairActivityList>();
    Context hair_details;

    public HairActivityAdapter(ArrayList<HairActivityList> hair, Context hair_details)
    {
        this.hair=hair;
        this.hair_details=hair_details;

    }

    @Override
    public HairViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_hair_cardview,parent,false);
        HairViewholder hairviewholder = new HairViewholder(view,hair_details,hair);
        return hairviewholder;
    }

    @Override
    public void onBindViewHolder(HairViewholder holder, int position) {
        HairActivityList hair_text =hair.get(position);

        holder.services_image_id.setImageResource(hair_text.getImage_id());
        holder.services_header.setText(hair_text.getHeader());
        holder.services_title.setText(hair_text.getTitle());
        holder.services_price.setText(hair_text.getPrices());
        holder.services_content.setText(hair_text.getContents());
    }

    @Override
    public int getItemCount() {
        return hair.size();
    }

    public static class HairViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView services_image_id;
        TextView services_header;
        TextView services_title;
        TextView services_price;
        TextView services_content;
        ArrayList<HairActivityList> hair=new ArrayList<HairActivityList>();
        Context hair_details;


        public HairViewholder(View view,Context hair_details,ArrayList<HairActivityList> hair)
        {
            super(view);
            this.hair=hair;
            this.hair_details=hair_details;
            view.setOnClickListener(this);
            services_image_id= (ImageView) view.findViewById(R.id.img_hair_list);
            services_header= (TextView) view.findViewById(R.id.txt_hair_header);
            services_title= (TextView) view.findViewById(R.id.txt_title_hair);
            services_price= (TextView) view.findViewById(R.id.txt_hair_price);
            services_content= (TextView) view.findViewById(R.id.txt_hair_details);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            HairActivityList hairActivityList =this.hair.get(position);
            Intent intent =new Intent(this.hair_details,PeelsActivityDetails.class);
            intent.putExtra("image_id",hairActivityList.getImage_id());
            intent.putExtra("image_id_details",hairActivityList.getImage_id_details());
            intent.putExtra("titles",hairActivityList.getTitles());
            intent.putExtra("prices",hairActivityList.getPrices());
            intent.putExtra("contents",hairActivityList.getContents());
            this.hair_details.startActivity(intent);
        }
    }
}

