package com.flwapp.jumernicerio.flawlessclinicapp.peels;

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
 * Created by Jumer Nicerio on 3/21/2016.
 */
public class PeelsActivityAdapter extends RecyclerView.Adapter<PeelsActivityAdapter.PeelsViewholder> {

    ArrayList<PeelsActivityList> peels=new ArrayList<PeelsActivityList>();
    Context peels_details;

    public PeelsActivityAdapter(ArrayList<PeelsActivityList> peels, Context peels_details)
    {
        this.peels=peels;
        this.peels_details=peels_details;

    }

    @Override
    public PeelsViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_peels_cardview,parent,false);
        PeelsViewholder advancedfacialsservicesviewholder = new PeelsViewholder(view,peels_details,peels);
        return advancedfacialsservicesviewholder;
    }

    @Override
    public void onBindViewHolder(PeelsViewholder holder, int position) {
        PeelsActivityList peels_text =peels.get(position);

        holder.services_image_id.setImageResource(peels_text.getImage_id());
        holder.services_header.setText(peels_text.getHeader());
        holder.services_title.setText(peels_text.getTitle());
        holder.services_price.setText(peels_text.getPrices());
        holder.services_content.setText(peels_text.getContents());
    }

    @Override
    public int getItemCount() {
        return peels.size();
    }

    public static class PeelsViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView services_image_id;
        TextView services_header;
        TextView services_title;
        TextView services_price;
        TextView services_content;
        ArrayList<PeelsActivityList> peels=new ArrayList<PeelsActivityList>();
        Context peels_details;


        public PeelsViewholder(View view,Context peels_details,ArrayList<PeelsActivityList> peels)
        {
            super(view);
            this.peels=peels;
            this.peels_details=peels_details;
            view.setOnClickListener(this);
            services_image_id= (ImageView) view.findViewById(R.id.img_peels_list);
            services_header= (TextView) view.findViewById(R.id.txt_peels_header);
            services_title= (TextView) view.findViewById(R.id.txt_title_advanced_facials);
            services_price= (TextView) view.findViewById(R.id.txt_peels_price);
            services_content= (TextView) view.findViewById(R.id.txt_peels_details);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            PeelsActivityList peelsActivityList =this.peels.get(position);

            Intent intent =new Intent(this.peels_details,PeelsActivityDetails.class);
            intent.putExtra("image_id",peelsActivityList.getImage_id());
            intent.putExtra("image_id_details",peelsActivityList.getImage_id_details());
            intent.putExtra("titles",peelsActivityList.getTitles());
            intent.putExtra("prices",peelsActivityList.getPrices());
            intent.putExtra("contents",peelsActivityList.getContents());
            this.peels_details.startActivity(intent);
        }
    }
}
