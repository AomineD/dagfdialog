package com.dagf.vicerius.wetdialog;


import android.os.Bundle;

import android.support.v4.app.FragmentManager;

public class WetDialog {

    public interface wetListener{
        void onOk();
    }

    private FragmentManager fragmentManager;
    private int containerId;
    private int difheigh = -1;
    private WetFragment fragment;
    private Bundle bundles;

    public WetDialog(FragmentManager receuve, int Containerd){
    this.fragmentManager = receuve;
    bundles = new Bundle();
    this.containerId = Containerd;
        fragment = new WetFragment();
}
    /**
     Si es necesario, elige una altura diferente a la calculada automaticamente
     **/
public void setHeigh(int heigh){
    this.difheigh = heigh;
}

    /**
     Configura los colores de la notificacion, titulo y descripcion, y color de fondo
     **/
public void settColor(int Colorback, int ColorText){

 bundles.putInt(WetFragment.key_backcolor, Colorback);
 bundles.putInt(WetFragment.key_textcolor, ColorText);
    bundles.putInt(WetFragment.key_heigh, difheigh);

}

/**
 Seleccionar una animacion diferente
  **/
public void setAnim(String animjson){
    bundles.putString(WetFragment.key_anim, animjson);
}

/**
 Configura los textos de la notificacion, titulo, descripcion y boton de accion
  **/
public void setTexts(String title, String desc, String okbutton){
    bundles.putString(WetFragment.key_title_wet, title);
    bundles.putString(WetFragment.key_desc_wt, desc);
    bundles.putString(WetFragment.key_action_wet, okbutton);
}

/**
 Elige la velocidad de la animacion, debe ser mayor de 150
 Ejemplo: setSpeedAnim(200);
  **/
public void setSpeedAnim(long speed){
        bundles.putLong(WetFragment.key_speed, speed);
}

public void setCardRadius(float radius){
    bundles.putFloat(WetFragment.key_margin, radius);
}

public void setCardColor(int colour){
    bundles.putInt(WetFragment.key_color_card, colour);
}

public void Show(wetListener ok){
        fragment.flis = ok;
    fragment.setArguments(bundles);
    fragmentManager.beginTransaction().replace(containerId, fragment).commitAllowingStateLoss();
}


public void visibleAction(boolean iff){
    bundles.putBoolean(WetFragment.key_visi, iff);
}

}
