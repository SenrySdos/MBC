package mbc.sdos.es.mbc.view.book.adapter;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mbc.sdos.es.mbc.R;
import mbc.sdos.es.mbc.di.DIManager;
import mbc.sdos.es.mbc.domain.model.BookDomain;
import mbc.sdos.es.mbc.view.base.view.RecyclerBaseAdapter;
import mbc.sdos.es.mbc.view.book.contract.BookListContract;
import mbc.sdos.es.mbc.view.viewmodel.BookViewModel;

/**
 * Created by jose.fernandez on 29/10/2016.
 */

public class LatestRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Inject
    BookListContract.Presenter presenter;

    private RecyclerView ownRecyclerView;

    private List<BookViewModel> data;

    public LatestRecyclerAdapter(List<BookViewModel> data, RecyclerView ownRecyclerView) {
        DIManager.getAppComponent().inject(this);
        this.data = new ArrayList<>(data);
        this.ownRecyclerView = ownRecyclerView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_book_principal, parent, false);
        return new BookListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final BookViewModel item = data.get(position);
        if (holder instanceof BookListViewHolder) {
            setupBookView(position, item, holder);
        }
    }

    private void setupBookView(final int position, final BookViewModel item,
                               RecyclerView.ViewHolder holder) {
        final BookListViewHolder itemHolder = (BookListViewHolder) holder;
        itemHolder.tvTitle.setText(item.getTitle());
        itemHolder.tvAuthor.setText((item.getAuthor() != null) ? item.getAuthor().getTitle() : null);
        if (item.getCategories() != null && !item.getCategories().isEmpty()) {
            itemHolder.tvCategory.setText(item.getCategories().get(0).getTitle());
        }
        if (!TextUtils.isEmpty(item.getImage())) {
            Uri imageUri = Uri.parse(item.getImage());
            itemHolder.imgThumbail.setImageURI(imageUri);
        }
    }


    public class BookListViewHolder extends RecyclerBaseAdapter.BaseViewHolder<BookDomain> {

        ViewGroup view;
        @Nullable
        @BindView(R.id.book_list_thumbail)
        SimpleDraweeView imgThumbail;
        @Nullable
        @BindView(R.id.book_list_title)
        TextView tvTitle;
        @Nullable
        @BindView(R.id.book_list_author)
        TextView tvAuthor;
        @Nullable
        @BindView(R.id.book_list_category)
        TextView tvCategory;


        public BookListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            view = (ViewGroup) itemView;
        }

        public ViewGroup getView() {
            return view;
        }
    }
}
