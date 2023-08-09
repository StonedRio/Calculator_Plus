package com.example.calculatorplus.fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.example.calculatorplus.R;

public class IncreaseFragment extends Fragment {
    EditText startingValueEdittext, percentageEdittext, resultEdittext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_increase, container, false);
        startingValueEdittext = view.findViewById(R.id.starting_value_edittext);
        percentageEdittext = view.findViewById(R.id.percentage_edittext);
        resultEdittext = view.findViewById(R.id.result_edittext);

        startingValueEdittext.addTextChangedListener(new TextWatcher() {
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

        percentageEdittext.addTextChangedListener(new TextWatcher() {
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
            String sValue = startingValueEdittext.getText().toString();
            String perc = percentageEdittext.getText().toString();

            double startingValue = Double.parseDouble(sValue);
            double percentage = Double.parseDouble(perc);
            double result = startingValue * (1 + percentage / 100);
            String resultStr = String.valueOf(result);
            resultEdittext.setText(resultStr);
        } catch (NumberFormatException e) {
            resultEdittext.setText("");
        }
    }
}