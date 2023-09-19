package com.example.calculatorplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout percentageCalculator,tipCalculator,discountCalculator, priceCalculator,
            percentIncDecCalculator,fracToPercentCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percentageCalculator=findViewById(R.id.percentage_calculator);
        tipCalculator=findViewById(R.id.tip_calculator);
        discountCalculator=findViewById(R.id.discount_calculator);
        priceCalculator=findViewById(R.id.price_calculator);
        percentIncDecCalculator=findViewById(R.id.percentage_increase_decrease);
        fracToPercentCalculator=findViewById(R.id.fraction_to_percentage);

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

        discountCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DiscountCalculator.class);
                startActivity(intent);
            }
        });

        priceCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PriceCalculator.class);
                startActivity(intent);
            }
        });

        percentIncDecCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PercentageIncreaseDecrease.class);
                startActivity(intent);
            }
        });

        fracToPercentCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FractionToPercentage.class);
                startActivity(intent);
            }
        });

    }
}