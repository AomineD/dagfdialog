package com.dagf.dagfdialog;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dagf.vicerius.wetdialog.WetDialog;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WetDialog wetDialog = new WetDialog(getSupportFragmentManager(), R.id.frm);

        wetDialog.setHeigh(35);

        wetDialog.setTexts("Notificacion importante", "Si quieres acceder a toda nuestra multimedia inicia sesión ahora, y disfruta de las mejores pelis y bla bla bla bla si mucho bla bla, demasiado bla bla para este parrafo a ver si dejo de escribir babosadas bro y programo en serio, no pero de", "Ir");

        wetDialog.settColor(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.ajj));

        wetDialog.setSpeedAnim(900);

        wetDialog.Show(new WetDialog.wetListener() {
            @Override
            public void onOk() {
                finish();
            }
        });
    }
}
