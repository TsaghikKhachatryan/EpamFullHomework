package com.epam.set.interfaces;

/**
 * Set is an interface which stores
 * elements of any type in sorted order
 * @author Tsaghik Khachatryan
 * @version 1.0
 * @since 2020-05-02
 */
public interface Set<T extends Comparable> {
    int getSize();

    boolean add(T item);

    boolean remove(T item);

    boolean contains(T item);
}
