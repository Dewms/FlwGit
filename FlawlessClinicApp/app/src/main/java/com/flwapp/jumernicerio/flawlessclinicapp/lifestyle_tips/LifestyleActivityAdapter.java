package com.flwapp.jumernicerio.flawlessclinicapp.lifestyle_tips;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flwapp.jumernicerio.flawlessclinicapp.R;

import java.util.ArrayList;

/**
 * Created by Jumer Nicerio on 3/5/2016.
 */
public class LifestyleActivityAdapter extends RecyclerView.Adapter<LifestyleActivityAdapter.LifestyleViewholder> {



    ArrayList <LifestyleActivityList> lifestyle=new ArrayList<LifestyleActivityList>();

    public LifestyleActivityAdapter (ArrayList<LifestyleActivityList> lifestyle)
    {
        this.lifestyle=lifestyle;

    }

    @Override
    public LifestyleViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lifestyle_cardview,parent,false);
        LifestyleViewholder lifestyleviewholder = new LifestyleViewholder(view);
        return lifestyleviewholder;

    }

    @Override
    public void onBindViewHolder(LifestyleViewholder holder, int position) {
        LifestyleActivityList lifestyle_text =lifestyle.get(position);
        holder.lifestyle_image_header.setImageResource(lifestyle_text.getImage_id());
        holder.lifestyle_title.setText(lifestyle_text.getTitle());
        holder.lifestyle_header.setText(lifestyle_text.getHeader());
        holder.lifestyle_content.setText(lifestyle_text.getContent());
    }

    @Override
    public int getItemCount() {
        return lifestyle.size();
    }

    public static class LifestyleViewholder extends RecyclerView.ViewHolder{

        ImageView lifestyle_image_header;
        TextView lifestyle_title;
        TextView lifestyle_header;
        TextView lifestyle_content;

        public LifestyleViewholder(View view)
        {
            super(view);
            lifestyle_image_header= (ImageView) view.findViewById(R.id.lifestyle_image_title);
            lifestyle_title= (TextView) view.findViewById(R.id.txt_title);
            lifestyle_header= (TextView) view.findViewById(R.id.txt_header);
            lifestyle_content= (TextView) view.findViewById(R.id.txt_content);

        }
    }
}
