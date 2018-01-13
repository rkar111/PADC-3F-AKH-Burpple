package xyz.arkarhein.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arkar Hein on 1/13/2018.
 */

public class GuidesVO {
    @SerializedName("burpple-guide-id")
    private String burppleGuideID;
    @SerializedName("burpple-guide-image")
    private String burppleGuideImage;
    @SerializedName("burpple-guide-title")
    private String burppleGuideTitle;
    @SerializedName("burpple-guide-desc")
    private String burppleGuideDesc;

    public String getBurppleGuideID() {
        return burppleGuideID;
    }

    public String getBurppleGuideImage() {
        return burppleGuideImage;
    }

    public String getBurppleGuideTitle() {
        return burppleGuideTitle;
    }

    public String getBurppleGuideDesc() {
        return burppleGuideDesc;
    }
}
