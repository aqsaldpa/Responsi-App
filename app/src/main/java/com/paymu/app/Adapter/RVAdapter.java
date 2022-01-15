package com.paymu.app.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paymu.app.Fragment.FragmentHistory;
import com.paymu.app.Data.Model.HistoryModelClass;
import com.paymu.app.R;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.viewholder> implements View.OnClickListener{

    ArrayList<HistoryModelClass> dataholder;
    FragmentHistory clickListener;

    public RVAdapter(ArrayList<HistoryModelClass> dataholder, FragmentHistory clickListener) {
        this.dataholder = dataholder;
        this.clickListener = clickListener;
    }

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public RVAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item,parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.transaksi.setText(dataholder.get(position).getJenis());
        holder.tanggal.setText(dataholder.get(position).getTanggal());
        holder.status.setText(dataholder.get(position).getStatus());

        String status = dataholder.get(position).getStatus();
        if(status.equalsIgnoreCase("Success")){
            holder.status.setText("Success");
            holder.status.setTextColor(Color.parseColor("#5CC615"));
        }else{
            holder.status.setText("Failed");
            holder.status.setTextColor(Color.parseColor("#FF0000"));
        }

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView transaksi, tanggal, status;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            transaksi = itemView.findViewById(R.id.transaction);
            tanggal = itemView.findViewById(R.id.tgl);
            status = itemView.findViewById(R.id.status);


        }
    }
}
