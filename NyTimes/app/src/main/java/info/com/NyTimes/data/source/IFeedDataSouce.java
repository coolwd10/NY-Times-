package info.com.NyTimes.data.source;


import info.com.NyTimes.android.mvp.main.home.model.MostPopularResponce;
import io.reactivex.Observable;


public interface IFeedDataSouce {

    Observable<MostPopularResponce> getMostPopulaNew();

}
