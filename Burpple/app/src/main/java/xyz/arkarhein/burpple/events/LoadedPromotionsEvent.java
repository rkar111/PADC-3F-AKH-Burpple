package xyz.arkarhein.burpple.events;

import java.util.List;

import xyz.arkarhein.burpple.data.vo.PromotionsVO;

/**
 * Created by Arkar Hein on 1/13/2018.
 */

public class LoadedPromotionsEvent {

    private List<PromotionsVO> promotionsList;

    public LoadedPromotionsEvent(List<PromotionsVO> promotionsList) {
        this.promotionsList = promotionsList;
    }

    public List<PromotionsVO> getPromotionsList() {
        return promotionsList;
    }
}
