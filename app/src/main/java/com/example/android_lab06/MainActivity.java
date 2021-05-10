package com.example.android_lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private EditText edtValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            TextView tvName = view.findViewById(R.id.tvName);
            edtValue.setText(tvName.getText().toString());
        });

        adapter = new CustomAdapter(this, R.layout.list_item);
        listView.setAdapter(adapter);

        edtValue = findViewById(R.id.edtValue);

        findViewById(R.id.btnAdd).setOnClickListener(v -> {
            String value = edtValue.getText().toString();

            if(!value.trim().isEmpty()) {
                adapter.add(value);
            }
        });

        findViewById(R.id.btnRemove).setOnClickListener(v -> {
            String value = edtValue.getText().toString();

            if(!value.trim().isEmpty())
                adapter.remove(value);
        });
    }
}