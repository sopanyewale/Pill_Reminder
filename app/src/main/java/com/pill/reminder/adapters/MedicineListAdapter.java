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
import com.pill.reminder.models.Doctor;
import com.pill.reminder.models.Dose;
import com.pill.reminder.models.Medicine;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SO356253 on 5/4/2018.
 */

public class MedicineListAdapter extends RecyclerView.Adapter<MedicineListAdapter.MedicineViewHolder> {

    Context context;
    List<Dose> medicineList;
    ListItemClickListener listener;

    public MedicineListAdapter(Context context, List<Dose> medicineList) {
        this.context = context;
        this.medicineList = medicineList;
        listener = (ListItemClickListener) context;
    }

    public class MedicineViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.txt_medicine_name)
        TextView txtMedicineName;
        @BindView(R.id.txt_quantity)
        TextView txtQuantity;
        @BindView(R.id.cardview)
        CardView cardView;

        public MedicineViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public MedicineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_medicine_list_item, parent,false);
        return new MedicineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MedicineViewHolder holder, final int position) {
        holder.txtMedicineName.setText(medicineList.get(position).getMedicine_name());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return medicineList.size();
    }
}
