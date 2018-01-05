package xyz.arkarhein.burpple.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.viewitems.BackgroundNewsImageViewItem;

/**
 * Created by Arkar Hein on 1/5/2018.
 */

public class BackgroundNewsImagesAdapter extends PagerAdapter {
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
        LayoutInflater inflater = LayoutInflater.from(context);
        BackgroundNewsImageViewItem view = (BackgroundNewsImageViewItem) inflater.inflate(R.layout.background_news_image, container, false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
