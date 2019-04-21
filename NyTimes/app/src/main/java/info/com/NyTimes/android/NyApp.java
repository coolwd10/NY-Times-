package info.com.NyTimes.android;

import android.app.Application;

import info.com.NyTimes.android.di.component.AppComponent;
import info.com.NyTimes.android.di.component.DaggerAppComponent;
import info.com.NyTimes.android.di.module.ApiModule;
import info.com.NyTimes.android.di.module.AppModule;
import info.com.NyTimes.android.di.module.DataModule;
import timber.log.Timber;


public class NyApp extends Application {

    private AppComponent appComponent;
    private String BASE_URL = "http://api.nytimes.com/svc/mostpopular/v2/";
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().apiModule(new ApiModule(BASE_URL))
                .appModule(new AppModule(this)).dataModule(new DataModule()).build();
        initTimber();
    }

    private void initTimber() {
        /*

         */
        Timber.plant(new Timber.DebugTree());
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
