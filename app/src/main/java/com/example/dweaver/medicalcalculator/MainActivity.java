package com.example.dweaver.medicalcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double priceEntered;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText price = (EditText) findViewById(R.id.txtPrice);
        final RadioButton data1 = (RadioButton) findViewById(R.id.data1);
        final RadioButton data2 = (RadioButton) findViewById(R.id.data2);
        final RadioButton data3 = (RadioButton) findViewById(R.id.data3);
        final TextView result= (TextView) findViewById(R.id.txtResult);
        Button convert= (Button) findViewById(R.id.btnConvert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priceEntered = Double.parseDouble(price.getText().toString());
                DecimalFormat tenth= new DecimalFormat("#.#");
                if(data1.isChecked()) {

                        total = priceEntered * .90;
                        result.setText("$"+tenth.format(total));


                    }

                    if(data2.isChecked()){
                        if(priceEntered<= 500){
                            total= priceEntered*.80;
                            result.setText("$"+ tenth.format(total));


                        }
                        else{
                            Toast.makeText(MainActivity.this,"Price must be lower than $500, for Larger plans please call 555-555-5555",Toast.LENGTH_LONG).show();
                        }
                    }
                if(data3.isChecked()) {
                    if (priceEntered <= 300) {
                        total = priceEntered * .75;
                        result.setText("$"+ tenth.format(total));

                    }else{
                        Toast.makeText(MainActivity.this,"Price must be lower than $300, for Larger plans please call 555-555-5555",Toast.LENGTH_LONG).show();
                    }
                }
                }

            });
        }


    }


