package com.example.comander_lifecounter.model;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.comander_lifecounter.R;

import java.util.Random;

public class Pop extends Activity implements View.OnClickListener {

    Button fourFaces;
    Button sixFaces;
    Button eightFaces;
    Button tenFaces;
    Button twelveFaces;
    Button twentyFaces;

    TextView title;
    TextView dice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pop_window);

        fourFaces  = (Button) findViewById(R.id.four_faces);
        sixFaces = (Button) findViewById(R.id.six_faces);
        eightFaces = (Button) findViewById(R.id.eight_faces);
        tenFaces = (Button) findViewById(R.id.ten_faces);
        twelveFaces = (Button) findViewById(R.id.twelve_faces);
        twentyFaces = (Button) findViewById(R.id.twenty_faces);

        dice = (TextView) findViewById(R.id.Dice);
        title = (TextView) findViewById(R.id.title);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        getWindow().setLayout((int) (dm.widthPixels * 0.7), (int) (dm.heightPixels * 0.55));

        fourFaces.setOnClickListener(this);
        sixFaces.setOnClickListener(this);
        eightFaces.setOnClickListener(this);
        tenFaces.setOnClickListener(this);
        twelveFaces.setOnClickListener(this);
        twentyFaces.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        title.setText("Result");
        dice.setVisibility(v.VISIBLE);
        fourFaces.setVisibility(v.INVISIBLE);
        sixFaces.setVisibility(v.INVISIBLE);
        eightFaces.setVisibility(v.INVISIBLE);
        tenFaces.setVisibility(v.INVISIBLE);
        twelveFaces.setVisibility(v.INVISIBLE);
        twentyFaces.setVisibility(v.INVISIBLE);


        Random rand = new Random();

        if (v.getId() == R.id.four_faces) {
            dice.setText(String.valueOf(rand.nextInt(4)+1));
        }else if (v.getId() == R.id.six_faces) {
            dice.setText(String.valueOf(rand.nextInt(6)+1));
        }else if (v.getId() == R.id.eight_faces) {
            dice.setText(String.valueOf(rand.nextInt(8)+1));
        }else  if (v.getId() == R.id.ten_faces) {
            dice.setText(String.valueOf(rand.nextInt(10)+1));
        }else  if (v.getId() == R.id.twelve_faces) {
            dice.setText(String.valueOf(rand.nextInt(12)+1));
        }else  {
            dice.setText(String.valueOf(rand.nextInt(20)+1));
        }
    }

}

