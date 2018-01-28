package xyz.arkarhein.burpple.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.burpple.BurppleApp;
import xyz.arkarhein.burpple.R;
import xyz.arkarhein.burpple.adapters.BackgroundNewsItemsAdapter;
import xyz.arkarhein.burpple.adapters.GuideItemsAdapter;
import xyz.arkarhein.burpple.adapters.NewlyOpenedItemsAdapter;
import xyz.arkarhein.burpple.adapters.PromotionItemsAdapter;
import xyz.arkarhein.burpple.adapters.TrendingVanuesItemsAdapter;
import xyz.arkarhein.burpple.data.vo.data.model.FeaturedModel;
import xyz.arkarhein.burpple.data.vo.data.model.GuidesModel;
import xyz.arkarhein.burpple.data.vo.data.model.PromotionsModel;
import xyz.arkarhein.burpple.delegates.BeforeLoginDelegate;
import xyz.arkarhein.burpple.events.LoadedFeaturedEvent;
import xyz.arkarhein.burpple.events.LoadedGuidesEvent;
import xyz.arkarhein.burpple.events.LoadedPromotionsEvent;
import xyz.arkarhein.burpple.viewpods.BeforeLoginViewPod;


public class MainActivity extends AppCompatActivity implements BeforeLoginDelegate {

    @BindView(R.id.rv_promotions_items)
    RecyclerView rvPromotionItems;

    @BindView(R.id.rv_burpple_guides_items)
    RecyclerView rvBurppleGuidesItems;

    @BindView(R.id.rv_newly_opened)
    RecyclerView rvNewlyOpened;

    @BindView(R.id.vp_background_news)
    ViewPager vpBackgroundNews;

    @BindView(R.id.rv_trending_venues)
    RecyclerView rvTrendingVenues;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    private BeforeLoginViewPod vpBeforeLogin;

    private PromotionItemsAdapter mPromotionItemsAdapter = new PromotionItemsAdapter();
    private GuideItemsAdapter mGuideItemsAdapter = new GuideItemsAdapter();
    private NewlyOpenedItemsAdapter mNewlyOpenedItemsAdapter = new NewlyOpenedItemsAdapter();
    private TrendingVanuesItemsAdapter mTrendingVanuesItemsAdapter = new TrendingVanuesItemsAdapter();
    private BackgroundNewsItemsAdapter mBackgroundNewsItemsAdapter = new BackgroundNewsItemsAdapter();

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

        vpBackgroundNews.setAdapter(mBackgroundNewsItemsAdapter);

        GuidesModel.getsObjInstance().loadGuides();
        PromotionsModel.getsObjInstance().loadPromotions();
        FeaturedModel.getsObjInstance().loadFeatures();

        vpBeforeLogin = (BeforeLoginViewPod) navigationView.getHeaderView(0);
        vpBeforeLogin.setDelegate(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGuidesLoaded(LoadedGuidesEvent event) {
        Log.d(BurppleApp.LOG_TAG, "onGuidesLoaded" + event.getGuidesList().size());
        mGuideItemsAdapter.setGuides(event.getGuidesList());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPromotionsLoaded(LoadedPromotionsEvent event) {
        mPromotionItemsAdapter.setPromotions(event.getPromotionsList());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFeaturedLoaded(LoadedFeaturedEvent event) {
        mBackgroundNewsItemsAdapter.setFeatured(event.getFeaturedList());
    }

    @Override
    public void onTapLogin() {
        Intent intent = AccountControlActivity.newIntentLogin(getApplicationContext());
        startActivity(intent);

    }

    @Override
    public void onTapRegister() {
        Intent intent = AccountControlActivity.newIntentRegister(getApplicationContext());
        startActivity(intent);
    }
}
