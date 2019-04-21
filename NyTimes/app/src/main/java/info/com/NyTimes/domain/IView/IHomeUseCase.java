package info.com.NyTimes.domain.IView;


import info.com.NyTimes.android.mvp.main.home.model.MostPopularResponce;
import io.reactivex.Observable;


public interface IHomeUseCase {

    Observable<MostPopularResponce> getMostPopularNew();

}
