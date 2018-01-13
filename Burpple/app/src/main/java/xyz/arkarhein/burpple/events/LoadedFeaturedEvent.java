package xyz.arkarhein.burpple.events;

import java.util.List;

import xyz.arkarhein.burpple.data.vo.FeaturedVO;
import xyz.arkarhein.burpple.data.vo.GuidesVO;

/**
 * Created by Arkar Hein on 1/13/2018.
 */

public class LoadedFeaturedEvent {
    private List<FeaturedVO> featuredList;

    public LoadedFeaturedEvent(List<FeaturedVO> featuredList) {
        this.featuredList = featuredList;
    }

    public List<FeaturedVO> getFeaturedList() {
        return featuredList;
    }
}
