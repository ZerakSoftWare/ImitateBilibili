package com.wings.zilizili.fragment;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wings.zilizili.GlobalConstant;
import com.wings.zilizili.R;
import com.wings.zilizili.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftMenuFragment extends Fragment implements View.OnClickListener {
    private NavigationView mNavigationView;
    private View mContentView;
    private MainActivity mActivity;
    private ImageView iv_theme;


    public LeftMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mContentView = inflater.inflate(R.layout.navigation_layout, container, false);
        init();
        return mContentView;
    }

    private void init() {
        mNavigationView = $(R.id.nv_main);
        iv_theme = $(R.id.iv_night);
        iv_theme.setOnClickListener(this);
        mActivity = (MainActivity) getActivity();
        mNavigationView.setCheckedItem(R.id.nav_home);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.
                OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                switch (itemId) {
                    case R.id.nav_home:
                        mActivity.changeFragment(GlobalConstant.HOMEFRAGMENT);
                        break;
                    case R.id.nav_histories:
                        mActivity.changeFragment(GlobalConstant.HISTORYFRAGMENT);
                        break;
                    case R.id.nav_favorites:
                        mActivity.changeFragment(2);
                        break;
                    case R.id.nav_following:
                        mActivity.changeFragment(3);
                        break;
                    case R.id.nav_pay:
                        mActivity.changeFragment(4);
                        break;
                    case R.id.nav_theme:
                        mActivity.changeFragment(5);
                        break;
                    //android:checkable="false"
                    //可以响应点击事件,但是不会被选中
                    case R.id.nav_offline_manager:
                        mActivity.changeFragment(GlobalConstant.HOMEFRAGMENT);
                        break;

                }
                mActivity.closeLeftMenu();
                return false;
            }

        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private <T extends View> T $(int resId) {
        return (T) mContentView.findViewById(resId);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.iv_night:
                mActivity.changeTheme();
        }
    }
}
