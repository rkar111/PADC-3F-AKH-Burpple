package xyz.arkarhein.burpple.data.vo.data.model;

import xyz.arkarhein.burpple.network.GuidesDataAgent;
import xyz.arkarhein.burpple.network.GuidesOkHttpDataAgent;

/**
 * Created by Arkar Hein on 1/13/2018.
 */

public class GuidesModel {

    private static GuidesModel sObjInstance;

    private GuidesDataAgent mGuidesDataAgent;

    private GuidesModel() {

        mGuidesDataAgent = GuidesOkHttpDataAgent.getsObjInstance();

    }

    public static GuidesModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new GuidesModel();
        }
        return sObjInstance;
    }

    public void loadGuides() {
        mGuidesDataAgent.loadGuides();
    }
}
