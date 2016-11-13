package mbc.sdos.es.mbc.view.base.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public abstract class RecyclerBaseAdapter<T, VH extends RecyclerBaseAdapter.BaseViewHolder<T>>
    extends RecyclerView.Adapter<VH> implements Filterable {

  public static final int FOOTER_VIEWTYPE = 52498;
  public static final int HEADER_VIEWTYPE = 45784;

  protected List<T> originalData;
  protected List<T> filteredData;

  private Comparator<T> comparator;
  private ItemFilter itemFilter = new ItemFilter();

  private OnItemLongClickListener<T> itemLongClickListener;
  private OnItemClickListener<T> itemClickListener;
  private boolean hasHeader = false;
  private boolean hasFooter = false;

  private LayoutInflater layoutInflater;

  /**
   * Must implements the following methods:
   * ·
   * - onCreateViewHolder: Create the view and ViewHolder for the row.
   * IMPORTANT: set atachToRoot to false
   * ·
   * - bindViewHolder: Initialize the view with the item data.
   * ·
   * When we need filter the data, implements 'passTheFilter' who return if the
   * item passTheFilter or not.
   * Usage example: "Adapter".getFilter().filter(String constraint).
   */
  public RecyclerBaseAdapter(List<T> data) {
    this.originalData = data;
    this.filteredData = new LinkedList<>();
    filteredData.addAll(data);
  }

  @Override
  public VH onCreateViewHolder(ViewGroup parent, int viewType) {
    return onCreateViewHolder(getLayoutInflater(parent), parent, viewType);
  }

  /**
   * Create view and ViewHolder for the row. Viewtype variable can be FOOTER_VIEWTYPE,
   * HEADER_VIEWTYPE or other.
   *
   * Example: return new BaseViewHolder(layoutInflater.inflate(R.layout.row, parent, false));
   */
  public abstract VH onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup parent,
      int viewType);

  protected void onBindHeader(VH holder) {
  }

  protected void onBindFooter(VH holder) {
  }

  @Override
  public void onBindViewHolder(VH holder, int position) {
    int footerRange = 1;
    if (hasHeader) {
      if (position == 0) {
        onBindHeader(holder);
        return;
      }
      position--;
      footerRange = 2;
    }
    if (hasFooter && position == getItemCount() - footerRange) {
      onBindFooter(holder);
      return;
    }
    T item = getItem(position);
    holder.init(item, itemClickListener, itemLongClickListener, getItemCount(), hasHeader,
        hasFooter);

    bindViewHolder(holder, item, position);
  }

  /**
   * Initialize the view with data object.
   */
  protected abstract void bindViewHolder(VH holder, T item, int position);

  /**
   * return how many items contains, header and footer includes.
   */
  @Override
  public int getItemCount() {
    int count = filteredData.size();
    if (hasFooter) {
      count++;
    }
    if (hasHeader) {
      count++;
    }
    return count;
  }

  @Override
  public int getItemViewType(int position) {
    if (hasHeader && position == 0) {
      return HEADER_VIEWTYPE;
    }
    if (hasFooter && position == getItemCount() - 1) {
      return FOOTER_VIEWTYPE;
    }
    return super.getItemViewType(position);
  }

  /**
   * Reset adapter with the input data list.
   */
  public void setData(List<T> data) {
    this.originalData = data;
    reload();
    notifyDataSetChanged();
  }

  /**
   * Add items
   */
  public void addData(Collection<T> data) {
    int positionStart = getItemCount();
    addData(data, positionStart);
  }

  protected void addData(Collection<T> data, int position) {
    originalData.addAll(position, data);
    reload();
    if (comparator != null) {
      notifyDataSetChanged();
    } else {
      notifyItemRangeInserted(position, data.size());
    }
  }

  /**
   * Returns true if list is empty.
   */
  public boolean isEmpty() {
    return originalData.isEmpty();
  }

  /**
   * Atach the input comparator to this adapter.
   * (when add items, the list stay order).
   */
  public void setComparator(Comparator<T> comparator) {
    this.comparator = comparator;
    reload();
  }

  private void reload() {
    if (comparator != null && originalData != null) {
      Collections.sort(originalData, comparator);
    }
    itemFilter.filter();
  }

  /**
   * Order the list with the input comparator.
   * (when add items, the list not stay order, items put at end).
   */
  public void sort(Comparator<T> comparator) {
    if (comparator != null && originalData != null) {
      Collections.sort(originalData, comparator);
      itemFilter.filter();
      notifyDataSetChanged();
    }
  }

  /**
   * Delete item and throw notifyItemRemoved.
   */
  public int deleteItem(T item) {
    int position = findItemPosition(item);
    if (position >= 0) {
      filteredData.remove(position);
      notifyItemRemoved(position);
      originalData.remove(item);
    }
    return position;
  }

  /**
   * Update item and throw notifyItemChanged
   */
  public int updateItem(T item) {
    int position = findItemPosition(item);
    if (position >= 0) {
      filteredData.remove(position);
      filteredData.set(position, item);
      notifyItemChanged(position);

      int positionOriginal = findItemPosition(item, originalData);
      if (positionOriginal >= 0) {
        originalData.remove(positionOriginal);
        originalData.set(positionOriginal, item);
      }
    }
    return position;
  }

  /**
   * Insert item and throw notifyItemInserted.
   */
  public void insertItem(T item) {
    originalData.add(item);
    reload();
    notifyItemInserted(findItemPosition(item));
  }

  /**
   * Insert item at input position and throw notifyItemInserted.
   */
  protected void insertItem(T item, int position) {
    if (position >= 0 && position <= filteredData.size()) {
      originalData.add(position, item);
      reload();
      notifyItemInserted(findItemPosition(item));
    } else {
      insertItem(item);
    }
  }

  /**
   * Returns item position.
   */
  public int findItemPosition(T item) {
    return findItemPosition(item, filteredData);
  }

  private int findItemPosition(T item, List<T> data) {
    int position = -1;
    if (data == null) {
      return -1;
    }
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i).equals(item)) {
        position = i;
        break;
      }
    }
    return position;
  }

  /**
   * Returns item at input position.
   */
  public T getItem(int position) {
    return filteredData.get(position);
  }

  /**
   * Returns all showing items
   */
  public List<T> getItems() {
    return filteredData;
  }

  @Override
  public Filter getFilter() {
    return itemFilter;
  }

  private LayoutInflater getLayoutInflater(View v) {
    if (layoutInflater == null) {
      layoutInflater = LayoutInflater.from(v.getContext());
    }
    return layoutInflater;
  }

  /**
   * Adds ItemLongClickListener to this adapter.
   */
  public void setItemLongClickListener(OnItemLongClickListener<T> itemLongClickListener) {
    this.itemLongClickListener = itemLongClickListener;
  }

  /**
   * Adds ItemClickListener to this adapter.
   */
  public void setItemClickListener(OnItemClickListener<T> itemClickListener) {
    this.itemClickListener = itemClickListener;
  }

  protected boolean hasHeaderEnabled() {
    return hasHeader;
  }

  /**
   * Set if header is enabled.
   */
  protected void enableHeader(boolean enableHeader) {
    this.hasHeader = enableHeader;
  }

  protected boolean hasFooterEnabled() {
    return hasFooter;
  }

  /**
   * Set if footer is enabled.
   */
  protected void enableFooter(boolean enableFooter) {
    this.hasFooter = enableFooter;
  }

  /**
   * When we need filter the data, implements this method.
   * Usage example: "Adapter".getFilter().filter(String constraint).
   */
  public boolean passTheFilter(T item, String constraint) {
    return true;
  }

  private class ItemFilter extends Filter {
    private String lastConstraint = null;

    private void filter() {
      filteredData = (List<T>) performFiltering(lastConstraint).values;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

      if (constraint != null) {
        lastConstraint = constraint.toString().toLowerCase();
      } else {
        lastConstraint = null;
      }

      FilterResults results = new FilterResults();

      int count = originalData.size();
      final List<T> filterlist = new ArrayList<>(count);

      for (int i = 0; i < count; i++) {
        T item = originalData.get(i);
        if (passTheFilter(item, lastConstraint)) {
          filterlist.add(item);
        }
      }

      results.values = filterlist;
      results.count = filterlist.size();

      return results;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
      filteredData = (List<T>) results.values;
      notifyDataSetChanged();
    }
  }

  public abstract static class BaseViewHolder<K> extends RecyclerView.ViewHolder
      implements View.OnClickListener, View.OnLongClickListener {

    private K item;
    private OnItemClickListener<K> itemClickListener;
    private OnItemLongClickListener<K> itemLongClickListener;
    private int size;
    private boolean hasHeader, hasFooter;

    /**
     * If we use ButterKnife binds, adds "ButterKnife.bind(this, itemView);" here.
     */
    public BaseViewHolder(View itemView) {
      super(itemView);
      itemView.setOnClickListener(this);
      itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
      if (itemClickListener != null) {
        if (hasHeader && getAdapterPosition() == 0) {
          return;
        }
        if (hasFooter && getAdapterPosition() == size - 1) {
          return;
        }
        if (hasHeader) {
          itemClickListener.onItemClickListener(v, getAdapterPosition() - 1, item);
        } else {
          itemClickListener.onItemClickListener(v, getAdapterPosition(), item);
        }
      }
    }

    @Override
    public boolean onLongClick(View v) {
      if (hasHeader && getAdapterPosition() == 0) {
        return false;
      }
      if (hasFooter && getAdapterPosition() == size - 1) {
        return false;
      }
      if (hasHeader) {
        return itemLongClickListener != null && itemLongClickListener.onItemLongClickListener(v,
            getAdapterPosition() - 1, item);
      } else {
        return itemLongClickListener != null && itemLongClickListener.onItemLongClickListener(v,
            getAdapterPosition(), item);
      }
    }

    public void init(K item, OnItemClickListener<K> itemClickListener,
        OnItemLongClickListener<K> itemLongClickListener, int size, boolean hasHeader,
        boolean hasFooter) {
      this.item = item;
      this.itemClickListener = itemClickListener;
      this.itemLongClickListener = itemLongClickListener;
      this.size = size;
      this.hasHeader = hasHeader;
      this.hasFooter = hasFooter;
    }
  }

  public interface OnItemClickListener<T> {
    void onItemClickListener(View rowView, int position, T item);
  }

  public interface OnItemLongClickListener<T> {
    boolean onItemLongClickListener(View rowView, int position, T item);
  }
}
