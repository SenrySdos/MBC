package mbc.sdos.es.mbc.domain.usecase.base;

/**
 * Runs {@link UseCase}s using a {@link UseCaseScheduler}.
 */
public class UseCaseHandler {

  private final UseCaseScheduler mUseCaseScheduler;

  public UseCaseHandler(UseCaseScheduler useCaseScheduler) {
    mUseCaseScheduler = useCaseScheduler;
  }

  public <T extends UseCase.RequestValues, R extends UseCase.ResponseValue> void execute(
      final UseCase<T, R> useCase,
      T values,
      UseCase.UseCaseCallback<R> callback) {

    if (useCase == null) {
      throw new IllegalArgumentException("Usecase can´t be null");
    } else {
      mUseCaseScheduler.execute(useCase, values, callback);
    }
  }
}