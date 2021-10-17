package com.example.year22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tb1;
    EditText et1, et2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb1 = (ToggleButton) findViewById(R.id.tb1);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        b1 = (Button) findViewById(R.id.b1);
    }

    public void send(View view) {
        if (et2.getText().toString().matches("") || et1.getText().toString().matches("")){
            Toast.makeText(this, "please fill every input field", Toast.LENGTH_LONG).show();
        }
        else {
            int mode;
            if (tb1.isChecked()) {
                mode = 1;
            } else {
                mode = 0;
            }

            double diff = Double.parseDouble(et2.getText().toString());
            double first = Double.parseDouble(et1.getText().toString());

            if (mode == 1 && diff == 0 || mode == 1 && first == 0) {
                Toast.makeText(this, "in a geometric sequence the diffrence / first item cant be 0", Toast.LENGTH_LONG).show();
            } else {
                Intent si = new Intent(this, results.class);
                si.putExtra("mode", mode);
                si.putExtra("first", et1.getText().toString());
                si.putExtra("diff", et2.getText().toString());
                startActivity(si);
            }
        }
    }
}