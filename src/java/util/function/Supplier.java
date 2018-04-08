/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * 接受一个泛型<T>, 接口方法是一个无参数的方法, 有一个类型为T的返回值.
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * 返回一个值
     */
    T get();
}
