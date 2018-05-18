package com.pill.reminder.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.pill.reminder.R;
import com.pill.reminder.models.Dose;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SO356253 on 5/4/2018.
 */

public class DoseListAdapter extends RecyclerView.Adapter<DoseListAdapter.DoseViewHolder> {

    Context context;
    List<Dose> doseList;

    public DoseListAdapter(Context context, List<Dose> doseList) {
        this.context = context;
        this.doseList = doseList;
    }

    public class DoseViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.chk_dose_taken)
        CheckBox chkMedicineTaken;
        @BindView(R.id.txt_dose_quantity)
        TextView txtQuantity;
        @BindView(R.id.img_icon)
        ImageView imgIcon;
        @BindView(R.id.txt_dose_time)
        TextView txtDoseTime;

        public DoseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public DoseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_dose, parent,false);
        return new DoseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DoseViewHolder holder, int position) {
        Dose d = doseList.get(position);
        holder.chkMedicineTaken.setChecked(d.isTaken());
        holder.chkMedicineTaken.setText(d.getMedicine_name());
        holder.txtQuantity.setText(d.getQuantity()+" "+d.getMedicine_type());
        holder.txtDoseTime.setText(d.getTime());
    }

    @Override
    public int getItemCount() {
        return doseList.size();
    }
}
