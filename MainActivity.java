package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView workingsTV;
    TextView resultsTV;

    String workings = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTextViews();
}
    public void initTextViews() {
        workingsTV = (TextView)findViewById(R.id.workingsTextView);
        resultsTV = (TextView)findViewById(R.id.resultTextView);
    }

    public void setWorkink(String givenValue) {
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    public void cearOnclick(View view) {
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("");
    }

    public void bracketOnclick(View view) {
    }

    public void divisionOnclick(View view) {
        setWorkink("/");
    }

    public void unOnclick(View view) {
        setWorkink("1");
    }

    public void deuxOnclick(View view) {
        setWorkink("2");
    }

    public void troisOnclick(View view) {
        setWorkink("3");
    }

    public void plusOnclick(View view) {
        setWorkink("+");
    }

    public void quatreOnclick(View view) {
        setWorkink("4");
    }

    public void cinqOnclick(View view) {
        setWorkink("5");
    }

    public void sixOnclick(View view) {
        setWorkink("6");
    }

    public void soustractionOnclick(View view) {
        setWorkink("-");
    }

    public void septOnclick(View view) {
        setWorkink("7");
    }

    public void huitOnclick(View view) {
        setWorkink("8");
    }

    public void neufOnclick(View view) {
        setWorkink("9");
    }

    public void multiOnclick(View view) {
        setWorkink("*");
    }

    public void zeroOnclick(View view) {
        setWorkink("0");
    }

    public void egalOnclick(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try{
            result = (double)engine.eval(workings);
        }catch (ScriptException e){
            Toast.makeText(this,"invalid",Toast.LENGTH_SHORT).show();
        }
        if (result != null) {
            resultsTV.setText(String.valueOf(result.doubleValue()));
        }
    }
}