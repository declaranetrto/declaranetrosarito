package mx.gob.sfp.dgti.graphql.queryExecutor;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.util.concurrent.CompletableFuture;

/**
 *
 * https://gist.github.com/purplefox/1a1d8dfddd04a2b2733c2062fb9fbbba
 *
 */
public class AsyncResCF<T> extends CompletableFuture<T> implements Handler<AsyncResult<T>> {

    @Override
    public void handle(AsyncResult<T> ar) {
        if (ar.succeeded()) {
            complete(ar.result());
        } else {
            completeExceptionally(ar.cause());
        }
    }

}