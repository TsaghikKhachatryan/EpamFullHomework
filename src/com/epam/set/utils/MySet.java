package com.epam.set.utils;

import com.epam.set.interfaces.Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MySet<T extends Comparable> implements Set<T>, Iterable {
    private ArrayList<T> arrayList;

    public MySet() {
        arrayList = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return arrayList.size();
    }

    @Override
    public boolean add(T item) {
        if (arrayList.contains(item)) {
            return false;
        } else {
            arrayList.add(item);
            Collections.sort(arrayList);
            return true;
        }
    }

    @Override
    public boolean remove(T item) {
        return arrayList.remove(item);
    }

    @Override
    public boolean contains(T item) {
        return arrayList.contains(item);
    }

    @Override
    public Iterator iterator() {
        return new MySetIterator();
    }

    public class MySetIterator implements Iterator {
        T current;

        @Override
        public boolean hasNext() {
            return arrayList.indexOf(current) < arrayList.size() - 1;
        }

        @Override
        public Object next() {
            T item;
            if (current == null) {
                item = arrayList.get(0);
            } else {
                int index = arrayList.indexOf(current);
                item = arrayList.get(index + 1);
            }
            current = item;
            return item;
        }
    }
}

