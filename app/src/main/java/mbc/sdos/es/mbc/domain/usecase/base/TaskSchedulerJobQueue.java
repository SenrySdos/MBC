package mbc.sdos.es.mbc.domain.usecase.base;

import com.path.android.jobqueue.JobManager;

public class TaskSchedulerJobQueue implements UseCaseScheduler {
  private final JobManager jobManager;

  public TaskSchedulerJobQueue(JobManager jobManager) {
    this.jobManager = jobManager;
    this.jobManager.start();
  }

  @Override
  public <Q extends UseCase.RequestValues, R extends UseCase.ResponseValue> void execute(
      UseCase<Q, R> useCase, Q requestValues, UseCase.UseCaseCallback<R> callback) {
    jobManager.addJobInBackground(new UseCaseWrapperJob<Q, R>(useCase, requestValues, callback));
  }
}