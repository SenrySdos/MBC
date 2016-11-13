package mbc.sdos.es.mbc.domain.usecase.base;

import mbc.sdos.es.mbc.util.LooperUtils;

public abstract class UseCaseUiCallback<R> implements UseCase.UseCaseCallback<R> {

  @Override
  public void onSuccess(final R response) {
    if (LooperUtils.isUi()) {
      onUiSuccess(response);
    } else {
      LooperUtils.runOnUi(new Runnable() {
        @Override
        public void run() {
          onUiSuccess(response);
        }
      });
    }
  }

  protected abstract void onUiSuccess(R response);

  protected abstract void onUiError();

  @Override
  public void onError() {
    if (LooperUtils.isUi()) {
      onUiError();
    } else {
      LooperUtils.runOnUi(new Runnable() {
        @Override
        public void run() {
          onUiError();
        }
      });
    }
  }
}