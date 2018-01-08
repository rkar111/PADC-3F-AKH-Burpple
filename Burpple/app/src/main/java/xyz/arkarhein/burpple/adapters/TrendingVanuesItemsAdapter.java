package xyz.arkarhein.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.viewholders.TrendingVanuesItemsViewHolder;

/**
 * Created by Arkar Hein on 1/8/2018.
 */

public class TrendingVanuesItemsAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View trendingVanuesItemView=inflater.inflate(R.layout.trending_vanues_items,parent,false);
        TrendingVanuesItemsViewHolder trendingVanuesItemsViewHolder=new TrendingVanuesItemsViewHolder(trendingVanuesItemView);
        return trendingVanuesItemsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
