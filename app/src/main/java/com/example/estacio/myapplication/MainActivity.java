package com.example.estacio.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;

import faranjit.currency.edittext.CurrencyEditText;

public class MainActivity extends AppCompatActivity {

    private CurrencyEditText mEditAlcool;
    private CurrencyEditText mEditGasolina;
    private Button mBtn_Calc;
    private TextView result;

    double number1 = 0,number2=0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            result = findViewById(R.id.resultEdit);
            mEditAlcool  = findViewById(R.id.editAlcool);
            mEditGasolina = findViewById(R.id.editAlcool);
            mBtn_Calc = findViewById(R.id.btnCalc);

        mBtn_Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    calculate(mEditAlcool.getCurrencyDouble(),mEditGasolina.getCurrencyDouble());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
    });
        }
    private void calculate(double alcoolValue, double gasolinaValue) {
        if(alcoolValue / gasolinaValue > 0.7) {
            result.setText("Gasolina");
        }
            result.setText("Alcool");


    }

}
