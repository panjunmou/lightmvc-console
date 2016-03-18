package com.pjm.lightmvc.contants;

/**
 * Created by PanJM on 2016/3/16.
 */
public enum UserStatus {

    ACTIVITY(1, "启用"),

    UNACTIVITI(-1, "停用");

    private Integer value;

    private String label;

    UserStatus(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static String getLabel(int value) {
        if (ACTIVITY.getValue().intValue() == value) {
            return ACTIVITY.getLabel();
        } else if (UNACTIVITI.getValue().intValue() == value) {
            return UNACTIVITI.getLabel();
        }
        return "";
    }
}
