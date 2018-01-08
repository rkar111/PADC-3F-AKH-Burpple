package xyz.arkarhein.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.viewholders.NewlyOpenedItemsViewHolder;

/**
 * Created by Arkar Hein on 1/8/2018.
 */

public class NewlyOpenedItemsAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View newlyOpenedItemsView = inflater.inflate(R.layout.newly_opened_items, parent, false);
        NewlyOpenedItemsViewHolder newlyOpenedItemsViewHolder = new NewlyOpenedItemsViewHolder(newlyOpenedItemsView);
        return newlyOpenedItemsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
