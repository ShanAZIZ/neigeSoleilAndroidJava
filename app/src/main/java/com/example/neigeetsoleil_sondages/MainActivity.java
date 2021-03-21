package com.example.neigeetsoleil_sondages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btParticiper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btParticiper = (Button) findViewById(R.id.idParticiper);
        this.btParticiper.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idParticiper){
            Intent unIntent = new Intent(this, Inscription.class);
            this.startActivity(unIntent);
        }
    }
}