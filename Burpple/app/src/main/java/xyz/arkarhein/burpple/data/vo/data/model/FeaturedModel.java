package xyz.arkarhein.burpple.data.vo.data.model;

import xyz.arkarhein.burpple.network.FeaturedRetrofitDataAgent;

/**
 * Created by Arkar Hein on 1/13/2018.
 */

public class FeaturedModel {

    private static FeaturedModel sObjInstance;

    private FeaturedRetrofitDataAgent mFeaturedRetrofitDataAgent;


    private FeaturedModel() {

        mFeaturedRetrofitDataAgent = FeaturedRetrofitDataAgent.getsObjInstance();

    }

    public static FeaturedModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new FeaturedModel();
        }
        return sObjInstance;
    }

    public void loadFeatures() {
        mFeaturedRetrofitDataAgent.loadFeatured();
    }

}
