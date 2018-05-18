package com.pill.reminder.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pill.reminder.R;
import com.pill.reminder.interfaces.ListItemClickListener;
import com.pill.reminder.models.Measurement;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MeasurementListAdapter extends RecyclerView.Adapter<MeasurementListAdapter.MeasurementViewHolder> {

    Context context;
    List<Measurement> measurementList;
    ListItemClickListener listener;

    public MeasurementListAdapter(Context context, List<Measurement> measurementList) {
        this.context = context;
        this.measurementList = measurementList;
        listener = (ListItemClickListener) context;
    }

    public class MeasurementViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.txt_value)
        TextView txtValue;
        @BindView(R.id.txt_factor)
        TextView txtFactor;
        @BindView(R.id.txt_datetime)
        TextView txtDateTime;
        @BindView(R.id.cardview)
        CardView cardView;

        
        public MeasurementViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public MeasurementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_measurements_list_item, parent,false);
        return new MeasurementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MeasurementViewHolder holder, final int position) {
        holder.txtValue.setText(measurementList.get(position).getValue()+" "+measurementList.get(position).getUnit());
        holder.txtFactor.setText(measurementList.get(position).getFactor());
        holder.txtDateTime.setText(measurementList.get(position).getDatetime());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return measurementList.size();
    }
}
