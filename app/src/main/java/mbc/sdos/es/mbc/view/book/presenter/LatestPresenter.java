package mbc.sdos.es.mbc.view.book.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mbc.sdos.es.mbc.MBCApplication;
import mbc.sdos.es.mbc.R;
import mbc.sdos.es.mbc.domain.usecase.GetLatestBooksApiUC;
import mbc.sdos.es.mbc.domain.usecase.base.UseCaseHandler;
import mbc.sdos.es.mbc.domain.usecase.base.UseCaseUiCallback;
import mbc.sdos.es.mbc.view.base.view.BasePresenter;
import mbc.sdos.es.mbc.view.book.contract.BookListContract;
import mbc.sdos.es.mbc.view.viewmodel.BookViewModel;
import mbc.sdos.es.mbc.view.viewmodel.mapper.BookViewModelToBookDomain;

public class LatestPresenter extends BasePresenter<BookListContract.View> implements BookListContract.Presenter {

    @Inject
    UseCaseHandler useCaseHandler;
    @Inject
    GetLatestBooksApiUC getWsBookListUC;
    @Inject
    BookViewModelToBookDomain bookViewModelToBookDomain;

    private BookListContract.ActivityView activityView;

    @Override
    public void setActivityView(BookListContract.ActivityView activityView) {
        this.activityView = activityView;
    }

    @Override
    public void getLatestBooks() {

        useCaseHandler.execute(getWsBookListUC, new GetLatestBooksApiUC.RequestValues(), new UseCaseUiCallback<GetLatestBooksApiUC.ResponseValue>() {
            @Override
            protected void onUiSuccess(GetLatestBooksApiUC.ResponseValue response) {
                List<BookViewModel> books = new ArrayList<>(bookViewModelToBookDomain.reverseMap(response.getBooks()));
                view.setLoading(false);
                view.setData(books);
            }

            @Override
            protected void onUiError() {
                view.setLoading(false);
                view.showErrorMessage(MBCApplication.get().getString(R.string.default_error));
            }
        });


    }

    //    private List<BookDomain> generateFakeBooks() {
//        List<BookDomain> books = new ArrayList<BookDomain>();
//        BookDomain bookDomain;
//        Random rand = new Random();
//        for (int i = 0; i < 50; i++) {
//            bookDomain = new BookDomain();
//            bookDomain.setTitle("Title for book" + i);
//            AuthorDomain authorBO = new AuthorDomain();
//            authorBO.setName("Auhot numer" + i);
//            bookDomain.setAuthor(authorBO);
//            CategoryDomain categoryBO = new CategoryDomain();
//            categoryBO.setName("CategoryDomain number" + i);
//            List<CategoryDomain> categoriBos = new ArrayList<CategoryDomain>();
//            categoriBos.add(categoryBO);
//            bookDomain.setCategories(categoriBos);
//            int randomNum = rand.nextInt((4 - 0) + 1) + 0;
//            bookDomain.setImage(images[randomNum]);
//            books.add(bookDomain);
//        }
//
//        return books;
//
//
//    }
}
