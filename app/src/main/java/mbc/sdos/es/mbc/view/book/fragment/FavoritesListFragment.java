package mbc.sdos.es.mbc.view.book.fragment;

/**
 * Created by jose.fernandez on 10/11/2016.
 */

public class FavoritesListFragment extends LatestListFragment {


    public static FavoritesListFragment newInstance() {
        FavoritesListFragment favoritesListFragment = new FavoritesListFragment();
        return favoritesListFragment;
    }

    @Override
    protected void initializeView() {
        super.initializeView();
        bottomBarView.setOnTabClickListener(this).setTabEnabled(1, false);
    }

}