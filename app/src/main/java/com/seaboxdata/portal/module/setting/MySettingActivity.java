package com.seaboxdata.portal.module.setting;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.seaboxdata.portal.R;
import com.seaboxdata.portal.common.CommonActivity;
import com.seaboxdata.portal.utils.StatusBarUtil;
import com.seaboxdata.portal.utils.SystemBarTintManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MySettingActivity extends CommonActivity {


    private Unbinder unbinder;

    @BindView(R.id.info_title_common)
    TextView infoTitleCommon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_setting);
        setToolBar();
        unbinder = ButterKnife.bind(this);
        infoTitleCommon.setText("设置");
    }

    private void setToolBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintColor(Color.TRANSPARENT);
            tintManager.setStatusBarTintEnabled(true);

            LinearLayout linear_bar = (LinearLayout) findViewById(R.id.ll_bar);
            linear_bar.setVisibility(View.VISIBLE);
            linear_bar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            linear_bar.getLayoutParams().height = getStatusBarHeight();

            if (StatusBarUtil.StatusBarLightMode(this) == 0) {
//                linear_bar.setBackgroundColor(mContext.getResources().getColor(R.color.black_opacity80));
            }
        }
    }


    @OnClick(R.id.infomation_back)
    public void backActivity() {
        finish();
    }

    @OnClick(R.id.setting_count_safe)
    public void countSafeSetting() {
        startActivity(new Intent(this,AcountSetting.class));
    }

    @OnClick(R.id.setting_suggest)
    public void suggestBack() {
        startActivity(new Intent(this,SuggestHandleActivity.class));
    }

    @OnClick(R.id.setting_version)
    public void checkVersion() {

    }


    public void logOutApp(View view) {

    }

}
