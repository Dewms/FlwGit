package com.flwapp.jumernicerio.flawlessclinicapp.clinics;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flwapp.jumernicerio.flawlessclinicapp.R;

import java.util.ArrayList;

/**
 * Created by Jumer Nicerio on 3/11/2016.
 */
public class ClinicsActivityAdapter extends RecyclerView.Adapter<ClinicsActivityAdapter.LifestyleViewholder> {


    ArrayList<ClinicsActivityList> clinics = new ArrayList<ClinicsActivityList>();

    public ClinicsActivityAdapter(ArrayList<ClinicsActivityList> clinics) {
        this.clinics = clinics;

    }

    @Override
    public LifestyleViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_clinics_cardview, parent, false);
        LifestyleViewholder lifestyleviewholder = new LifestyleViewholder(view);
        return lifestyleviewholder;
    }

    @Override
    public void onBindViewHolder(LifestyleViewholder holder, int position) {
        ClinicsActivityList clinics_text = clinics.get(position);
        holder.clinics_image_header.setImageResource(clinics_text.getImage_id());
        holder.clinics_title.setText(clinics_text.getTitle());
        holder.clinics_header.setText(clinics_text.getHeader());
        holder.clinics_content.setText(clinics_text.getContent());
    }

    @Override
    public int getItemCount() {
        return clinics.size();
    }

    public static class LifestyleViewholder extends RecyclerView.ViewHolder {

        ImageView clinics_image_header;
        TextView clinics_title;
        TextView clinics_header;
        TextView clinics_content;

        public LifestyleViewholder(View view) {
            super(view);
            clinics_image_header = (ImageView) view.findViewById(R.id.clinics_image_title);
            clinics_title = (TextView) view.findViewById(R.id.txt_title);
            clinics_header = (TextView) view.findViewById(R.id.txt_header);
            clinics_content = (TextView) view.findViewById(R.id.txt_content);

        }
    }
}
