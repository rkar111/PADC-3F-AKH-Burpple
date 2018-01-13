package xyz.arkarhein.burpple.network.responses;

import java.util.List;

import xyz.arkarhein.burpple.data.vo.FeaturedVO;

/**
 * Created by Arkar Hein on 1/13/2018.
 */

public class GetFeaturedResponse {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    protected List<FeaturedVO> featured;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<FeaturedVO> getFeatured() {
        return featured;
    }
}
