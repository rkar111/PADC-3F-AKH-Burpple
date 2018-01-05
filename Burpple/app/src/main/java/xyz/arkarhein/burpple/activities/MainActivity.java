package xyz.arkarhein.burpple.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.adapters.GuideItemsAdapter;
import xyz.arkarhein.burpple.adapters.NewsAndTrendingItemAdapter;
import xyz.arkarhein.burpple.adapters.PromotionItemsAdapter;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_promotions_items)
    RecyclerView rvPromotionItems;

    @BindView(R.id.rv_burpple_guides_items)
    RecyclerView rvBurppleGuidesItems;

    @BindView(R.id.rv_news_trending)
    RecyclerView rvNewsTrending;

    @BindView(R.id.btn_search)
    TextView btnSearch;

    private PromotionItemsAdapter mPromotionItemsAdapter = new PromotionItemsAdapter();
    private GuideItemsAdapter mGuideItemsAdapter = new GuideItemsAdapter();
    private NewsAndTrendingItemAdapter mNewsAndTrendingItemAdapter = new NewsAndTrendingItemAdapter();

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

        LinearLayoutManager linearLayoutManagerNewsTrending = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvNewsTrending.setLayoutManager(linearLayoutManagerNewsTrending);
        rvNewsTrending.setAdapter(mNewsAndTrendingItemAdapter);

    }
}
