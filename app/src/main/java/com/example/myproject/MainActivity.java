package com.example.myproject;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myproject.constant.Constant;
import com.example.myproject.fragment.HomeFragment;
import com.example.myproject.fragment.MessageFragment;
import com.example.myproject.fragment.RecommendFragment;
import com.example.myproject.fragment.RecordFragment;
import com.example.myproject.fragment.SetFragment;
import com.example.myproject.model.DataCache;
import com.example.myproject.utils.SwitchParams;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseOnBackActivity {

    @Bind(R.id.home_inco)
    ImageView homeInco;
    @Bind(R.id.home_text)
    TextView homeText;
    @Bind(R.id.main_home)
    LinearLayout mainHome;
    @Bind(R.id.recommed_inco)
    ImageView recommedInco;
    @Bind(R.id.recommed_text)
    TextView recommedText;
    @Bind(R.id.main_recommed)
    LinearLayout mainRecommed;
    @Bind(R.id.record_inco)
    ImageView recordInco;
    @Bind(R.id.record_text)
    TextView recordText;
    @Bind(R.id.main_record)
    LinearLayout mainRecord;
    @Bind(R.id.message_inco)
    ImageView messageInco;
    @Bind(R.id.message_text)
    TextView messageText;
    @Bind(R.id.main_message)
    LinearLayout mainMessage;
    @Bind(R.id.set_inco)
    ImageView setInco;
    @Bind(R.id.set_text)
    TextView setText;
    @Bind(R.id.main_set)
    LinearLayout mainSet;
    @Bind(R.id.main_butom)
    LinearLayout mainButom;
    @Bind(R.id.bottom_layout)
    LinearLayout bottomLayout;
    @Bind(R.id.content)
    FrameLayout content;

    private static final String activityTag="main";
    private int currentTab;
    public static int currentIndex = 0;
    public static Fragment[] fragments = new Fragment[Constant.fragmentNum];
    public static final int setThemeValue = 500;//设置主题
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addActivityTag(activityTag,this);
        ButterKnife.bind(this);
        initView();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
    private void initView(){
        homeFragment();
    }
    private void homeFragment(){
        HomeFragment homeFragment = new HomeFragment();
        fragments[Constant.homeStatue]=homeFragment;
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(!fragments[Constant.homeStatue].isAdded()){
            transaction.add(R.id.content, fragments[Constant.homeStatue]).commitAllowingStateLoss();
        }
        currentIndex = Constant.homeStatue;
        swtichTab(1);
    }
    @OnClick({R.id.main_home, R.id.main_recommed, R.id.main_record, R.id.main_message, R.id.main_set})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_home:
                switchHomeFragment();
                break;
            case R.id.main_recommed:
                switchRecommedFragment();
                break;
            case R.id.main_record:
                switchRecordFragment();
                break;
            case R.id.main_message:
                switchMessageFragment();
                break;
            case R.id.main_set:
                switchSetFragment();
                break;
        }
    }
    private void swtichTab(int tab){
        layoutTab(tab);
    }
    @TargetApi(Build.VERSION_CODES.M)
    private void layoutTab(int tab){
        if (tab == currentTab) {
            return;
        }
        currentTab = tab;

        mainTabBak(tab,DataCache.getInstance().getTheme());

        homeInco.setSelected(false);
        recommedInco.setSelected(false);
        recordInco.setSelected(false);
        messageInco.setSelected(false);
        setInco.setSelected(false);

        homeText.setSelected(false);
        recommedText.setSelected(false);
        recordText.setSelected(false);
        messageText.setSelected(false);
        setText.setSelected(false);
        switch (tab){
            case 1:
                homeInco.setSelected(true);
                homeText.setSelected(true);
                break;
            case 2:
                recommedInco.setSelected(true);
                recommedText.setSelected(true);
                break;
            case 3:
                recordInco.setSelected(true);
                recordText.setSelected(true);
                break;
            case 4:
                messageInco.setSelected(true);
                messageText.setSelected(true);
                break;
            case 5:
                setInco.setSelected(true);
                setText.setSelected(true);
                break;
        }
    }
    private void mainTabBak(int tab,int theme){
        mainHome.setBackgroundColor(Color.TRANSPARENT);
        mainRecommed.setBackgroundColor(Color.TRANSPARENT);
        mainRecord.setBackgroundColor(Color.TRANSPARENT);
        mainMessage.setBackgroundColor(Color.TRANSPARENT);
        mainSet.setBackgroundColor(Color.TRANSPARENT);
        LinearLayout mainLayout=mainHome;
        if(tab==1){
            mainLayout=mainHome;
        }else if(tab==2){
            mainLayout=mainRecommed;
        }else if(tab==3){
            mainLayout=mainRecord;
        }else if(tab==4){
            mainLayout=mainMessage;
        }else if(tab==5){
            mainLayout=mainSet;
        }
        if(theme==1){
            mainLayout.setBackgroundColor(getResources().getColor(R.color.tab_top1));
        }else if(theme==2){
            mainLayout.setBackgroundColor(getResources().getColor(R.color.tab_top2));
        }else if(theme==3){
            mainLayout.setBackgroundColor(getResources().getColor(R.color.tab_top3));
        }else if(theme==4){
            mainLayout.setBackgroundColor(getResources().getColor(R.color.tab_top4));
        }else if(theme==5){
            mainLayout.setBackgroundColor(getResources().getColor(R.color.tab_top5));
        }else if(theme==6){
            mainLayout.setBackgroundColor(getResources().getColor(R.color.tab_top6));
        }else if(theme==7){
            mainLayout.setBackgroundColor(getResources().getColor(R.color.tab_top7));
        }
    }
    private void switchHomeFragment(){
        if(DataCache.getInstance().getHomeStatue()==2){
            switchFragment(currentIndex, Constant.homeStatue, 1, true, SwitchParams.getInstance().getHomeParams());
        }else{
            switchFragment(currentIndex, Constant.homeStatue, 1, false, "");
        }
    }
    private void switchRecommedFragment(){
        if(DataCache.getInstance().getRecommedStatue()==2){
            switchFragment(currentIndex, Constant.recommentStatue, 2, true, SwitchParams.getInstance().getRecommedParams());
        }else{
            switchFragment(currentIndex, Constant.recommentStatue, 2, false, "");
        }
    }
    private void switchRecordFragment(){
        if(DataCache.getInstance().getRecordStatue()==2){
            switchFragment(currentIndex, Constant.recordStatue, 3, true, SwitchParams.getInstance().getRecordParams());
        }else{
            switchFragment(currentIndex, Constant.recordStatue, 3, false, "");
        }
    }
    private void switchMessageFragment(){
        if(DataCache.getInstance().getMessageStatue()==2){
            switchFragment(currentIndex, Constant.messageStatue, 4, true, SwitchParams.getInstance().getMessageParams());
        }else{
            switchFragment(currentIndex, Constant.messageStatue, 4, false, "");
        }
    }
    private void switchSetFragment(){
        if(DataCache.getInstance().getSetStatue()==2){
            switchFragment(currentIndex, Constant.setStatue, 5, true, SwitchParams.getInstance().getSetParams());
        }else{
            switchFragment(currentIndex, Constant.setStatue, 5, false, "");
        }
    }

    /**
     *
     * @param fromIndex
     * @param toIndex
     * @param tabIndex
     * @param flash
     * @param params
     * @param isNewFragment 是否需要new
     */
    private void switchToHomeFragment(int fromIndex,int toIndex,int tabIndex, boolean flash, Object params,int isNewFragment){
        HomeFragment fragment = (HomeFragment) fragments[toIndex];
        if (isNewFragment==1) {
            if (fragment != null && fragment.isAdded()) {
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment);
                fragment = null;
            }
        }
        if (fragment == null) {
            fragment = new HomeFragment();
            fragments[toIndex]=fragment;
        }
        fragment.setStatue(fromIndex,tabIndex,flash);
        if(flash){
            fragment.setParams(params);
        }
    }
    private void switchToRecommendFragment(int fromIndex,int toIndex,int tabIndex, boolean flash, Object params,int isNewFragment){
        RecommendFragment fragment = (RecommendFragment) fragments[toIndex];
        if (isNewFragment==1) {
            if (fragment != null && fragment.isAdded()) {
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment);
                fragment = null;
            }
        }
        if (fragment == null) {
            fragment = new RecommendFragment();
            fragments[toIndex]=fragment;
        }
        fragment.setStatue(fromIndex,tabIndex,flash);
        if(flash){
            fragment.setParams(params);
        }
    }
    private void switchToRecordFragment(int fromIndex,int toIndex,int tabIndex, boolean flash, Object params,int isNewFragment){
        RecordFragment fragment = (RecordFragment) fragments[toIndex];
        if (isNewFragment==1) {
            if (fragment != null && fragment.isAdded()) {
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment);
                fragment = null;
            }
        }
        if (fragment == null) {
            fragment = new RecordFragment();
            fragments[toIndex]=fragment;
        }
        fragment.setStatue(fromIndex,tabIndex,flash);
        if(flash){
            fragment.setParams(params);
        }
    }
    private void switchToMessageFragment(int fromIndex,int toIndex,int tabIndex, boolean flash, Object params,int isNewFragment){
        MessageFragment fragment = (MessageFragment) fragments[toIndex];
        if (isNewFragment==1) {
            if (fragment != null && fragment.isAdded()) {
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment);
                fragment = null;
            }
        }
        if (fragment == null) {
            fragment = new MessageFragment();
            fragments[toIndex]=fragment;
        }
        fragment.setStatue(fromIndex,tabIndex,flash);
        if(flash){
            fragment.setParams(params);
        }
    }
    private void switchToSetFragment(int fromIndex,int toIndex,int tabIndex, boolean flash, Object params,int isNewFragment){
        SetFragment fragment = (SetFragment) fragments[toIndex];
        if (isNewFragment==1) {
            if (fragment != null && fragment.isAdded()) {
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment);
                fragment = null;
            }
        }
        if (fragment == null) {
            fragment = new SetFragment();
            fragments[toIndex]=fragment;
        }
        fragment.setStatue(fromIndex,tabIndex,flash);
        if(flash){
            fragment.setParams(params);
        }
    }
    /**
     * @param fromIndex fragmen来源于显示的下标
     * @param toIndex   fragment要显示的下标
     * @param tabIndex  tab要显示的下标
     * @param flash     界面是否刷新
     * @param params    刷新数据需要的参数
     */
    public void switchFragment(int fromIndex, int toIndex, int tabIndex, boolean flash, Object params) {
        swtichTab(tabIndex);
        switch (toIndex) {
            case Constant.homeStatue:
                switchToHomeFragment(fromIndex,toIndex,tabIndex,flash,params,DataCache.getInstance().getHomeStatue());
                break;
            case Constant.recommentStatue:
                switchToRecommendFragment(fromIndex,toIndex,tabIndex,flash,params,DataCache.getInstance().getRecommedStatue());
                break;
            case Constant.recordStatue:
                switchToRecordFragment(fromIndex,toIndex,tabIndex,flash,params,DataCache.getInstance().getRecordStatue());
                break;
            case Constant.messageStatue:
                switchToMessageFragment(fromIndex,toIndex,tabIndex,flash,params,DataCache.getInstance().getMessageStatue());
                break;
            case Constant.setStatue:
                switchToSetFragment(fromIndex,toIndex,tabIndex,flash,params,DataCache.getInstance().getSetStatue());
                break;
        }
        showFragment(fragments[toIndex], fragments[currentIndex]);
        currentIndex = toIndex;
    }

    private void showFragment(Fragment toFragment, Fragment fromFragment) {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!toFragment.isAdded()) {
            transaction.hide(fromFragment).add(R.id.content, toFragment).commitAllowingStateLoss();
        } else {
            transaction.hide(fromFragment).show(toFragment).commitAllowingStateLoss();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == setThemeValue) {
//            switchSetFragment();
            SetFragment setFragment=(SetFragment)fragments[Constant.setStatue];
            setFragment.flashTheme();
            swtichTab(5);
        }
    }
}
