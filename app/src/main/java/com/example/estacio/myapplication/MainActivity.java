package com.example.estacio.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEditAlcool;
    private EditText mEditGasolina;
    private Button mBtn_Calc;
    private TextView result;

    float number1 = 0,number2=0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            result = findViewById(R.id.resultEdit);
            mEditAlcool  = findViewById(R.id.editAlcool);
            mEditGasolina = findViewById(R.id.editGasolina);
            mBtn_Calc = findViewById(R.id.btnCalc);

        mBtn_Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            number1 =  Float.valueOf(mEditAlcool.getText().toString());
            number2 =  Float.valueOf(mEditGasolina.getText().toString());
            if ( number1 * 0.7 >= number2)
            result.setText("Vá de alcool");
            else
                result.setText("Vá de Gasolina");
        }
    });

    }
}
