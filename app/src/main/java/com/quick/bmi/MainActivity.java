package com.quick.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private View result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        String hello = getString(R.string.hello)
    }

    private void findViews() {
        edWeight = findViewById(R.id.ed_weight);
        edHeight = findViewById(R.id.ed_height);
        result = findViewById(R.id.result);
        Button help = findViewById(R.id.help);
        help.setOnClickListener((view) -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.help)
                    .setMessage(R.string.bmi_info)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        });
    }

    public void bmi(View view){
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight / (height*height);
        Log.d("MainActivity", "BMI: " + bmi);
//        Intent intent = new Intent(this, ResultActivity.class);
//        intent.putExtra("BMI", bmi);
//        startActivity(intent);
        Toast.makeText(this, getString(R.string.your_bmi_is) + bmi, Toast.LENGTH_LONG).show();
        result.setText(getString(R.string.your_bmi_is) + bmi);
        new AlertDialog.Builder(this)
                .setTitle("BMI")
                .setMessage(getString(R.string.your_bmi_is) + bmi)
                .setPositiveButton(getString(R.string.ok, (dialogInterface, i) -> {
                        edWeight.setText("");
                        edHeight.setText("");
                })
                .show();
    }
}
