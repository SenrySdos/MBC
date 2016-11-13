package mbc.sdos.es.mbc;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.drawee.backends.pipeline.Fresco;

import io.fabric.sdk.android.Fabric;

/**
 * Created by jose.fernandez on 29/10/2016.
 */

public class MBCApplication extends Application {

    static MBCApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Fresco.initialize(this);
        // Fabric crashlytics
        if (BuildConfig.BUILD_TYPE.equalsIgnoreCase("preproduction")) {
            Fabric.with(this, new Crashlytics());
        }

        //Facebook initialize
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }

    public static MBCApplication get() {
        return instance;
    }
}

