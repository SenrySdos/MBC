package mbc.sdos.es.mbc.di;

import mbc.sdos.es.mbc.MBCApplication;
import mbc.sdos.es.mbc.di.components.AppComponent;
import mbc.sdos.es.mbc.di.components .DaggerAppComponent;
import mbc.sdos.es.mbc.di.modules.ApiModule;
import mbc.sdos.es.mbc.di.modules.AppModule;
import mbc.sdos.es.mbc.di.modules.DataModule;
import mbc.sdos.es.mbc.di.modules.PresenterModule;
import mbc.sdos.es.mbc.di.modules.UseCaseModule;

public class DIManager {
    static AppComponent appComponent;

    static public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(MBCApplication.get()))
                    .apiModule(new ApiModule())
                    .dataModule(new DataModule())
                    .useCaseModule(new UseCaseModule())
                    .presenterModule(new PresenterModule())
                    .build();
        }
        return appComponent;
    }
}
