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
 * Represents a predicate (boolean-valued function) of one argument.
 *
 * 用于判定值是否满足条件
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #test(Object)}.
 *
 * @param <T> the type of the input to the predicate
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Predicate<T> {

    /**
     *
     * 判定给定的值是否符合定义的条件
     *
     * @param t   输入变量
     * @return 如果t符合predicate条件，则返回true,否则返回false
     */
    boolean test(T t);

    /**
     * and 条件
     * @return 返回包含other条件的Predicate对象
     * @throws NullPointerException  若{null == other}， 则抛出空异常
     */
    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }

    /**
     * 取反操作
     * @return 返回与之前条件相反的Predicate对象
     */
    default Predicate<T> negate() {
        return (t) -> !test(t);
    }

    /**
     * or 条件
     * @return 返回包含other条件的Predicate对象
     * @throws NullPointerException  若{null == other}， 则抛出空异常
     */
    default Predicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }

    /**
     * 返回根据{@link Objects#equals(Object, Object)}方法判断两对象是否相等的Predicate对象
     *
     * @param <T> Predicate对象泛型参数类型
     * @param targetRef 入参
     * @return 返回判断两对象是否相等的Predicate对象
     */
    static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }
}
