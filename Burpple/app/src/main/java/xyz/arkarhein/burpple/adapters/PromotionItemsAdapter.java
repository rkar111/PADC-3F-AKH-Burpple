package xyz.arkarhein.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.data.vo.PromotionsVO;
import xyz.arkarhein.burpple.viewholders.PromotionItemsViewHolder;

/**
 * Created by Arkar Hein on 1/4/2018.
 */

public class PromotionItemsAdapter extends RecyclerView.Adapter<PromotionItemsViewHolder> {

    private List<PromotionsVO> mPromotionsList;

    public PromotionItemsAdapter() {
        mPromotionsList = new ArrayList<>();
    }

    @Override
    public PromotionItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View promotionItemView = inflater.inflate(R.layout.promotions_items, parent, false);
        PromotionItemsViewHolder promotionItemsViewHolder = new PromotionItemsViewHolder(promotionItemView);
        return promotionItemsViewHolder;
    }

    @Override
    public void onBindViewHolder(PromotionItemsViewHolder holder, int position) {
        holder.setPromotions(mPromotionsList.get(position));
    }


    @Override
    public int getItemCount() {
        return mPromotionsList.size();
    }

    public void setPromotions(List<PromotionsVO> promotionsList) {
        mPromotionsList = promotionsList;
        notifyDataSetChanged();
    }
}
