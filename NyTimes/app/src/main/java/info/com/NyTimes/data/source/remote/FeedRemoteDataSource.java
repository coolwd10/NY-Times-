package info.com.NyTimes.data.source.remote;


import info.com.NyTimes.android.mvp.main.home.model.MostPopularResponce;
import info.com.NyTimes.data.source.IFeedDataSouce;
import io.reactivex.Observable;


public class FeedRemoteDataSource implements IFeedDataSouce {

    private FeedAPIService mFeedAPIService;

    public FeedRemoteDataSource(FeedAPIService feedAPIService) {
        mFeedAPIService = feedAPIService;
    }

    @Override
    public Observable<MostPopularResponce> getMostPopulaNew() {
        return mFeedAPIService.getMostPopulaNew("viewed/7.json?api-key=Gxzg1CU1vQmoGnAUekvvKCySOl4L7tEG");
    }
}
