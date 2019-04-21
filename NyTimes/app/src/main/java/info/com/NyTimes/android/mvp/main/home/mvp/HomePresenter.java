package info.com.NyTimes.android.mvp.main.home.mvp;


import javax.inject.Inject;

import info.com.NyTimes.android.mvp.core.base.BasePresenter;
import info.com.NyTimes.android.mvp.main.home.model.MostPopularResponce;
import info.com.NyTimes.data.source.IFeedDataSouce;
import info.com.NyTimes.domain.HomeUseCaseConttroller;
import info.com.NyTimes.domain.IView.IHomeUseCase;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class HomePresenter extends BasePresenter {

    private IHomeUseCase mHomeViewUseCase;
    private IHomeView mIHomeView;

    @Inject
    HomePresenter(IFeedDataSouce feedDataSouce) {
        mHomeViewUseCase = new HomeUseCaseConttroller(feedDataSouce);
    }

    public void attacheScreen(IHomeView view) {
        super.attacheScreen(view);
        mIHomeView = view;
    }

    public void getMostPoularNewRes() {
        Observable<MostPopularResponce> responce = mHomeViewUseCase.getMostPopularNew();

        responce.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MostPopularResponce>() {
                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MostPopularResponce mostPopularResponce) {
                        mIHomeView.showView(mostPopularResponce.getResults());
                    }
                });
    }
}
