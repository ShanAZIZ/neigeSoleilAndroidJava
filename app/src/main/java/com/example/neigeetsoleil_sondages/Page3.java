package com.example.neigeetsoleil_sondages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class Page3 extends AppCompatActivity implements View.OnClickListener {

    private Button btTerminer;
    private String nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        this.btTerminer = (Button) findViewById(R.id.idFin);
        this.nom = this.getIntent().getStringExtra("nom").toString();
        this.btTerminer.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idFin){
            Intent unIntent = new Intent(this, Fin.class);
            unIntent.putExtra("nom", this.nom);
            this.startActivity(unIntent);
        }

    }
}