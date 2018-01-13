package xyz.arkarhein.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.data.vo.GuidesVO;
import xyz.arkarhein.burpple.viewholders.GuideItemViewHolder;

/**
 * Created by Arkar Hein on 1/5/2018.
 */

public class GuideItemsAdapter extends RecyclerView.Adapter<GuideItemViewHolder> {

    private List<GuidesVO> mGuidesList;

    public GuideItemsAdapter() {
        mGuidesList = new ArrayList<>();
    }

    @Override
    public GuideItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View guideItemView = inflater.inflate(R.layout.burpple_guide_items, parent, false);
        GuideItemViewHolder guideItemViewHolder = new GuideItemViewHolder(guideItemView);
        return guideItemViewHolder;
    }

    @Override
    public void onBindViewHolder(GuideItemViewHolder holder, int position) {
        holder.setGuides(mGuidesList.get(position));
    }

    @Override
    public int getItemCount() {
        return mGuidesList.size();
    }

    public void setGuides(List<GuidesVO> guidesList) {
        mGuidesList=guidesList;
        notifyDataSetChanged();
    }
}
