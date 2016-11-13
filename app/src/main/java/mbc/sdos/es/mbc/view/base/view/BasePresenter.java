package mbc.sdos.es.mbc.view.base.view;

public class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter<T> {

    private boolean active;
    protected T view;

    @Override
    public void initializeView(T view) {
        this.view = view;
    }

    public T getView() {
        return view;
    }

    @Override
    public void onResume() {
        active = true;
    }

    @Override
    public void onPause() {
        active = false;
    }

    protected boolean isActive() {
        return active;
    }
}
