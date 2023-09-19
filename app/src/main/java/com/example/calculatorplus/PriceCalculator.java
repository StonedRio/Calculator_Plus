package com.example.calculatorplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class PriceCalculator extends AppCompatActivity {

    TextView smallerPricePerUnitTextview, largePricePerUnitTextview,youSavedTExtview;
    TextInputEditText smallerProductQuantityEdittext, smallerProductPriceEdittext,
            largeProductQuantityEdittext, largeProductPriceEdittext;

    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8,
            button9, buttonDot, buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_calculator);



        smallerPricePerUnitTextview = findViewById(R.id.smaller_price_per_unit_textview);
        largePricePerUnitTextview = findViewById(R.id.large_Price_per_Unit_textview);
        youSavedTExtview = findViewById(R.id.you_saved_textview);


        smallerProductQuantityEdittext = findViewById(R.id.smaller_quantity_edittext);
        smallerProductPriceEdittext = findViewById(R.id.smaller_product_price_edittext);
        largeProductPriceEdittext = findViewById(R.id.large_product_price_edittext);
        largeProductQuantityEdittext = findViewById(R.id.large_product_quantity_edittext);


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
                calculatePrices();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        smallerProductQuantityEdittext.addTextChangedListener(textWatcher);
        smallerProductQuantityEdittext.setShowSoftInputOnFocus(false);

        smallerProductPriceEdittext.addTextChangedListener(textWatcher);
        smallerProductPriceEdittext.setShowSoftInputOnFocus(false);

        largeProductQuantityEdittext.addTextChangedListener(textWatcher);
        largeProductQuantityEdittext.setShowSoftInputOnFocus(false);

        largeProductPriceEdittext.addTextChangedListener(textWatcher);
        largeProductPriceEdittext.setShowSoftInputOnFocus(false);
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

    private void calculatePrices() {
        String smallerQuantityText = smallerProductQuantityEdittext.getText().toString();
        String smallerPriceText = smallerProductPriceEdittext.getText().toString();
        String largeQuantityText = largeProductQuantityEdittext.getText().toString();
        String largePriceText = largeProductPriceEdittext.getText().toString();


        double smallerQuantity = 0;
        double smallerPrice = 0;
        double largeQuantity = 0;
        double largePrice = 0;


        if (!smallerQuantityText.isEmpty()) {
            smallerQuantity = Double.parseDouble(smallerQuantityText);
        }
        if (!smallerPriceText.isEmpty()) {
            smallerPrice = Double.parseDouble(smallerPriceText);
        }
        if (!largeQuantityText.isEmpty()) {
            largeQuantity = Double.parseDouble(largeQuantityText);
        }
        if (!largePriceText.isEmpty()) {
            largePrice = Double.parseDouble(largePriceText);
        }


        double smallerPricePerUnit = (smallerPrice > 0 && smallerQuantity > 0) ? smallerPrice / smallerQuantity : 0;
        double largePricePerUnit = (largePrice > 0 && largeQuantity > 0) ? largePrice / largeQuantity : 0;


        double youSaved = (smallerPricePerUnit > 0 && largePricePerUnit > 0) ? (smallerPricePerUnit - largePricePerUnit) * smallerQuantity : 0;


        smallerPricePerUnitTextview.setText(String.format("Smaller Price Per Unit: %.2f", smallerPricePerUnit));
        largePricePerUnitTextview.setText(String.format("Large Price Per Unit: %.2f", largePricePerUnit));
        youSavedTExtview.setText(String.format("You Saved: %.2f", youSaved));
    }


    private TextInputEditText getSelectedEditText() {
        if (smallerProductQuantityEdittext.hasFocus()) {
            return smallerProductQuantityEdittext;
        } else if (smallerProductPriceEdittext.hasFocus()) {
            return smallerProductPriceEdittext;
        } else if (largeProductQuantityEdittext.hasFocus()) {
            return largeProductQuantityEdittext;
        } else if (largeProductPriceEdittext.hasFocus()) {
            return largeProductPriceEdittext;
        }
        return null;
    }

}