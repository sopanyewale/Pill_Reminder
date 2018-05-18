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
import com.pill.reminder.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.userViewHolder> {

    Context context;
    List<User> userList;
    ListItemClickListener listener;

    public UserListAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
        listener = (ListItemClickListener) context;
    }

    public class userViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_user_name)
        TextView txtUserName;
        @BindView(R.id.cardview)
        CardView cardview;

        public userViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public userViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_user_list_item, parent, false);
        return new userViewHolder(view);
    }

    @Override
    public void onBindViewHolder(userViewHolder holder, final int position) {
        holder.txtUserName.setText(userList.get(position).getUserName());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
