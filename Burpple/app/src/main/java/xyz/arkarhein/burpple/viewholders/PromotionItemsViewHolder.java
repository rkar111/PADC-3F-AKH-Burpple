package xyz.arkarhein.burpple.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.data.vo.PromotionsVO;

/**
 * Created by Arkar Hein on 1/4/2018.
 */

public class PromotionItemsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_promotions_detail)
    TextView tvPromotionsDetail;

    @BindView(R.id.tv_promotions_period)
    TextView tvPromotionsPeriod;

    @BindView(R.id.iv_promotion_item)
    ImageView ivPromotionItem;

    @BindView(R.id.tv_shop_name)
    TextView tvShopName;

    @BindView(R.id.tv_shop_area)
    TextView tvShopArea;

    public PromotionItemsViewHolder(View itemView) {

        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setPromotions(PromotionsVO promotions) {
        tvPromotionsDetail.setText(promotions.getBurpplePromotionTitle());
        tvPromotionsPeriod.setText(promotions.getBurpplePromotionUntil());
        tvShopName.setText(promotions.getBurpplePromotionShop().getBurppleShopName());
        tvShopArea.setText(promotions.getBurpplePromotionShop().getBurppleShopArea());

        Glide.with(ivPromotionItem)
                .load(promotions.getBurpplePromotionImage())
                .into(ivPromotionItem);

    }
}
