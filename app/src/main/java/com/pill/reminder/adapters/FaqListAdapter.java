package com.pill.reminder.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pill.reminder.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SO356253 on 5/14/2018.
 */

public class FaqListAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> questionList;
    List<String> answerList;

    public FaqListAdapter(Context context) {
        this.context = context;
        questionList = Arrays.asList(context.getResources().getStringArray(R.array.faq_questions));
        answerList = Arrays.asList(context.getResources().getStringArray(R.array.faq_answers));
    }

    @Override
    public int getGroupCount() {
        return questionList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return questionList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return answerList.get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.view_expandable_parent, null);
        }

        TextView txtHeader = view.findViewById(R.id.txt_exp_parent);
        ImageView imgIndicator = view.findViewById(R.id.img_exp_indicator);
        txtHeader.setText(questionList.get(i));
        if(b)
            imgIndicator.setImageResource(R.drawable.ic_exp_arrow_up);
        else
            imgIndicator.setImageResource(R.drawable.ic_exp_arrow_down);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.view_expandable_child, null);
        }

        TextView txtChild = view.findViewById(R.id.txt_exp_child);
        txtChild.setText(answerList.get(i));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
