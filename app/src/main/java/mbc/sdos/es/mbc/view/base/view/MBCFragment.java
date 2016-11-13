package mbc.sdos.es.mbc.view.base.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import mbc.sdos.es.mbc.di.DIManager;
import mbc.sdos.es.mbc.di.components.AppComponent;
import mbc.sdos.es.mbc.view.book.activity.LatestListActivity;
import mbc.sdos.es.mbc.view.book.activity.FavoritesListActivity;
import mbc.sdos.es.mbc.view.widget.bottombar.BottomBarView;


public abstract class MBCFragment extends Fragment implements BaseContract.View,
        BottomBarView.OnTabClickListener {

    boolean mFirstAttach = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.mFirstAttach) {
            injection(DIManager.getAppComponent());
            mFirstAttach = false;
        }
    }

    protected abstract void injection(AppComponent appComponent);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(getLayoutResource(), container, false);
        ButterKnife.bind(this, v);
        initializeView();
        if (getPresenter() != null) {
            getPresenter().initializeView(this);
        }
        return v;
    }

    protected abstract
    @LayoutRes
    int getLayoutResource();

    protected abstract BaseContract.Presenter getPresenter();

    protected abstract void initializeView();

    @Override
    public void onResume() {
        super.onResume();
        if (getPresenter() != null) {
            getPresenter().onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getPresenter() != null) {
            getPresenter().onPause();
        }
    }

    @Override
    public void onTabClick(int position, View disabledTab, View view) {
        Intent intent = null;
        switch (position) {
            case 0:

                break;

            case 1:
                FavoritesListActivity.createIntent(this.getContext());
                break;

            case 2:
                LatestListActivity.createIntent(this.getContext());
                break;

            case 3:

                break;

            case 4:

                break;
        }
    }
}
