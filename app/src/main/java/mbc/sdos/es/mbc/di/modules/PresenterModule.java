package mbc.sdos.es.mbc.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mbc.sdos.es.mbc.di.DIManager;
import mbc.sdos.es.mbc.view.book.contract.BookListContract;
import mbc.sdos.es.mbc.view.book.presenter.LatestPresenter;


@Module
public class PresenterModule {

    @Provides
    @Singleton
    BookListContract.Presenter provideBooksPresenter() {
        LatestPresenter presenter = new LatestPresenter();
        DIManager.getAppComponent().inject(presenter);
        return presenter;
    }


}
