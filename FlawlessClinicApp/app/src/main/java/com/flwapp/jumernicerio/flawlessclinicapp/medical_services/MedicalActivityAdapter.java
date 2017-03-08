package com.flwapp.jumernicerio.flawlessclinicapp.medical_services;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flwapp.jumernicerio.flawlessclinicapp.R;

import java.util.ArrayList;

/**
 * Created by Jumer Nicerio on 3/15/2016.
 */
public class MedicalActivityAdapter extends RecyclerView.Adapter<MedicalActivityAdapter.MedicalViewholder> {


    ArrayList<MedicalActivityList> med=new ArrayList<MedicalActivityList>();

    public MedicalActivityAdapter (ArrayList<MedicalActivityList> med)
    {
        this.med=med;

    }

    @Override
    public MedicalViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_medical_cardview,parent,false);
        MedicalViewholder medicalviewholder = new MedicalViewholder(view);
        return medicalviewholder;
    }

    @Override
    public void onBindViewHolder(MedicalViewholder holder, int position) {
        MedicalActivityList med_text =med.get(position);

        holder.med_header.setText(med_text.getHeader());
        holder.med_title.setText(med_text.getTitle());
        holder.med_price.setText(med_text.getPrices());
        holder.med_content.setText(med_text.getContents());
    }

    @Override
    public int getItemCount() {
        return med.size();
    }

    public static class MedicalViewholder extends RecyclerView.ViewHolder{

        TextView med_header;
        TextView med_title;
        TextView med_price;
        TextView med_content;


        public MedicalViewholder(View view)
        {
            super(view);
            med_header= (TextView) view.findViewById(R.id.txt_medical_header);
            med_title= (TextView) view.findViewById(R.id.txt_title_medical);
            med_price= (TextView) view.findViewById(R.id.txt_medical_price);
            med_content= (TextView) view.findViewById(R.id.txt_medical_details);
        }
    }
}

