package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myproject.model.DataCache;

/**
 * Created by wangbs on 16/5/12.
 */
public class ThemeActivity extends BaseActivity{
    private static final String activityTag="theme_set";
    private TextView set_cancel;
    private RelativeLayout rl_title;
    private RelativeLayout theme1_lineary,theme2_lineary,theme3_lineary,theme4_lineary
            ,theme5_lineary,theme6_lineary,theme7_lineary;
    private ImageView theme1_cicle,theme2_cicle,theme3_cicle,theme4_cicle,theme5_cicle,theme6_cicle,theme7_cicle;
    private int intThemeString;//这个不跟着变
    private int oldThemeString;//这个跟随变
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        addActivityTag(activityTag,this);
        init();
        findView();
        getData();
        initView();
    }
    private void finishActivity(){
        finishTagActivity(activityTag,this);
    }
    @Override
    public void onBackPressed() {
        back();
    }
    private void back(){
        if(intThemeString==oldThemeString){
            //没变
            finishActivity();
        }else{
            DataCache.getInstance().setHomeStatue(1);
            DataCache.getInstance().setRecommedStatue(1);
            DataCache.getInstance().setMessageStatue(1);
            DataCache.getInstance().setRecordStatue(1);
            DataCache.getInstance().setSetStatue(1);
            DataCache.getInstance().setTheme(oldThemeString);
            Intent intent=getIntent();
            setResult(RESULT_OK,intent);
            finishActivity();
        }
    }
    private void init() {
    }
    private void findView(){
        set_cancel = (TextView) findViewById(R.id.set_cancel);
        rl_title = (RelativeLayout) findViewById(R.id.rl_title);
        theme1_lineary = (RelativeLayout) findViewById(R.id.theme1_lineary);
        theme2_lineary = (RelativeLayout) findViewById(R.id.theme2_lineary);
        theme3_lineary = (RelativeLayout) findViewById(R.id.theme3_lineary);
        theme4_lineary = (RelativeLayout) findViewById(R.id.theme4_lineary);
        theme5_lineary = (RelativeLayout) findViewById(R.id.theme5_lineary);
        theme6_lineary = (RelativeLayout) findViewById(R.id.theme6_lineary);
        theme7_lineary = (RelativeLayout) findViewById(R.id.theme7_lineary);
        theme1_cicle = (ImageView) findViewById(R.id.theme1_cicle);
        theme2_cicle = (ImageView) findViewById(R.id.theme2_cicle);
        theme3_cicle = (ImageView) findViewById(R.id.theme3_cicle);
        theme4_cicle = (ImageView) findViewById(R.id.theme4_cicle);
        theme5_cicle = (ImageView) findViewById(R.id.theme5_cicle);
        theme6_cicle = (ImageView) findViewById(R.id.theme6_cicle);
        theme7_cicle = (ImageView) findViewById(R.id.theme7_cicle);
        set_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                back();
            }
        });
        theme1_lineary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                updataTheme(1);
            }
        });
        theme2_lineary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                updataTheme(2);
            }
        });
        theme3_lineary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                updataTheme(3);
            }
        });
        theme4_lineary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                updataTheme(4);
            }
        });
        theme5_lineary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                updataTheme(5);
            }
        });
        theme6_lineary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                updataTheme(6);
            }
        });
        theme7_lineary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                updataTheme(7);
            }
        });
    }
    private void updataTheme(final int updataThemeValue){
        if(oldThemeString!=updataThemeValue){
            updataThemeSuccess(updataThemeValue);
        }
    }
    private void updataThemeSuccess(int updataThemeValue){
        oldThemeString=updataThemeValue;
        themeCicle();
        themeBak();
    }
    private void getData() {
        getThemes();
    }
    private void initView() {
        themeCicle();
        themeBak();
    }
    private void themeCicle(){
        theme1_cicle.setVisibility(View.INVISIBLE);
        theme2_cicle.setVisibility(View.INVISIBLE);
        theme3_cicle.setVisibility(View.INVISIBLE);
        theme4_cicle.setVisibility(View.INVISIBLE);
        theme5_cicle.setVisibility(View.INVISIBLE);
        theme6_cicle.setVisibility(View.INVISIBLE);
        theme7_cicle.setVisibility(View.INVISIBLE);
        if(oldThemeString==1){
            theme1_cicle.setVisibility(View.VISIBLE);
        }else if(oldThemeString==2){
            theme2_cicle.setVisibility(View.VISIBLE);
        }else if(oldThemeString==3){
            theme3_cicle.setVisibility(View.VISIBLE);
        }else if(oldThemeString==4){
            theme4_cicle.setVisibility(View.VISIBLE);
        }else if(oldThemeString==5){
            theme5_cicle.setVisibility(View.VISIBLE);
        }else if(oldThemeString==6){
            theme6_cicle.setVisibility(View.VISIBLE);
        }else if(oldThemeString==7){
            theme7_cicle.setVisibility(View.VISIBLE);
        }
    }
    private void themeBak(){
        if(oldThemeString==1){
            rl_title.setBackgroundColor(getResources().getColor(R.color.tab_top1));
        }else if(oldThemeString==2){
            rl_title.setBackgroundColor(getResources().getColor(R.color.tab_top2));
        }else if(oldThemeString==3){
            rl_title.setBackgroundColor(getResources().getColor(R.color.tab_top3));
        }else if(oldThemeString==4){
            rl_title.setBackgroundColor(getResources().getColor(R.color.tab_top4));
        }else if(oldThemeString==5){
            rl_title.setBackgroundColor(getResources().getColor(R.color.tab_top5));
        }else if(oldThemeString==6){
            rl_title.setBackgroundColor(getResources().getColor(R.color.tab_top6));
        }else if(oldThemeString==7){
            rl_title.setBackgroundColor(getResources().getColor(R.color.tab_top7));
        }
    }
    private void getThemes() {
        intThemeString=DataCache.getInstance().getTheme();
        oldThemeString=DataCache.getInstance().getTheme();
    }
}
