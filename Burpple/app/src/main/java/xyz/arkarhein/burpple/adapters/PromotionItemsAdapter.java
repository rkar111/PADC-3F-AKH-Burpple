package xyz.arkarhein.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.viewholders.PromotionItemsViewHolder;

/**
 * Created by Arkar Hein on 1/4/2018.
 */

public class PromotionItemsAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View promotionItemView = inflater.inflate(R.layout.promotions_items,parent,false);
        PromotionItemsViewHolder promotionItemsViewHolder=new PromotionItemsViewHolder(promotionItemView);
        return promotionItemsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
