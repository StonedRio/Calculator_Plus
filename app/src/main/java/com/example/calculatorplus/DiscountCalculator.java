package com.example.calculatorplus;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class DiscountCalculator extends AppCompatActivity {
    TextView afterTextview, youSaveTextview;
    TextInputEditText discountEdittext, beforeEdittext;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8,
            button9, buttonDot, buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount_calculator);

        afterTextview = findViewById(R.id.textView_after);
        youSaveTextview = findViewById(R.id.textview_you_save);

        discountEdittext = findViewById(R.id.discount_edittext);
        beforeEdittext = findViewById(R.id.before_edittext);

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
                calculateDiscount();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        discountEdittext.addTextChangedListener(textWatcher);
        discountEdittext.setShowSoftInputOnFocus(false);
        beforeEdittext.addTextChangedListener(textWatcher);
        beforeEdittext.setShowSoftInputOnFocus(false);
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

    private void calculateDiscount() {
        String discountText = discountEdittext.getText().toString();
        String beforeText = beforeEdittext.getText().toString();

        if (!discountText.isEmpty() && !beforeText.isEmpty()) {
            double discount = Double.parseDouble(discountText);
            double before = Double.parseDouble(beforeText);

            double after = before - (before * (discount / 100));
            double youSave = before - after;

            afterTextview.setText(String.format("%.2f", after));
            youSaveTextview.setText(String.format("%.2f", youSave));
        } else {
            afterTextview.setText("");
            youSaveTextview.setText("");
        }
    }

    private TextInputEditText getSelectedEditText() {
        if (discountEdittext.hasFocus()) {
            return discountEdittext;
        } else if (beforeEdittext.hasFocus()) {
            return beforeEdittext;
        }
        return null;
    }

}
