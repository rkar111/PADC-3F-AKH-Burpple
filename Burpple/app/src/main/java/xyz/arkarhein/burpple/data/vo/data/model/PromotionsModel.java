package xyz.arkarhein.burpple.data.vo.data.model;

import xyz.arkarhein.burpple.data.vo.PromotionsVO;
import xyz.arkarhein.burpple.network.PromotionsDataAgent;
import xyz.arkarhein.burpple.network.PromotionsOkHttpDataAgent;

/**
 * Created by Arkar Hein on 1/13/2018.
 */

public class PromotionsModel {
    private static PromotionsModel sObjInstance;

    private PromotionsDataAgent mPromotionsDataAgent;

    private PromotionsModel() {

        mPromotionsDataAgent = PromotionsOkHttpDataAgent.getsObjInstance();

    }

    public static PromotionsModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new PromotionsModel();
        }
        return sObjInstance;
    }

    public void loadPromotions() {
        mPromotionsDataAgent.loadPromotions();
    }


}
