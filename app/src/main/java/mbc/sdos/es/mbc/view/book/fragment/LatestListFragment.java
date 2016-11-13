package mbc.sdos.es.mbc.view.book.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import mbc.sdos.es.mbc.R;
import mbc.sdos.es.mbc.constants.FlavorConstants;
import mbc.sdos.es.mbc.di.components.AppComponent;
import mbc.sdos.es.mbc.view.book.adapter.LatestRecyclerAdapter;
import mbc.sdos.es.mbc.view.base.view.BaseContract;
import mbc.sdos.es.mbc.view.base.view.MBCFragment;
import mbc.sdos.es.mbc.view.book.contract.BookListContract;
import mbc.sdos.es.mbc.view.viewmodel.BookViewModel;
import mbc.sdos.es.mbc.view.widget.bottombar.BottomBarView;

/**
 * Created by jose.fernandez on 29/10/2016.
 */

public class LatestListFragment extends MBCFragment implements BookListContract.View {

    @Inject
    BookListContract.Presenter presenter;
    @BindView(R.id.category_list_recycler)
    RecyclerView rvBookList;
    @BindView(R.id.category_list_loader)
    ProgressBar pbLoader;
    @BindView(R.id.category_list_container)
    RelativeLayout rlCategoryListContainer;
    @BindView(R.id.category_list_bottom_bar)
    BottomBarView bottomBarView;
    @BindView(R.id.book_list_top_shadow)
    View topShadow;
    @BindView(R.id.book_list_bottom_shadow)
    View bottomShadow;

    LinearLayoutManager mLayoutManager;


    public static LatestListFragment newInstance() {
        LatestListFragment bookListFragment = new LatestListFragment();
        return bookListFragment;
    }

    @Override
    protected void injection(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_book_list;
    }

    @Override
    protected BaseContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    protected void initializeView() {
        rvBookList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvBookList.setNestedScrollingEnabled(true);
        bottomBarView.setOnTabClickListener(this).setTabEnabled(2, false);


        mLayoutManager = new LinearLayoutManager(getActivity());
        rvBookList.setLayoutManager(mLayoutManager);

        presenter.getLatestBooks();
    }

    @Override
    public void setData(final List<BookViewModel> books) {
        if (isAdded()) {
            LatestRecyclerAdapter adapter = new LatestRecyclerAdapter(books, rvBookList);
            rvBookList.setAdapter(adapter);

            rvBookList.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                    if (books != null) {
                        //Tocheck if  recycler is on top
                        if (mLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                            //Its at top ..
                            topShadow.setAlpha(0);
                        } else {
                            topShadow.setAlpha(1);
                        }

                        //Tocheck if  recycler is on bottom
                        if (mLayoutManager.findLastCompletelyVisibleItemPosition() == books.size() - 1) {
                            //Its at bottom ..
                            bottomShadow.setAlpha(0);
                        } else {
                            bottomShadow.setAlpha(1);
                        }
                    }
                }
            });
        }
    }

    @Override
    public void setEmptyData() {

    }

    @Override
    public void setLoading(boolean loading) {
        if (loading) {
            showLoader();
        } else {
            stopLoader();
        }
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    public void showLoader() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(pbLoader, "alpha", 1),
                ObjectAnimator.ofFloat(rlCategoryListContainer, "alpha", 0)
        );
        animatorSet.setDuration(FlavorConstants.ANIMATION_DEFAULT_TIME).start();
    }

    public void stopLoader() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(pbLoader, "alpha", 1, 0),
                ObjectAnimator.ofFloat(rlCategoryListContainer, "alpha", 0, 1)
        );
        animatorSet.setDuration(FlavorConstants.ANIMATION_DEFAULT_TIME).start();
    }
}
