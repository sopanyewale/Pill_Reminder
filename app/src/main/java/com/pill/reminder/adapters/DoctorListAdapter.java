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
import com.pill.reminder.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SO356253 on 5/4/2018.
 */

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.DoctorViewHolder> {

    Context context;
    List<Doctor> doctorList;
    ListItemClickListener listener;

    public DoctorListAdapter(Context context, List<Doctor> doctorList) {
        this.context = context;
        this.doctorList = doctorList;
        listener = (ListItemClickListener) context;
    }

    public class DoctorViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.txt_doctor_name)
        TextView txtDoctorName;
        @BindView(R.id.txt_doctor_speciality)
        TextView txtSpeciality;
        @BindView(R.id.cardview)
        CardView cardView;

        public DoctorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public DoctorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_doctor_list_item, parent,false);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DoctorViewHolder holder, final int position) {
        holder.txtDoctorName.setText(doctorList.get(position).getName());
        holder.txtSpeciality.setText(doctorList.get(position).getSpeciality());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }
}
