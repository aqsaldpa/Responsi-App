package com.paymu.app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paymu.app.HistoryModelClass;
import com.paymu.app.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private List<HistoryModelClass> historylist;

    public RVAdapter(List<HistoryModelClass> historylist) {
        this.historylist = historylist;
    }


    @NonNull
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.ViewHolder holder, int position) {

        int resource = historylist.get(position).getImageview();
        String tgl = historylist.get(position).getTv1();
        String ket = historylist.get(position).getTv2();
        String sukses = historylist.get(position).getTv3();
        String line=historylist.get(position).getDivider();

        holder.setData(resource, tgl, ket, sukses,line);
    }

    @Override
    public int getItemCount() {
        return historylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView textView2;
        private TextView textview3;
        private TextView divider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textview3 = itemView.findViewById(R.id.textView3);
            divider=itemView.findViewById(R.id.Divider);

        }

        public void setData(int resource, String tgl, String ket, String sukses,String line) {

            imageView.setImageResource(resource);
            textView.setText(tgl);
            textView2.setText(ket);
            textview3.setText(sukses);
            divider.setText(line);
        }
    }
}

