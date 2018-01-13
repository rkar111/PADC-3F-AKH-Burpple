package xyz.arkarhein.burpple.network.responses;

import java.util.List;

import xyz.arkarhein.burpple.data.vo.PromotionsVO;

/**
 * Created by Arkar Hein on 1/13/2018.
 */

public class GetPromotionsResponses {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<PromotionsVO> promotions;

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

    public List<PromotionsVO> getPromotions() {
        return promotions;
    }
}
