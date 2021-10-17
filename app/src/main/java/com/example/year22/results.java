package com.example.year22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class results extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String[] items = new String[20];
    ListView lv1;
    TextView tv1, tv2, tv3, tv4;
    int mode;
    double first, diff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        lv1 = (ListView) findViewById(R.id.lv1);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);

        Intent gi = getIntent();
        mode = gi.getIntExtra("mode",2);
        first = Double.parseDouble(gi.getStringExtra("first"));
        diff = Double.parseDouble(gi.getStringExtra("diff"));

        tv1.setText(""+first+" "+diff);

        if (mode == 0){
            for (int i=0;i<20;i++){
                items[i] = String.valueOf(first + i*diff);
            }
        }
        else{
            for (int i=0;i<20;i++){
                items[i] = String.valueOf(first*Math.pow(diff,i));
            }
        }

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, items);
        lv1.setAdapter(adp);
        lv1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv1.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mode == 0){
            tv1.setText("type: arithmetic");
            tv4.setText("sum: "+((first+Double.parseDouble(items[position]))* (position+1)/2));
        }
        else{
            tv1.setText("type: geometric");
            tv4.setText("sum: "+((first*(1-Math.pow(diff,position+1)))/(1-diff)));
        }

        tv2.setText("diffrence: "+diff);

        tv3.setText("Position: "+position);
    }

    public void ret(View view) {
        finish();
    }
}