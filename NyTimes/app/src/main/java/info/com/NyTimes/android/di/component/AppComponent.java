package info.com.NyTimes.android.di.component;


import javax.inject.Singleton;

import dagger.Component;
import info.com.NyTimes.android.di.module.ApiModule;
import info.com.NyTimes.android.di.module.AppModule;
import info.com.NyTimes.android.di.module.DataModule;
import info.com.NyTimes.android.mvp.main.home.HomeActivity;
import info.com.NyTimes.android.mvp.main.home.mvp.HomePresenter;

@Singleton
@Component(modules = {ApiModule.class, AppModule.class, DataModule.class})
public interface AppComponent {
    void inject(HomeActivity homeActivity);
    void inject(HomePresenter homePresenter);
}
