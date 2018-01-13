package xyz.arkarhein.burpple.network;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.arkarhein.burpple.events.LoadedFeaturedEvent;
import xyz.arkarhein.burpple.network.responses.GetFeaturedResponse;

/**
 * Created by Arkar Hein on 1/13/2018.
 */

public class FeaturedRetrofitDataAgent implements FeaturedDataAgent {

    private static FeaturedRetrofitDataAgent sObjInstance;

    private FeaturedApi mFeaturedApi;

    private FeaturedRetrofitDataAgent() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mFeaturedApi = retrofit.create(FeaturedApi.class);
    }

    public static FeaturedRetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new FeaturedRetrofitDataAgent();
        }
        return sObjInstance;
    }

    @Override
    public void loadFeatured() {

        Call<GetFeaturedResponse> getFeaturedResponseCall = mFeaturedApi.getFeatured(1, "b002c7e1a528b7cb460933fc2875e916");

        getFeaturedResponseCall.enqueue(new Callback<GetFeaturedResponse>() {
            @Override
            public void onResponse(Call<GetFeaturedResponse> call, Response<GetFeaturedResponse> response) {
                GetFeaturedResponse getFeaturedResponse = response.body();
                if (getFeaturedResponse != null) {
                    LoadedFeaturedEvent event = new LoadedFeaturedEvent(getFeaturedResponse.getFeatured());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetFeaturedResponse> call, Throwable t) {

            }
        });

    }
}
