package xyz.arkarhein.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.viewholders.GuideItemViewHolder;

/**
 * Created by Arkar Hein on 1/5/2018.
 */

public class GuideItemsAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View guideItemView=inflater.inflate(R.layout.burpple_guide_items,parent,false);
        GuideItemViewHolder guideItemViewHolder=new GuideItemViewHolder(guideItemView);
        return guideItemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
