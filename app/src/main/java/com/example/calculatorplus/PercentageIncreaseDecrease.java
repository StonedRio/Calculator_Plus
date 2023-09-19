package com.example.calculatorplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class PercentageIncreaseDecrease extends AppCompatActivity {

    TextView differenceTextview, isTextview;
    TextInputEditText fromEdittext, increaseEdittext;

    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8,
            button9, buttonDot, buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentage_increase_decrease);


        differenceTextview = findViewById(R.id.difference_textview);
        isTextview = findViewById(R.id.is_textView);


        fromEdittext = findViewById(R.id.from_edittext);
        increaseEdittext = findViewById(R.id.increase_edittext);


        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.buttonDot);
        buttonDelete = findViewById(R.id.button_delete);


        // Set click listeners for the number and dot buttons
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("0");
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("9");
            }
        });


        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText(".");
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteText();
            }
        });


        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculatePercentageIncreaseDecrease();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        fromEdittext.addTextChangedListener(textWatcher);
        fromEdittext.setShowSoftInputOnFocus(false);

        increaseEdittext.addTextChangedListener(textWatcher);
        increaseEdittext.setShowSoftInputOnFocus(false);
    }

    private void appendText(String text) {
        TextInputEditText selectedEditText = getSelectedEditText();
        if (selectedEditText != null) {
            Editable editable = selectedEditText.getText();
            int start = selectedEditText.getSelectionStart();
            editable.insert(start, text);
        }
    }

    private void deleteText() {
        TextInputEditText selectedEditText = getSelectedEditText();
        if (selectedEditText != null) {
            Editable editable = selectedEditText.getText();
            int start = selectedEditText.getSelectionStart();
            int end = selectedEditText.getSelectionEnd();
            if (start != end) {
                editable.delete(start, end);
            } else if (start > 0) {
                editable.delete(start - 1, start);
            }
        }
    }


    private void calculatePercentageIncreaseDecrease() {
        String fromText = fromEdittext.getText().toString();
        String increaseText = increaseEdittext.getText().toString();


        if (!fromText.isEmpty() && !increaseText.isEmpty()) {
            double fromValue = Double.parseDouble(fromText);
            double increaseValue = Double.parseDouble(increaseText);


            double result = ((increaseValue - fromValue) / Math.abs(fromValue)) * 100;


            String resultText;
            if (result > 0) {
                resultText = String.format("Increase: %.2f%%", Math.abs(result));
            } else if (result < 0) {
                resultText = String.format("Decrease: %.2f%%", Math.abs(result));
            } else {
                resultText = "No change";
            }


            differenceTextview.setText(resultText);
            isTextview.setText("is");
        } else {
            differenceTextview.setText("");
            isTextview.setText("");
        }
    }


    private TextInputEditText getSelectedEditText() {
        if (fromEdittext.hasFocus()) {
            return fromEdittext;
        } else if (increaseEdittext.hasFocus()) {
            return increaseEdittext;
        }
        return null;
    }

}