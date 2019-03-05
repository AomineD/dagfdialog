package com.dagf.vicerius.wetdialog;


import android.os.Bundle;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.dagf.vicerius.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WetFragment extends Fragment {

    public static final String key_heigh = "kaskdaksdkasd";
    public WetDialog.wetListener flis;
    private int heigh;
    private CardView background;
    public static final String key_backcolor = "asdasd";
    public static final String key_textcolor = "jasjdajsdas";
    public static final String key_title_wet = "ajsdajsdja";
    public static final String key_desc_wt = "adjasjd";
    public static final String key_action_wet = "ASJDASJDJAJAJ";
    public static final String key_speed = "JAJAJAJSADLAD";
    public static final String key_anim = "JAJDAJAJASDSLF;";

    private long speed;
    private String descriptionw;
    private String title_wet;
    private String actionwet;

    private int colorBack;
    private int colortext;
    private String ttile_, decs, act;

    // ================== VIEWS ========================= //
    private TextView title, dec, action;
    private CardView cardView;
private LottieAnimationView animationView;

private String snim;


    public WetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            Bundle ff = getArguments();

            if(ff.getInt(key_heigh, 0) != -1){
                heigh = ff.getInt(key_heigh, 0);
            }

            colorBack = ff.getInt(key_backcolor);

            colortext = ff.getInt(key_textcolor);

            speed = ff.getLong(key_speed);
            act = ff.getString(key_action_wet);
            ttile_ = ff.getString(key_title_wet);
            decs = ff.getString(key_desc_wt);
            snim = ff.getString(key_anim);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View lay = inflater.inflate(R.layout.fragment_wet, container, false);
        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.openanim);
        if(speed != 0 && speed > 150){
            anim.setDuration(speed);
        }

        Animation ad = AnimationUtils.loadAnimation(getContext(), R.anim.gobutton);
        lay.startAnimation(anim);
        cardView = lay.findViewById(R.id.background);
        action = lay.findViewById(R.id.clickon);
        action.startAnimation(ad);
        title = lay.findViewById(R.id.title_wet);
        dec = lay.findViewById(R.id.descr_wet);
        if(snim != null && !snim.isEmpty()) {
            animationView = lay.findViewById(R.id.anim_mainx);
            animationView.pauseAnimation();
            animationView.setAnimation(snim);
            animationView.loop(true);
            animationView.playAnimation();
        }

      //  Log.e("MAIN", "onCreateView: "+heigh);



        if(heigh != -1 && heigh != 0){
            heigh = heigh * 10;
            LinearLayout.LayoutParams f = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heigh);
            lay.setLayoutParams(f);
        }

        cardView.setCardBackgroundColor(colorBack);
        title.setTextColor(colortext);
        action.setTextColor(colortext);
        dec.setTextColor(colortext);
        title.setText(ttile_);
dec.setText(decs);
action.setText(act);


        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flis.onOk();
            }
        });

        return lay;
    }

}
