package com.example.estacio.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.ParseException;

import faranjit.currency.edittext.CurrencyEditText;

public class MainActivity extends AppCompatActivity {

    private CurrencyEditText mEditAlcool,mEditGasolina;
    private Button mBtn_Calc;
    private SeekBar seekBar;
    private TextView seekText,mChangeAlcool,mChangeGas,result;
    private Double Alcool,gas;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            result = findViewById(R.id.resultEdit);
            mEditAlcool  = findViewById(R.id.editAlcool);
            mEditGasolina = findViewById(R.id.editGasolina);
            mBtn_Calc = findViewById(R.id.btnCalc);
            seekBar = findViewById(R.id.valueSeekBar);
            seekText=findViewById(R.id.valueChange);
            mChangeAlcool=findViewById(R.id.changeAlcool);
            mChangeGas=findViewById(R.id.changeGas);
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
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekText.setText( "R$" + progress*5);
            mChangeAlcool.setText(progress*5);
                mChangeGas.setText(progress*5);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });
    }

        private void calculate(double alcoolValue, double gasolinaValue) {
        result.setText("Alcool");
        if(alcoolValue / gasolinaValue > 0.7) {
            result.setText("Gasolina");
        }
    }

}
