package info.com.NyTimes.data.source.remote;


import info.com.NyTimes.android.mvp.main.home.model.MostPopularResponce;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FeedAPIService {

    @GET
    Observable<MostPopularResponce> getMostPopulaNew(@Url String url);
}
