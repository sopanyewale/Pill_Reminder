package com.pill.reminder.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pill.reminder.R;
import com.pill.reminder.adapters.UserListAdapter;
import com.pill.reminder.interfaces.ListItemClickListener;
import com.pill.reminder.models.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewUsersActivity extends AppCompatActivity implements ListItemClickListener{

    @BindView(R.id.recyclerview)
    RecyclerView usersListView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    List<User> userList;
    UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("View Users");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        userList = getDummyUsers();
        userListAdapter = new UserListAdapter(this, userList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        usersListView.setLayoutManager(layoutManager);
        usersListView.setItemAnimator(new DefaultItemAnimator());
        usersListView.setAdapter(userListAdapter);
    }

    private List<User> getDummyUsers() {
        List<User> list = new ArrayList<>();

        for(int i = 1; i < 6; i++){
            User user = new User("User "+i, User.GENDER.MALE, "21-Jan-1995");
            list.add(user);
        }
        return list;
    }

    @OnClick(R.id.fab)
    public void onFabClicked(){
        startActivity(new Intent(this, AddUserActivity.class));
    }

    @Override
    public void onItemClicked(int position) {
        startActivity(new Intent(this, AddUserActivity.class).putExtra("User", userList.get(position)));
    }
}
