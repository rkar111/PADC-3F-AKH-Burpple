package xyz.arkarhein.burpple.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import xyz.arkarhein.burpple.BurppleApp;
import xyz.arkarhein.burpple.events.LoadedGuidesEvent;
import xyz.arkarhein.burpple.network.responses.GetGuideResponses;

/**
 * Created by Arkar Hein on 1/13/2018.
 */

public class GuidesOkHttpDataAgent implements GuidesDataAgent {

    private static GuidesOkHttpDataAgent sObjInstance;

    private GuidesOkHttpDataAgent(){

    }

    public static GuidesOkHttpDataAgent getsObjInstance(){
        if (sObjInstance==null){
            sObjInstance=new GuidesOkHttpDataAgent();
        }
        return sObjInstance;
    }

    @Override
    public void loadGuides() {
        new LoadGuidesTask()
                .execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getGuides.php");

    }

    private static class LoadGuidesTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {
            String url=urls[0];

            OkHttpClient httpClient=new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(15,TimeUnit.SECONDS)
                    .writeTimeout(15,TimeUnit.SECONDS)
                    .build();

            RequestBody formbody=new FormBody.Builder()
                    .add("access_token","b002c7e1a528b7cb460933fc2875e916")
                    .add("page","1")
                    .build();

            Request request =new Request.Builder()
                    .url(url)
                    .post(formbody)
                    .build();

            String responseString=null;
            try{
                Response response=httpClient.newCall(request).execute();
                if (response.isSuccessful() && response.body()!=null){
                    responseString=response.body().string();
                }
            }catch (Exception e){
                Log.e(BurppleApp.LOG_TAG,e.getMessage());
            }
            return responseString;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            Gson gson=new Gson();
            GetGuideResponses getGuideResponses=gson.fromJson(response,GetGuideResponses.class);

            LoadedGuidesEvent event=new LoadedGuidesEvent(getGuideResponses.getFeatured());
            EventBus eventBus=EventBus.getDefault();
            eventBus.post(event);

        }
    }
}
