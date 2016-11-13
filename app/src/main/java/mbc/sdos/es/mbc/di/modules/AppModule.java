package mbc.sdos.es.mbc.di.modules;

import android.app.Application;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mbc.sdos.es.mbc.MBCApplication;

@Module(includes = {
        ApiModule.class,
        DataModule.class,
        UseCaseModule.class,
        PresenterModule.class
})
public final class AppModule {
    private final MBCApplication application;

    public AppModule(MBCApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    //Add @Providers to customize core features
    @Provides
    @Singleton
    Bus provideBus() {
        return new Bus();
    }
}

