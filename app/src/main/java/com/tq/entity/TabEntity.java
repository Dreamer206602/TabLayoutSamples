package com.tq.entity;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by boobooL on 2016/3/29 0029
 * Created 邮箱 ：boobooMX@163.com
 */
public class TabEntity implements CustomTabEntity {

    private String title;
    private int selectedIcon;
    private int unSelectedIcon;

    public TabEntity(String title, int selectedIcon, int unSelectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
