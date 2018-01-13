package xyz.arkarhein.burpple.events;

import java.util.List;

import xyz.arkarhein.burpple.data.vo.GuidesVO;

/**
 * Created by Arkar Hein on 1/13/2018.
 */

public class LoadedGuidesEvent {

    private List<GuidesVO> guidesList;

    public LoadedGuidesEvent(List<GuidesVO> guidesList) {
        this.guidesList = guidesList;
    }

    public List<GuidesVO> getGuidesList() {
        return guidesList;
    }
}
