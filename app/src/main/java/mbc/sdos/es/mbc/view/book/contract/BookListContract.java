package mbc.sdos.es.mbc.view.book.contract;

import java.util.List;

import mbc.sdos.es.mbc.view.base.view.BaseContract;
import mbc.sdos.es.mbc.view.viewmodel.BookViewModel;


/**
 * Created by jose.fernandez on 29/10/2016.
 */

public interface BookListContract {

    interface View extends BaseContract.LoadingView {
        void setData(List<BookViewModel> books);

        void setEmptyData();
    }

    interface Presenter extends BaseContract.Presenter<BookListContract.View> {
        void setActivityView(ActivityView activityView);

        void getLatestBooks();
    }

    interface ActivityView extends BaseContract {
        void updateToolbarTitle(String title);

    }
}
