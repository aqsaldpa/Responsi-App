package com.paymu.app;

public class HistoryModelClass {
    private int imageview;
    private String tv1, tv2, tv3,divider;

    public HistoryModelClass(int imageview, String tv1, String tv2, String tv3,String divider)
    {
        this.imageview = imageview;
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.tv3 = tv3;
        this.divider = divider;
    }

    public int getImageview() {
        return imageview;
    }

    public String getDivider() {
        return divider;
    }

    public String getTv1() {
        return tv1;
    }


    public String getTv2() {
        return tv2;
    }


    public String getTv3() {
        return tv3;
    }

}
