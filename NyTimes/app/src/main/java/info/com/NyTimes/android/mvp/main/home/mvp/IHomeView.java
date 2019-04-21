package info.com.NyTimes.android.mvp.main.home.mvp;


import java.util.List;

import info.com.NyTimes.android.mvp.core.base.BaseScreen;
import info.com.NyTimes.android.mvp.main.home.model.Result;

public interface IHomeView extends BaseScreen {
    void showView(List<Result> results);
}
