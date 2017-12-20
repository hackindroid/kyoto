package com.hackindroid.kyoto.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackindroid.kyoto.R;
import com.hackindroid.kyoto.models.AdDetails;

import java.util.ArrayList;



/**
 * Created by Sushila on 8/31/2017.
 */

public class RecyclerAdAdapter extends RecyclerView.Adapter<RecyclerAdAdapter.MyHolder> {
    Context context;
    ArrayList<AdDetails> detailsArrayListComplete;
    ArrayList<AdDetails> detailsArrayListFiltered;

    public static final int RESET_FILTER = 1;
    public static final int RESET_NONE = 0;
    public RecyclerAdAdapter(Context context, ArrayList<AdDetails> detailsArrayList) {
        this.context = context;
        this.detailsArrayListComplete = detailsArrayList;
        this.detailsArrayListFiltered = detailsArrayList;
    }
    public void updateDetails(ArrayList<AdDetails> adDetails, int i){

        detailsArrayListComplete = adDetails;
        notifyDataSetChanged();
        if(i == RESET_FILTER) {
            detailsArrayListFiltered = detailsArrayListComplete;
        }
    }
    private void updateDetailsFiltered(ArrayList<AdDetails> adDetails){

        detailsArrayListFiltered = adDetails;
        notifyDataSetChanged();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_addetail,parent,false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        holder.tvName.setText(detailsArrayListFiltered.get(position).getName());
        holder.tvDesc.setText(detailsArrayListFiltered.get(position).getBookDesc());
        holder.tvPrice.setText(detailsArrayListFiltered.get(position).getPrice());
        holder.ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    //Tofo
            }
        });
        holder.ivWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return detailsArrayListFiltered.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvDesc,tvPrice;
        ImageView ivCall,ivWhatsapp;
        public MyHolder(View itemView) {
            super(itemView);
            tvName= (TextView) itemView.findViewById(R.id.tvName);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivCall = itemView.findViewById(R.id.ivCall);
            ivWhatsapp = itemView.findViewById(R.id.ivWhatsapp);
        }
    }
}
