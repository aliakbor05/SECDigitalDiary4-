package com.example.android.secdigitaldiary.teachersInfo;

import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("name")
    private String Name;

    @SerializedName("designation")
    private String Designation;

    public String getName() {
        return Name;
    }

    public String getDesignation() {
        return Designation;
    }
}
