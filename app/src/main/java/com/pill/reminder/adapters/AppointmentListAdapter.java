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
import com.pill.reminder.models.Appointment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AppointmentListAdapter extends RecyclerView.Adapter<AppointmentListAdapter.AppointmentViewHolder> {

    Context context;
    List<Appointment> appointmentList;
    ListItemClickListener listener;

    public AppointmentListAdapter(Context context, List<Appointment> appointmentList) {
        this.context = context;
        this.appointmentList = appointmentList;
        listener = (ListItemClickListener) context;
    }

    public class AppointmentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_doctor_name)
        TextView txtDoctorName;
        @BindView(R.id.txt_doctor_speciality)
        TextView txtSpeciality;
        @BindView(R.id.txt_date)
        TextView txtDate;
        @BindView(R.id.txt_time)
        TextView txtTime;
        @BindView(R.id.cardview)
        CardView cardView;

        public AppointmentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public AppointmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_appointments_list_item, parent, false);
        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AppointmentViewHolder holder, final int position) {
        holder.txtDoctorName.setText(appointmentList.get(position).getDoctorName());
        holder.txtSpeciality.setText(appointmentList.get(position).getDoctorSpeciality());
        holder.txtDate.setText(appointmentList.get(position).getDate());
        holder.txtTime.setText(appointmentList.get(position).getTime());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }
}
