package xyz.arkarhein.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.viewholders.NewsAndTrendingItemViewHolder;

/**
 * Created by Arkar Hein on 1/5/2018.
 */

public class NewsAndTrendingItemAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View newsAndTrendingView = inflater.inflate(R.layout.new_and_trending_items, parent, false);
        NewsAndTrendingItemViewHolder newsAndTrendingItemViewHolder = new NewsAndTrendingItemViewHolder(newsAndTrendingView);
        return newsAndTrendingItemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
