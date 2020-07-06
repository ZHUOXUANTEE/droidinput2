/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;

import java.lang.reflect.Array;

/**
 * This activity shows the order chosen.  The order is sent as data
 * with the intent to launch this activity.
 */
public class OrderActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private CheckBox chocolateSyrup, sprinkles, crushedNuts,cherries,orio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        initializeUI();

        Spinner spinner = findViewById(R.id.label_spinner);
        if(spinner != null)
            spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.labels_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if(spinner != null)
            spinner.setAdapter(adapter);

        // Get the intent and its data.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }




    public void onRadioButtonClicked(View view) {
        Boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId())
        {
            case R.id.sameday:
                if(checked)
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if(checked)
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;

            case R.id.pickup:
                if(checked)
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void onShowToastButtonClicked(View view) {
        String message = "Toppings: ";

        if(chocolateSyrup.isChecked())
            message += getString(R.string.chocolateSyrup) + " ";

        if(sprinkles.isChecked())
            message += getString(R.string.sprinkles) + " ";

        if(crushedNuts.isChecked())
            message += getString(R.string.crushedNuts) + " ";

        if(cherries.isChecked())
            message += getString(R.string.cherries) + " ";

        if(orio.isChecked())
            message += getString(R.string.orioCookieCrumbles) + " ";

        displayToast(message);

    }
    public void   initializeUI()
    {
        chocolateSyrup = findViewById(R.id.chocolateSyrup);
        sprinkles = findViewById(R.id.sprinkles);
        orio = findViewById(R.id.orioCookie);
        cherries = findViewById(R.id.cherries);
        crushedNuts = findViewById(R.id.crushedNuts);
    }

}
