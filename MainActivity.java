package com.example.dropdown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner MySpinner;
    Fragment MyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySpinner =  findViewById(R.id.MySpinnerID);

        ArrayAdapter<CharSequence> MyAdapter = ArrayAdapter.createFromResource(this,R.array.CountryName, android.R.layout.simple_spinner_item);
        MyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MySpinner.setAdapter(MyAdapter);
        MySpinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String Text = parent.getItemAtPosition(position).toString();
        if (Text.equals("Bangladesh")){
            MyFragment = new Bangladesh();
        }
        else if(Text.equals("India")){
            MyFragment = new India();
        }
        else if(Text.equals("Nepal")){
            MyFragment = new Nepal();

        }else{
            MyFragment = new BlankFragment();

        }
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.MainFragmentID,MyFragment);
        ft.commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        MyFragment = new BlankFragment();

    }

    public void AboutMeFunction(View view) {
        Intent MyIntent=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(MyIntent);
    }
}
