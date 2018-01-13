package xyz.arkarhein.burpple.viewitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.data.vo.FeaturedVO;

/**
 * Created by Arkar Hein on 1/12/2018.
 */

public class BackgroundNewsImageViewItem extends FrameLayout {

    @BindView(R.id.iv_featured_image)
    ImageView ivFeaturedImage;

    @BindView(R.id.tv_featured_heading)
    TextView tvFeaturedHeading;

    @BindView(R.id.tv_featured_details)
    TextView tvFeaturedDetails;

    @BindView(R.id.tv_featured_desc)
    TextView tvFeaturedDesc;

    public BackgroundNewsImageViewItem(@NonNull Context context) {
        super(context);
    }

    public BackgroundNewsImageViewItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BackgroundNewsImageViewItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setFeatured(FeaturedVO featured) {
        tvFeaturedHeading.setText(featured.getBurppleFeaturedTag());
        tvFeaturedDetails.setText(featured.getBurppleFeaturedTitle());
        tvFeaturedDesc.setText(featured.getBurppleFeaturedDesc());

        Glide.with(ivFeaturedImage.getContext())
                .load(featured.getBurppleFeaturedImage())
                .into(ivFeaturedImage);

    }
}
