package com.example.bmbfinal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmbfinal.Model.OrderModel;
import com.example.bmbfinal.R;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>  {

    private Context context;
    private List<OrderModel> orderModelList;

    public RecycleViewAdapter(Context context, List<OrderModel> orderModelList) {
        this.context=context;
        this.orderModelList = orderModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View listView = inflater.inflate(R.layout.recycler_row, parent, false);

        // Return a new holder instance
        MyViewHolder viewHolder = new MyViewHolder(listView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.MyViewHolder holder, int position) {
        holder.idTextView.setText(this.orderModelList.get(position).getId().toString());
        holder.clientDescriptionTextView.setText(this.orderModelList.get(position).getDescription().toString());
        holder.orderAmountTextView.setText(this.orderModelList.get(position).getOrderAmount().toString());
        holder.orderDateTextView.setText(this.orderModelList.get(position).getOrderDate().toString());
    }

    @Override
    public int getItemCount() {
        if(this.orderModelList!=null){
            return this.orderModelList.size();
        }
        return 0;    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        TextView idTextView;
        TextView clientDescriptionTextView;
        TextView orderAmountTextView;
        TextView orderDateTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            idTextView=(TextView) itemView.findViewById(R.id.id);
            clientDescriptionTextView=(TextView) itemView.findViewById(R.id.clientDescription);
            orderAmountTextView=(TextView) itemView.findViewById(R.id.orderAmount);
            orderDateTextView=(TextView) itemView.findViewById(R.id.date);
        }
    }
}
