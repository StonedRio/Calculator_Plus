package com.example.calculatorplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculator extends AppCompatActivity {
    TextView totalAmountTextview,tipAmountTextview,tipPerPersonTextview,totalPerPersonTextview;
    EditText numberOfPersonsEdittext,tipPercentEdittext,billEdittext;

    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonpoint,buttonDelete;

    private EditText activeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        totalAmountTextview=findViewById(R.id.total_amount_textView);
        tipAmountTextview=findViewById(R.id.tip_amount_textView);
        tipPerPersonTextview=findViewById(R.id.tip_per_person_textView);
        totalPerPersonTextview=findViewById(R.id.total_per_person_textview);

        numberOfPersonsEdittext=findViewById(R.id.number_of_persons_edittext);
        tipPercentEdittext=findViewById(R.id.tip_percent_edittext);
        billEdittext=findViewById(R.id.bill_edittext);



        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        buttonpoint=findViewById(R.id.button_dot);
        buttonDelete=findViewById(R.id.button_clear);

        button0.setOnClickListener(onClickListener);
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
        button6.setOnClickListener(onClickListener);
        button7.setOnClickListener(onClickListener);
        button8.setOnClickListener(onClickListener);
        button9.setOnClickListener(onClickListener);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activeEditText != null && activeEditText.length() > 0) {
                    activeEditText.setText(activeEditText.getText().subSequence(0, activeEditText.length() - 1));
                }
            }
        });

        numberOfPersonsEdittext.addTextChangedListener(textWatcher);
        tipPercentEdittext.addTextChangedListener(textWatcher);
        billEdittext.addTextChangedListener(textWatcher);
    }




    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            if (activeEditText != null) {
                String currentText = activeEditText.getText().toString();
                activeEditText.setText(currentText + button.getText().toString());
            }
        }
    };


    private void setActiveEditText(EditText editText) {
        activeEditText = editText;
    }

    private void clearActiveEditText() {
        activeEditText = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        numberOfPersonsEdittext.setShowSoftInputOnFocus(false);
        tipPercentEdittext.setShowSoftInputOnFocus(false);
        billEdittext.setShowSoftInputOnFocus(false);


        numberOfPersonsEdittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    setActiveEditText(numberOfPersonsEdittext);
                } else {
                    clearActiveEditText();
                }
            }
        });

        tipPercentEdittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    setActiveEditText(tipPercentEdittext);
                } else {
                    clearActiveEditText();
                }
            }
        });

        billEdittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    setActiveEditText(billEdittext);
                } else {
                    clearActiveEditText();
                }
            }
        });
    }




    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            calculateAndDisplayResults();
        }
    };



    private void calculateAndDisplayResults() {

        if (numberOfPersonsEdittext.getText().toString() != null && tipPercentEdittext.getText().toString() != ""
        && billEdittext.getText().toString() != null){


            String numberOfPersonsStr = numberOfPersonsEdittext.getText().toString();
            String tipPercentStr = tipPercentEdittext.getText().toString();
            String billStr = billEdittext.getText().toString();

            double numberOfPersons = Double.parseDouble(numberOfPersonsStr.isEmpty() ? "0" : numberOfPersonsStr);
            double tipPercent = Double.parseDouble(tipPercentStr.isEmpty() ? "0" : tipPercentStr);
            double billAmount = Double.parseDouble(billStr.isEmpty() ? "0" : billStr);

            double tipAmount = (tipPercent / 100) * billAmount;
            double totalAmount = billAmount + tipAmount;
            double tipPerPerson = tipAmount / numberOfPersons;
            double totalPerPerson = totalAmount / numberOfPersons;

            tipAmountTextview.setText(String.format("%.2f $", tipAmount));
            totalAmountTextview.setText(String.format("%.2f $", totalAmount));
            tipPerPersonTextview.setText(String.format("%.2f $", tipPerPerson));
            totalPerPersonTextview.setText(String.format("%.2f $", totalPerPerson));

        }
        else {
            tipAmountTextview.setText("0");
            totalAmountTextview.setText("0");
            tipPerPersonTextview.setText("0");
            totalPerPersonTextview.setText("0");

        }

    }



}