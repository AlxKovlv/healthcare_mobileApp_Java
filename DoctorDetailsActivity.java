package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private  String [][] doctor_details1 ={
            {"Doctor Name: Stephen Strange","Clinic Address: street 12/34","Exp: 14 yrs", "Tel: 02345678", "700"},
            {"Doctor Name: Curtis Connors","Clinic Address: street 56/78","Exp: 33 yrs", "Tel: 02345678", "450"},
            {"Doctor Name: Jane Foster","Clinic Address: street 91/23","Exp: 3 yrs", "Tel: 02345678", "200"},
            {"Doctor Name: Helen Cho","Clinic Address: street 45/67","Exp: 8 yrs", "Tel: 02345678", "500"},
            {"Doctor Name: Bruce Banner","Clinic Address: street 89/12","Exp: 9 yrs", "Tel: 02345678", "250"},
    };

    private  String [][] doctor_details2 ={
            {"Doctor Name: Bruce Banner","Clinic Address: street 89/12","Exp: 9 yrs", "Tel: 02345678", "250"},
            {"Doctor Name: Stephen Strange","Clinic Address: street 12/34","Exp: 14 yrs", "Tel: 02345678", "700"},
            {"Doctor Name: Jane Foster","Clinic Address: street 91/23","Exp: 3 yrs", "Tel: 02345678", "200"},
            {"Doctor Name: Helen Cho","Clinic Address: street 45/67","Exp: 8 yrs", "Tel: 02345678", "500"},
            {"Doctor Name: Curtis Connors","Clinic Address: street 56/78","Exp: 33 yrs", "Tel: 02345678", "450"},
    };

    private  String [][] doctor_details3 ={
            {"Doctor Name: Curtis Connors","Clinic Address: street 56/78","Exp: 33 yrs", "Tel: 02345678", "450"},
            {"Doctor Name: Jane Foster","Clinic Address: street 91/23","Exp: 3 yrs", "Tel: 02345678", "200"},
            {"Doctor Name: Helen Cho","Clinic Address: street 45/67","Exp: 8 yrs", "Tel: 02345678", "500"},
            {"Doctor Name: Stephen Strange","Clinic Address: street 12/34","Exp: 14 yrs", "Tel: 02345678", "700"},
            {"Doctor Name: Bruce Banner","Clinic Address: street 89/12","Exp: 9 yrs", "Tel: 02345678", "250"},
    };

    private  String [][] doctor_details4 ={
            {"Doctor Name: Stephen Strange","Clinic Address: street 12/34","Exp: 14 yrs", "Tel: 02345678", "700"},
            {"Doctor Name: Helen Cho","Clinic Address: street 45/67","Exp: 8 yrs", "Tel: 02345678", "500"},
            {"Doctor Name: Bruce Banner","Clinic Address: street 89/12","Exp: 9 yrs", "Tel: 02345678", "250"},
            {"Doctor Name: Curtis Connors","Clinic Address: street 56/78","Exp: 33 yrs", "Tel: 02345678", "450"},
            {"Doctor Name: Jane Foster","Clinic Address: street 91/23","Exp: 3 yrs", "Tel: 02345678", "200"},
    };

    private  String [][] doctor_details5 ={
            {"Doctor Name: Jane Foster","Clinic Address: street 91/23","Exp: 3 yrs", "Tel: 02345678", "200"},
            {"Doctor Name: Helen Cho","Clinic Address: street 45/67","Exp: 8 yrs", "Tel: 02345678", "500"},
            {"Doctor Name: Stephen Strange","Clinic Address: street 12/34","Exp: 14 yrs", "Tel: 02345678", "700"},
            {"Doctor Name: Curtis Connors","Clinic Address: street 56/78","Exp: 33 yrs", "Tel: 02345678", "450"},
            {"Doctor Name: Bruce Banner","Clinic Address: street 89/12","Exp: 9 yrs", "Tel: 02345678", "250"},
    };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewLTDTitle);
        btn = findViewById(R.id.buttonLTDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dieticians")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentists")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeons")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Consult Fee: "+doctor_details[i][4]+"$");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,});
        ListView lst = findViewById(R.id.listViewBMList);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
            it.putExtra("text1",title);
            it.putExtra("text2",doctor_details[i][0]);
            it.putExtra("text3",doctor_details[i][1]);
            it.putExtra("text4",doctor_details[i][3]);
            it.putExtra("text5",doctor_details[i][4]);
            startActivity(it);
            }
        });
    }
}