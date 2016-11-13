package mbc.sdos.es.mbc.di.components;

import javax.inject.Singleton;

import dagger.Component;
import mbc.sdos.es.mbc.di.modules.AppModule;
import mbc.sdos.es.mbc.domain.usecase.GetLatestBooksApiUC;
import mbc.sdos.es.mbc.view.book.activity.FavoritesListActivity;
import mbc.sdos.es.mbc.view.book.activity.LatestListActivity;
import mbc.sdos.es.mbc.view.book.adapter.LatestRecyclerAdapter;
import mbc.sdos.es.mbc.view.base.view.MBCActivity;
import mbc.sdos.es.mbc.view.book.fragment.FavoritesListFragment;
import mbc.sdos.es.mbc.view.book.fragment.LatestListFragment;
import mbc.sdos.es.mbc.view.book.presenter.LatestPresenter;

/**
 * Created by jose.fernandez on 29/10/2016.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {


    // PRESENTERS
    void inject(LatestPresenter presenter);

    // ACTIVITIES
    void inject(MBCActivity mbcActivity);

    void inject(LatestListActivity booksActivity);

    void inject(FavoritesListActivity favoritesListActivity);


    // MANAGERS

    // Fragments
    void inject(LatestListFragment bookListFragment);

    void inject(FavoritesListFragment favoritesListFragment);

    // Adapter
    void inject(LatestRecyclerAdapter bookRecyclerAdapter);

    //USE CASES
    void inject(GetLatestBooksApiUC getWsBookListUC);

    //Repositories


}
