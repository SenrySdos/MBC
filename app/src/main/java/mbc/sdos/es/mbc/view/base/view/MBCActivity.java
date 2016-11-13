package mbc.sdos.es.mbc.view.base.view;

import android.os.Bundle;

import com.squareup.otto.Bus;
import com.underlegendz.underactivity.UnderActivity;

import javax.inject.Inject;

import mbc.sdos.es.mbc.di.DIManager;

public class MBCActivity extends UnderActivity {

    @Inject
    protected Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DIManager.getAppComponent().inject(this);
    }

    @Override
    protected Builder configureActivityBuilder(Builder builder) {
        //TODO general activity configuration
        return builder;
    }
}
