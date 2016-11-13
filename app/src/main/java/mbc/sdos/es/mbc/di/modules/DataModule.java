package mbc.sdos.es.mbc.di.modules;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.log.CustomLogger;
import com.path.android.jobqueue.network.NetworkUtil;
import com.path.android.jobqueue.network.NetworkUtilImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mbc.sdos.es.mbc.R;
import mbc.sdos.es.mbc.data.SessionData;
import mbc.sdos.es.mbc.util.PreferencesUtils;

@Module
public class DataModule {
    public DataModule() {
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application app) {
        return app.getSharedPreferences(app.getString(R.string.app_name), 0);
    }

    @Provides
    @Singleton
    NetworkUtil provideNetworkUtil(Application app) {
        return new NetworkUtilImpl(app);
    }

    @Provides
    @Singleton
    JobManager provideJobManager(Application app, NetworkUtil networkUtil) {
        return this.configureJobManager(app, networkUtil);
    }

    @Singleton
    @Provides
    PreferencesUtils providePreferencesUtils(SharedPreferences sharedPreferences) {
        return new PreferencesUtils(sharedPreferences);
    }

    @Singleton
    @Provides
    SessionData provideSessionData(PreferencesUtils preferencesUtils) {
        return new SessionData(preferencesUtils);
    }

//    @Singleton
//    @Provides
//    CategoryManager provideCategoryManager() {
//        CategoryManager categoryManager = new CategoryManager();
//        DIManager.getAppComponent().inject(categoryManager);
//        return categoryManager;
//    }

//    @Provides
//    @Singleton
//    FormatManager provideFormatManager(SessionData sessionData) {
//        return new FormatManager(sessionData);
//    }

    JobManager configureJobManager(Application application, NetworkUtil networkUtil) {
        Configuration config = (new Configuration.Builder(application))
                .minConsumerCount(1)
                .maxConsumerCount(3)
                .loadFactor(3)
                .consumerKeepAlive(120)
                .networkUtil(networkUtil)
                .customLogger(new CustomLogger() {
                    public boolean isDebugEnabled() {
                        return false;
                    }

                    public void d(String text, Object... args) {
                        Log.v("JobManager", text);
                    }

                    public void e(Throwable t, String text, Object... args) {
                        Log.e("JobManager", text);
                    }

                    public void e(String text, Object... args) {
                        Log.e("JobManager", text);
                    }
                }).build();
        return new JobManager(application, config);
    }

}