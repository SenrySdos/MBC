package mbc.sdos.es.mbc.domain.usecase.base;

/**
 * Interface for schedulers.
 */
public interface UseCaseScheduler {
  <Q extends UseCase.RequestValues, R extends UseCase.ResponseValue>
  void execute(UseCase<Q, R> useCase, Q requestValues, UseCase.UseCaseCallback<R> callback);
}