package info.com.NyTimes.android.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import info.com.NyTimes.data.source.FeedDataSourceHelper;
import info.com.NyTimes.data.source.IFeedDataSouce;
import info.com.NyTimes.data.source.remote.FeedAPIService;
import info.com.NyTimes.data.source.remote.FeedRemoteDataSource;
import retrofit2.Retrofit;

@Module
public final class DataModule {
    @Provides
    @Singleton
    public FeedAPIService provideFeedApiService(Retrofit retrofit) {
        return retrofit.create(FeedAPIService.class);
    }

    @Provides
    @Singleton
    public FeedRemoteDataSource provideFeedRemoteService(FeedAPIService feedAPIService) {
        return new FeedRemoteDataSource(feedAPIService);
    }

    @Singleton
    @Provides
    public IFeedDataSouce provideDataService(FeedRemoteDataSource feedRemoteDataSource) {
        return new FeedDataSourceHelper(feedRemoteDataSource);
    }
}
