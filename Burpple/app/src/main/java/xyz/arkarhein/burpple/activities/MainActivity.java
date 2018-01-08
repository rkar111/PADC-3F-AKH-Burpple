package xyz.arkarhein.burpple.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.adapters.BackgroundNewsImagesAdapter;
import xyz.arkarhein.burpple.adapters.GuideItemsAdapter;
import xyz.arkarhein.burpple.adapters.NewlyOpenedItemsAdapter;
import xyz.arkarhein.burpple.adapters.PromotionItemsAdapter;
import xyz.arkarhein.burpple.adapters.TrendingVanuesItemsAdapter;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_promotions_items)
    RecyclerView rvPromotionItems;

    @BindView(R.id.rv_burpple_guides_items)
    RecyclerView rvBurppleGuidesItems;

    @BindView(R.id.vp_background_news)
    ViewPager vpBackgroundNews;

    @BindView(R.id.rv_newly_opened)
    RecyclerView rvNewlyOpened;

    @BindView(R.id.rv_trending_venues)
    RecyclerView rvTrendingVenues;

    private PromotionItemsAdapter mPromotionItemsAdapter = new PromotionItemsAdapter();
    private GuideItemsAdapter mGuideItemsAdapter = new GuideItemsAdapter();
    private NewlyOpenedItemsAdapter mNewlyOpenedItemsAdapter = new NewlyOpenedItemsAdapter();
    private TrendingVanuesItemsAdapter mTrendingVanuesItemsAdapter = new TrendingVanuesItemsAdapter();
    private BackgroundNewsImagesAdapter mBackgroundNewsImagesAdapter = new BackgroundNewsImagesAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvPromotionItems.setLayoutManager(linearLayoutManager);
        rvPromotionItems.setAdapter(mPromotionItemsAdapter);

        LinearLayoutManager linearLayoutManagerGuide = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvBurppleGuidesItems.setLayoutManager(linearLayoutManagerGuide);
        rvBurppleGuidesItems.setAdapter(mGuideItemsAdapter);

        LinearLayoutManager linearLayoutManagerNewlyOpened = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        rvNewlyOpened.setLayoutManager(linearLayoutManagerNewlyOpened);
        rvNewlyOpened.setAdapter(mNewlyOpenedItemsAdapter);

        LinearLayoutManager linearLayoutManagerTrendingVenues = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        rvTrendingVenues.setLayoutManager(linearLayoutManagerTrendingVenues);
        rvTrendingVenues.setAdapter(mTrendingVanuesItemsAdapter);

        vpBackgroundNews.setAdapter(mBackgroundNewsImagesAdapter);

    }
}
