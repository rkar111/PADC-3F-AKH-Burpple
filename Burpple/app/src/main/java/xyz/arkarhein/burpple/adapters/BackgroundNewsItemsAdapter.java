package xyz.arkarhein.burpple.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.viewitems.BackgroundNewsImageViewItem;

/**
 * Created by Arkar Hein on 1/12/2018.
 */

public class BackgroundNewsItemsAdapter extends PagerAdapter {


    @Override
    public int getCount() {
        return 6;
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
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
