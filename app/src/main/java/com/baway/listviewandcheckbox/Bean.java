package com.baway.listviewandcheckbox;

/**
 * Created by peng on 2017/9/5.
 */

public class Bean {
    private boolean checked;
    private String str;

    public Bean(boolean checked, String str) {
        this.checked = checked;
        this.str = str;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
