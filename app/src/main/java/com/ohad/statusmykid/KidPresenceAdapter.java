package com.ohad.statusmykid;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class KidPresenceAdapter extends ArrayAdapter<Kid>{

    private Activity activity;
    private List<Kid> kids;

    public KidPresenceAdapter(Activity activity, int row_kid, List<Kid> kids) {
        super(activity, R.layout.row_kid);
        this.activity = activity;
        this.kids = kids;
    }

    private static class ViewContiner{
        TextView prs_class_name, prs_kid_name, prs_kid_last_name;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        ViewContiner viewContiner = null;
        if(row == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            row = inflater.inflate(R.layout.row_kid, parent, false);
            viewContiner = new ViewContiner();
            viewContiner.prs_class_name = row.findViewById(R.id.prs_class_name);
            viewContiner.prs_kid_name = row.findViewById(R.id.prs_kid_name);
            viewContiner.prs_kid_last_name = row.findViewById(R.id.prs_kid_last_name);
            row.setTag(viewContiner);
        }else {
            viewContiner = (ViewContiner) row.getTag();
        }

        Kid kid = kids.get(position);
        viewContiner.prs_class_name.setText(kid.className);
        viewContiner.prs_kid_name.setText(kid.firstName);
        viewContiner.prs_kid_last_name.setText(kid.lastName);
        return row;
    }
}
