package com.example.abc.sitemeter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Spinner spinner_state;
    Spinner spinner_region;
    Spinner spinner_unit;
    Spinner out_spinner_country;
    Spinner out_spinner_state;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    spinner_state = (Spinner)findViewById(R.id.in_spinner_state);
    CharSequence[] strings = this.getResources().getTextArray(R.array.state_array);
    CustomAdapter<CharSequence> adapter = new CustomAdapter<CharSequence>(this,
            android.R.layout.simple_spinner_item, strings);
// Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
    spinner_state.setAdapter(adapter);

    spinner_region = (Spinner)findViewById(R.id.in_spinner_region);
    CustomAdapter<CharSequence> adapter_state = new CustomAdapter<CharSequence>(this,
            android.R.layout.simple_spinner_item,this.getResources().getTextArray(R.array.region_array));
// Specify the layout to use when the list of choices appears
    adapter_state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
    spinner_region.setAdapter(adapter_state);


    spinner_unit = (Spinner)findViewById(R.id.in_spinner_unit);
    CustomAdapter<CharSequence> adapter_unit = new CustomAdapter<CharSequence>(this,
             android.R.layout.simple_spinner_item,this.getResources().getTextArray(R.array.unit_array));
// Specify the layout to use when the list of choices appears
    adapter_unit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
    spinner_unit.setAdapter(adapter_unit);
    }


    class CustomAdapter<T> extends ArrayAdapter<T> {
        public CustomAdapter(Context context, int textViewResourceId,
                             T[] objects) {
            super(context, textViewResourceId, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            if (view instanceof TextView) {
                ((TextView) view).setTextSize(18);
            }
            return view;
        }
    }
}