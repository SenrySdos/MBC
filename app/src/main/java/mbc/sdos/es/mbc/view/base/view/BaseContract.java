package mbc.sdos.es.mbc.view.base.view;

import android.app.Activity;

public interface BaseContract {

  // VIEWS
  interface View {
    Activity getActivity();
  }

  interface LoadingView extends View {
    void setLoading(boolean loading);

    void showErrorMessage(String errorMessage);
  }

  // PRESENTERS
  interface Presenter<T extends View> {
    void initializeView(T view);

    void onResume();

    void onPause();
  }
}
