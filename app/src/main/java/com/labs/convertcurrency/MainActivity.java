package com.labs.convertcurrency;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView cvtResult;
    private Spinner snFromCurrency;
    private Spinner snToCurrency;
    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncGetCurrency(snFromCurrency.getSelectedItem().toString().substring(0,3)
                        ,snToCurrency.getSelectedItem().toString().substring(0,3)
                        ,cvtResult).execute();
            }
        });
    }

    private void addControls() {
        findId();
        addDataToSpinner();
    }

    private void addDataToSpinner() {
        List<String> list = new ArrayList<>();
        list.add("USD - Dollar Mỹ");
        list.add("EUR - Euro");
        list.add("GBP - Bảng Anh");
        list.add("JPY - Yên Nhật");
        list.add("CAD - Đồng Canada");
        list.add("AUD - Dollar Úc");
        list.add("CNY - Nhân Dân Tệ");
        list.add("CHF - Franc Thụy Sĩ");
        list.add("SGD - Dollar Singapore");
        list.add("HKD - Dollar HongKong");
        list.add("VND - Việt Nam Đồng");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        snFromCurrency.setAdapter(adapter);
        snToCurrency.setAdapter(adapter);
    }

    private void findId() {
        cvtResult = (TextView)findViewById(R.id.cvtResult);
        snFromCurrency =(Spinner)findViewById(R.id.snFromCurrency);
        snToCurrency =(Spinner)findViewById(R.id.snToCurrency);
        btnConvert = (Button)findViewById(R.id.btnConvert);
    }
}