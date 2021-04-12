package com.example.th;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.th.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtName;
    private int id = 0;
    private String date="1/4/2021";
    private RadioButton radioNam, radioNu;
    private Button btnAdd, btnDob;
    private List<Student> listStudent = new ArrayList<>();
    private Spinner spinner;
    private List<Integer> imgs= new ArrayList<>();
    private StudentsAdapter adapter;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView(){
        lv = findViewById(R.id.lv);
        txtName = findViewById(R.id.txtName);
        radioNam = findViewById(R.id.radioName);
        radioNu = findViewById(R.id.radioNu);
        btnAdd = findViewById(R.id.btnAdd);
        btnDob = findViewById(R.id.btnDob);
        btnDob.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        spinner = findViewById(R.id.spiner);
        imgs.add(R.drawable.cat1);
        imgs.add(R.drawable.cat2);
        spinner.setAdapter(new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_dropdown_item,imgs));
        adapter = new StudentsAdapter(this,listStudent);
        lv.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                listStudent.add(new Student(id++,(int)spinner.getSelectedItem(),txtName.getText().toString(),date,(radioNam.isChecked())?"Nam":"Nu"));
                adapter.notifyDataSetChanged();
                break;
            case R.id.btnDob:
                DatePickerDialog picker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date =dayOfMonth +"/"+month+"/"+year;
                    }
                },2021,4,1);
                picker.show();
                break;
        }

    }
}