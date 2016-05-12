package com.example.myproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myproject.MainActivity;
import com.example.myproject.R;
import com.example.myproject.ThemeActivity;
import com.example.myproject.model.DataCache;
import com.example.myproject.utils.MThemeUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangbs on 16/5/12.
 */
public class SetFragment extends BaseFragment {
    @Bind(R.id.theme_realy)
    RelativeLayout themeRealy;
    @Bind(R.id.title_text)
    TextView titleText;
    private MainActivity context;
    private Object params;
    private int fromIndex;
    private int tabIndex;
    private boolean flash;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        context = (MainActivity) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MThemeUtil.changeTheme(getActivity(), DataCache.getInstance().getTheme());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.set_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    public void setStatue(int fromIndex, int tabIndex, boolean flash) {
        this.fromIndex = fromIndex;
        this.tabIndex = tabIndex;
        this.flash = flash;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (!hidden) {
            if (flash) {
                flash();
            }
        }
        super.onHiddenChanged(hidden);
    }

    public void flash() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.theme_realy)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.theme_realy:
                themeActivity();
                break;
        }
    }

    private void themeActivity() {
        Intent intent = new Intent(context, ThemeActivity.class);
        startActivityForResult(intent, MainActivity.setThemeValue);
    }

    public void flashTheme() {
    }
}
