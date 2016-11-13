package mbc.sdos.es.mbc.domain.usecase.base;

/**
 * Use cases are the entry points to the domain layer.
 *
 * @param <Q> the request type
 * @param <R> the response type
 */
public abstract class UseCase<Q extends UseCase.RequestValues, R extends UseCase.ResponseValue> {

    public abstract void executeUseCase(Q requestValues, UseCaseCallback<R> callback);

    /**
     * Data passed to a request.
     */
    public interface RequestValues {
    }

    /**
     * Data received from a request.
     */
    public interface ResponseValue {
    }

    public interface UseCaseCallback<R> {
        void onSuccess(R response);

        void onError();
    }
}