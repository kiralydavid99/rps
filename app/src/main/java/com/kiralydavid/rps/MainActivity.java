package com.kiralydavid.rps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn_ko, btn_papir, btn_ollo;
    private ImageView felhasznaloKep, gepKep;
    private TextView eredmeny, textViewCustom;
    private int computerTipp;
    private int emberPont, computerPont;
    private Random random;
    private Toast customToast;
    private AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ujJatek();
        btn_ko.setOnClickListener(view -> {
            computerTipp = random.nextInt(3);

            if(computerTipp == 1){
                computerPont++;
                gepKep.setImageResource(R.drawable.paper);
                textViewCustom.setText("A gép nyert!");
                customToast.show();
            } else if(computerTipp == 2){
                emberPont++;
                gepKep.setImageResource(R.drawable.scissors);
                textViewCustom.setText("Te nyertél!");
                customToast.show();
            } else {
                gepKep.setImageResource(R.drawable.rock);
                textViewCustom.setText("Döntetlen!");
                customToast.show();
            }
            eredmeny.setText("Eredmeny: Ember: "+emberPont+" Computer: "+computerPont);
            felhasznaloKep.setImageResource(R.drawable.rock);
            KiNyert();

        });
        btn_papir.setOnClickListener(view -> {
            computerTipp = random.nextInt(3);

            if(computerTipp == 2){
                computerPont++;
                gepKep.setImageResource(R.drawable.scissors);
                textViewCustom.setText("A gép nyert!");
                customToast.show();
            } else if(computerTipp == 0){
                emberPont++;
                gepKep.setImageResource(R.drawable.rock);
                textViewCustom.setText("Te nyertél!!");
                customToast.show();
            } else {
                gepKep.setImageResource(R.drawable.paper);
                textViewCustom.setText("Döntetlen!");
                customToast.show();
            }
            eredmeny.setText("Eredmeny: Ember: "+emberPont+" Computer: "+computerPont);
            felhasznaloKep.setImageResource(R.drawable.paper);
            KiNyert();
        });
        btn_ollo.setOnClickListener(view -> {
            computerTipp = random.nextInt(3);

            if(computerTipp == 0){
                computerPont++;
                gepKep.setImageResource(R.drawable.rock);
                textViewCustom.setText("A gép nyert!");
                customToast.show();
            } else if(computerTipp == 1){
                emberPont++;
                gepKep.setImageResource(R.drawable.paper);
                textViewCustom.setText("Te nyertél!");
                customToast.show();
            } else {
                gepKep.setImageResource(R.drawable.scissors);
                textViewCustom.setText("Döntetlen!");
                customToast.show();
            }
            eredmeny.setText("Eredmeny: Ember: "+emberPont+" Computer: "+computerPont);
            felhasznaloKep.setImageResource(R.drawable.scissors);
            KiNyert();
        });
    }

    private void ujJatek() {
        emberPont = 0;
        computerPont = 0;
        eredmeny.setText("Eredmeny: Ember: "+emberPont+" Computer: "+computerPont);
    }
    private void KiNyert(){
        if(emberPont == 3){
            alertBuilder.setTitle("Győzelem!");
            alertBuilder.create();
            alertBuilder.show();
        } else if (computerPont == 3){
            alertBuilder.setTitle("Vereség!");
            alertBuilder.create();
            alertBuilder.show();
        }
    }
    private void init(){
        btn_ko = findViewById(R.id.btn_ko);
        btn_ollo = findViewById(R.id.btn_ollo);
        btn_papir = findViewById(R.id.btn_papir);
        gepKep = findViewById(R.id.gepKep);
        computerPont = 0;
        emberPont = 0;
        eredmeny = findViewById(R.id.eredmeny);
        felhasznaloKep = findViewById(R.id.felhasznaloKep);
        random = new Random();
        CreateCustomToast();
        alertBuilder = new AlertDialog.Builder(this);
        CreateAlertDialog();
    }
    private void CreateCustomToast(){

    }
    private void CreateAlertDialog(){
        alertBuilder.setMessage("Szeretnél új játékot?");
        alertBuilder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {finish();}
        });
        alertBuilder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ujJatek();
                closeContextMenu();
            }
        });
        alertBuilder.setCancelable(false);
    }
}