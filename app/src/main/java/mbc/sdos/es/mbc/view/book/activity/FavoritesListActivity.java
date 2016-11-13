package mbc.sdos.es.mbc.view.book.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import javax.inject.Inject;

import mbc.sdos.es.mbc.R;
import mbc.sdos.es.mbc.di.DIManager;
import mbc.sdos.es.mbc.view.base.view.MBCActivity;
import mbc.sdos.es.mbc.view.book.contract.BookListContract;
import mbc.sdos.es.mbc.view.book.fragment.FavoritesListFragment;

/**
 * Created by jose.fernandez on 10/11/2016.
 */

public class FavoritesListActivity extends MBCActivity implements
        BookListContract.ActivityView {

    @Inject
    BookListContract.Presenter presenter;
    private TextView toolbarTitle;

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, FavoritesListActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_from_right_enter,
                R.anim.slide_from_left_exit_slow);
    }

    @Override
    protected Builder configureActivityBuilder(Builder builder) {

        return super.configureActivityBuilder(builder)
                .setToolbar(R.layout.toolbar_text).enableDrawer(false).setToolbarBack(false);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        DIManager.getAppComponent().inject(this);
        presenter.setActivityView(this);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        updateToolbarTitle(getString(R.string.favorites));
        setFragment(FavoritesListFragment.newInstance());
    }

    @Override
    public void updateToolbarTitle(String title) {
        toolbarTitle.setText(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_from_left_enter_slow, R.anim.slide_from_right_exit);
    }

    public static void createIntent(Context context) {
        Intent intent = new Intent(context, FavoritesListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(intent);
    }
}
