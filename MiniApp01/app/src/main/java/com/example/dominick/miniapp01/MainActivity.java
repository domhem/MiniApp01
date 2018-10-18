package com.example.dominick.miniapp01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //user inputs (network speed and file size)
    private EditText networkInput;
    private EditText filesizeInput;

    private TextView transfer_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the user inputs
        networkInput = (EditText) findViewById(R.id.netInput);
        filesizeInput = (EditText) findViewById(R.id.fileInput);

        //get the calculate button
        Button tt_calculate = (Button) findViewById(R.id.calcButton);

        //get the transfer time view
        transfer_time = (TextView) findViewById(R.id.tt_result);

        //call the calculate function when the button is clicked
        tt_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttCalculation();
            }
        });

    }

    private void ttCalculation(){
        int n_input = Integer.valueOf(networkInput.getText().toString());
        int f_input = Integer.valueOf(filesizeInput.getText().toString());

        //convert MiB and M to bytes to find the transfer time in seconds
        double f_size = f_input * Math.pow(2,20);
        double n_size = n_input * 125000;

        double result = f_size/n_size;

        DecimalFormat df = new DecimalFormat("#.#");

        transfer_time.setText((df.format(result)));


    }
}
