package info.com.NyTimes.domain;


import javax.inject.Inject;

import info.com.NyTimes.android.mvp.main.home.model.MostPopularResponce;
import info.com.NyTimes.data.source.IFeedDataSouce;
import info.com.NyTimes.domain.IView.IHomeUseCase;
import io.reactivex.Observable;


public class HomeUseCaseConttroller implements IHomeUseCase {

    IFeedDataSouce mFeedDataSouce;

    @Inject
    public HomeUseCaseConttroller(IFeedDataSouce feedDataSouce) {
        mFeedDataSouce = feedDataSouce;
    }

    @Override
    public Observable<MostPopularResponce> getMostPopularNew() {
        return mFeedDataSouce.getMostPopulaNew();
    }
}
