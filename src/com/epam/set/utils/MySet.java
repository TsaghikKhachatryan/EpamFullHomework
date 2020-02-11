package com.epam.set.utils;

import com.epam.set.interfaces.Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * MySet is a  collection that contains
 * no duplicate elements.
 *
 * @author Tsaghik Khachatryan
 * @version 1.0
 * @since 2020-05-02
 */
public class MySet<T extends Comparable> implements Set<T>, Iterable {
    private ArrayList<T> arrayList;

    public MySet() {
        arrayList = new ArrayList<>();
    }

    /**
     * @return the number of elements in this set
     */
    @Override
    public int getSize() {
        return arrayList.size();
    }

    /**
     * Adds the specified element to this set
     * if it is not already present
     *
     * @param item - element to be added to this set
     * @return true if this set did not already contain the specified element
     * @throws NullPointerException - if the specified element is null
     */
    @Override
    public boolean add(T item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (arrayList.contains(item)) {
            return false;
        } else {
            arrayList.add(item);
            Collections.sort(arrayList);
            return true;
        }
    }

    /**
     * Removes the specified element
     * from this set if it is present
     *
     * @param item - object to be removed from this set, if present
     * @return true if this set contained the specified element
     * @throws NullPointerException - if the specified element is null
     */
    @Override
    public boolean remove(T item) {
        if (item == null) {
            throw new NullPointerException();
        }
        return arrayList.remove(item);
    }

    /**
     * Returns true if this set contains the specified element.
     *
     * @param item- element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    @Override
    public boolean contains(T item) {
        return arrayList.contains(item);
    }

    /**
     * @return an iterator over the elements in this set.
     */
    @Override
    public Iterator iterator() {
        return new MySetIterator();
    }

    public class MySetIterator implements Iterator {
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < arrayList.size();
        }

        @Override
        public Object next() {
            T item = arrayList.get(currentIndex);
            ++currentIndex;
            return item;
        }
    }
}

