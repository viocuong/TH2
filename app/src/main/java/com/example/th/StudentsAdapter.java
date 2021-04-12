package com.example.th;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.th.model.Student;

import java.util.List;

public class StudentsAdapter extends ArrayAdapter<Student> {
    private List<Student> mList;
    private Activity activity;
    public StudentsAdapter(@NonNull Context context, List<Student> list) {
        super(context,R.layout.item,list);
        this.mList = list;
        activity = (Activity) context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student s = mList.get(position);
        View  v = activity.getLayoutInflater().inflate(R.layout.item,parent,false);
        ImageView img = v.findViewById(R.id.img);
        TextView id = v.findViewById(R.id.id);
        TextView name = v.findViewById(R.id.name);
        TextView dob = v.findViewById(R.id.dob);
        TextView gender = v.findViewById(R.id.gender);
        img.setImageResource(s.getRsImg());
        id.setText(""+s.getId());
        name.setText(s.getName());
        dob.setText(s.getDob());
        gender.setText(s.getGender());
        Button btnRemove = v.findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.remove(position);
                notifyDataSetChanged();
            }
        });
        return v;
    }
}
