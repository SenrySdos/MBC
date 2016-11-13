package mbc.sdos.es.mbc.domain.usecase.base;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import com.path.android.jobqueue.RetryConstraint;

/**
 * Job extension created to be able to execute a use case using android-priority-job-queue.
 */
class UseCaseWrapperJob<Q extends UseCase.RequestValues, R extends UseCase.ResponseValue>
    extends Job {
  private static final int PRIORITY_NORMAL = 3;
  private final UseCase<Q, R> useCase;
  private final Q requestValues;
  private final UseCase.UseCaseCallback<R> callback;

  public UseCaseWrapperJob(UseCase<Q, R> useCase, Q requestValues,
      UseCase.UseCaseCallback<R> callback) {
    super(new Params(PRIORITY_NORMAL));
    this.useCase = useCase;
    this.requestValues = requestValues;
    this.callback = callback;
  }

  @Override
  public void onAdded() {

  }

  @Override
  public void onRun() throws Throwable {
    useCase.executeUseCase(requestValues, callback);
  }

  @Override
  protected void onCancel() {

  }

  //@Override
  //protected boolean shouldReRunOnThrowable(Throwable throwable) {
  //  return false;
  //}

  @Override
  protected RetryConstraint shouldReRunOnThrowable(Throwable throwable, int runCount,
      int maxRunCount) {
    return RetryConstraint.CANCEL;
  }
}