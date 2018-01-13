package xyz.arkarhein.burpple.data.vo.data.model;

import xyz.arkarhein.burpple.data.vo.PromotionsVO;

/**
 * Created by Arkar Hein on 1/13/2018.
 */

public class PromotionsModel {
    private static PromotionsModel sObjInstance;

    private PromotionsModel(){

    }

    public static PromotionsModel getsObjInstance(){
        if (sObjInstance==null){
            sObjInstance=new PromotionsModel();
        }
        return sObjInstance;
    }

}
