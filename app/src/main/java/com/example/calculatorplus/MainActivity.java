package com.example.calculatorplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout percentageCalculator,tipCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percentageCalculator=findViewById(R.id.percentage_calculator);
        tipCalculator=findViewById(R.id.tip_calculator);


        percentageCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PercentageCalculator.class);
                startActivity(intent);
            }
        });

        tipCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,TipCalculator.class);
                startActivity(intent);
            }
        });
    }
}