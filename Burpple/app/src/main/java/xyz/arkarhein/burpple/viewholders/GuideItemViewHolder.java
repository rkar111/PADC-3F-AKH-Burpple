package xyz.arkarhein.burpple.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.data.vo.GuidesVO;

/**
 * Created by Arkar Hein on 1/5/2018.
 */

public class GuideItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_guide_name)
    TextView tvGuideName;

    @BindView(R.id.iv_guide_image)
    ImageView ivGuideImage;

    public GuideItemViewHolder(View itemView) {

        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setGuides(GuidesVO guides) {
        tvGuideName.setText(guides.getBurppleGuideTitle());

        if (guides.getBurppleGuideImage() != null) {
            ivGuideImage.setVisibility(View.VISIBLE);
            Glide.with(ivGuideImage.getContext())
                    .load(guides.getBurppleGuideImage())
                    .into(ivGuideImage);
        } else {
            ivGuideImage.setVisibility(View.GONE);
        }
    }
}
