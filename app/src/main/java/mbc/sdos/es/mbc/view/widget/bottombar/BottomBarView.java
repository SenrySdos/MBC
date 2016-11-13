package mbc.sdos.es.mbc.view.widget.bottombar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import mbc.sdos.es.mbc.R;
import mbc.sdos.es.mbc.util.AnimationUtils;

/**
 * Created by jose.fernandez on 29/10/2016.
 */

public class BottomBarView extends LinearLayout implements View.OnClickListener {

    private Context context;

    private LinearLayout llTabContainer;

    private List<Tab> tabs;

    private View disableTab;

    private OnTabClickListener onTabClickListener;
    private Animation scaleUp;

    private Animation scaleDown;

    public BottomBarView(Context context) {
        super(context);
        this.context = context;
        initializeView(context, null);
    }

    public BottomBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initializeView(context, attrs);
    }

    public BottomBarView(Context context, AttributeSet attrs,
                         int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initializeView(context, attrs);
    }

    private void initializeView(final Context context, final AttributeSet attrs) {
        inflate(context, R.layout.widget_bottom_bar, this);
        scaleUp = AnimationUtils.scaleUp(300, 1.0f, 1.1f);
        scaleUp.setFillAfter(true);
        scaleDown = AnimationUtils.scaleDown(300, 1.1f, 1.0f);
        scaleDown.setFillAfter(true);
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs,
                    R.styleable.BottomBarView, 0, 0);
            try {
                // TODO Add some attrs?
            } finally {
                a.recycle();
            }
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        llTabContainer = (LinearLayout) findViewById(R.id.bottom_bar_tab_container);
        buildTabs(generateDefaultTabs());
    }

    /**
     * Builds the tab views using the list of tab objects.
     */
    public BottomBarView buildTabs(List<Tab> tabs) {
        this.tabs = tabs;
        llTabContainer.removeAllViews();
        for (int position = 0; position < tabs.size(); position++) {
            Tab tab = tabs.get(position);
            LinearLayout llTab = (LinearLayout) inflate(context, R.layout.widget_bottom_bar_tab, null);

            if (tab.getImageId() != -1) {
                ImageView imageViewIcon = (ImageView) llTab.findViewById(R.id.bottom_bar_icon);
                imageViewIcon.setImageResource(tab.getImageId());
            }
            LayoutParams layoutParams =
                    new LayoutParams(0,
                            ViewGroup.LayoutParams.MATCH_PARENT, 1f);
            llTab.setLayoutParams(layoutParams);
            llTab.setTag(position);
            llTab.setEnabled(true);
            llTab.setOnClickListener(this);
            if (position == 2) {

                llTab.setBackgroundColor(R.color.bottom_bar_background);
                llTab.setAlpha(0.8f);
            }


            llTabContainer.addView(llTab);
            setTabEnabled(position, true);
        }
        return this;
    }

    /**
     * Generates a list that contains the tabs by default.
     */
    private List<Tab> generateDefaultTabs() {
        List<Tab> tabs = new ArrayList<>();

        Tab tabProduct = new Tab();
        tabProduct.setImageId(R.drawable.cart_icon);
//        tabProduct.setTitle(context.getString(R.string.bottom_bar_products));
        tabs.add(tabProduct);

        Tab tabScan = new Tab();
        tabScan.setImageId(R.drawable.fav_icon);
//        tabScan.setTitle(context.getString(R.string.bottom_bar_scan));
        tabs.add(tabScan);

        Tab tabWallet = new Tab();
        tabWallet.setImageId(R.drawable.book_icon);
//        tabWallet.setTitle(context.getString(R.string.bottom_bar_wallet));
        tabs.add(tabWallet);

        Tab tabUser = new Tab();
        tabUser.setImageId(R.drawable.search_icon);
//        tabUser.setTitle(context.getString(R.string.bottom_bar_user));
        tabs.add(tabUser);

        Tab tabMap = new Tab();
        tabMap.setImageId(R.drawable.user_icon);
//        tabMap.setTitle(context.getString(R.string.bottom_bar_map));
        tabs.add(tabMap);

        return tabs;
    }

    public BottomBarView setTabEnabled(final int position, Boolean isEnabled) {
        int tabCount = llTabContainer.getChildCount();
        if (tabCount > position) {
            View tab = llTabContainer.getChildAt(position);
            tab.setEnabled(isEnabled);
            if (isEnabled == null || !isEnabled) {
                tab.setAlpha(1f);
                if (disableTab != null) {
                    setTabEnabled((int) disableTab.getTag(), true);
                    disableTab.startAnimation(scaleDown);
                }
                disableTab = tab;
                disableTab.startAnimation(scaleUp);
            } else {
                tab.setAlpha(0.5f);
            }
        }
        return this;
    }

    public BottomBarView setTabVisibility(int position, int visibility) {
        int tabCount = llTabContainer.getChildCount();
        if (tabCount > position) {
            View tab = llTabContainer.getChildAt(position);
            tab.setVisibility(visibility);
        }
        return this;
    }

    public BottomBarView setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.onTabClickListener = onTabClickListener;
        return this;
    }

    @Override
    public void onClick(View view) {
        final int position = (int) view.getTag();
        if (onTabClickListener != null) {
            onTabClickListener.onTabClick(position, disableTab, view);
        }
    }

    /**
     * Disables the buttons that are availables for stores with sale type.
     */
    public void disableSaleButtons() {
        setTabVisibility(2, View.GONE).setTabVisibility(3, View.GONE);
    }

    public interface OnTabClickListener {
        void onTabClick(int position, View disableTabview, View view);
    }

    public List<Tab> getTabs() {
        return tabs;
    }

    public void setTabs(List<Tab> tabs) {
        this.tabs = tabs;
    }

}
