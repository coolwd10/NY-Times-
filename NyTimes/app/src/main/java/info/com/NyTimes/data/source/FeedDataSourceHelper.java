package info.com.NyTimes.data.source;


import info.com.NyTimes.android.mvp.main.home.model.MostPopularResponce;
import info.com.NyTimes.data.source.remote.FeedRemoteDataSource;
import io.reactivex.Observable;


public class FeedDataSourceHelper implements IFeedDataSouce {

    FeedRemoteDataSource mFeedRemoteDataSource;

    public FeedDataSourceHelper(FeedRemoteDataSource feedRemoteDataSource) {
        mFeedRemoteDataSource = feedRemoteDataSource;
    }


    @Override
    public Observable<MostPopularResponce> getMostPopulaNew() {
        return mFeedRemoteDataSource.getMostPopulaNew();
    }
}
