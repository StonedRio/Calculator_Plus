package com.example.calculatorplus.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.example.calculatorplus.R;

public class CompleteFragment extends Fragment {
    EditText startingValueEditText, percentageEditText, differenceEditText, resultEditText;
    TextView toggleTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_complete, container, false);
        startingValueEditText = view.findViewById(R.id.starting_value_edittext);
        percentageEditText = view.findViewById(R.id.percentage_edittext);
        differenceEditText = view.findViewById(R.id.difference_edittext);
        resultEditText = view.findViewById(R.id.result_edittext);
        toggleTextView = view.findViewById(R.id.toggle_textview);

        toggleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleTextView.getText().toString().equals("+")) {
                    toggleTextView.setText("-");
                } else if (toggleTextView.getText().toString().equals("-")) {
                    toggleTextView.setText("+");
                }
                calculateResult();
            }
        });

        startingValueEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculateResult();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        percentageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculateResult();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        return view;
    }

    private void calculateResult() {
        try {
            String sValue = startingValueEditText.getText().toString();
            String perc = percentageEditText.getText().toString();

            double startingValue = Double.parseDouble(sValue);
            double percentage = Double.parseDouble(perc);

            double result = toggleTextView.getText().toString().equals("+") ?
                    startingValue * (1 + percentage / 100) :
                    startingValue * (1 - percentage / 100);
            String resultStr = String.valueOf(result);
            resultEditText.setText(resultStr);


            double difference = result - startingValue;
            String differenceStr = String.valueOf(difference);
            differenceEditText.setText(differenceStr);
        } catch (NumberFormatException e) {
            resultEditText.setText("");
            differenceEditText.setText("");
        }
    }
}
