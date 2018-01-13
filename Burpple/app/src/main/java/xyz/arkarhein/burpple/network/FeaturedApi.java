package xyz.arkarhein.burpple.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.arkarhein.burpple.network.responses.GetFeaturedResponse;

/**
 * Created by Arkar Hein on 1/13/2018.
 */

public interface FeaturedApi {

    @FormUrlEncoded
    @POST("getFeatured.php")
    Call<GetFeaturedResponse> getFeatured(@Field("page") int page,
                                          @Field("access_token") String accessToken);
}
