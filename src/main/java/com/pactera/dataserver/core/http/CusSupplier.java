package com.pactera.dataserver.core.http;

/**
 * d
 *
 * @author Pactera WangShuai
 * @date 2019/11/07 16:53
 */
@FunctionalInterface
public interface CusSupplier<E, X> {
    /**
     * Gets a result.
     *
     * @param error error
     * @param e     e
     * @return a result
     */
    X get(E error, Exception e);
}
