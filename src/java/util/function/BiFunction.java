/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package java.util.function;

import java.util.Objects;

/**
 * 接收两个参数返回一个结果的函数
 *
 * @param <T> 参数T
 * @param <U> 参数U
 * @param <R> 返回值R
 *
 * @see Function
 * @since 1.8
 */
@FunctionalInterface
public interface BiFunction<T, U, R> {

    /**
     * 执行函数
     *
     * @param t 参数T
     * @param u 数U
     * @return  反回值R
     */
    R apply(T t, U u);

    default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.apply(apply(t, u));
    }
}
