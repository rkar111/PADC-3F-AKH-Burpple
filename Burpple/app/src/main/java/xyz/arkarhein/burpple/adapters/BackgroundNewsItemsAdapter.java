package xyz.arkarhein.burpple.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.data.vo.FeaturedVO;
import xyz.arkarhein.burpple.viewitems.BackgroundNewsImageViewItem;

/**
 * Created by Arkar Hein on 1/12/2018.
 */

public class BackgroundNewsItemsAdapter extends PagerAdapter {

    private List<FeaturedVO> mfeatured;

    public BackgroundNewsItemsAdapter() {
        mfeatured = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mfeatured.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        BackgroundNewsImageViewItem view = (BackgroundNewsImageViewItem) layoutInflater.inflate(R.layout.background_news_image, container, false);
        view.setFeatured(mfeatured.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public void setFeatured(List<FeaturedVO> featuredList) {
        mfeatured = featuredList;
        notifyDataSetChanged();

    }
}
