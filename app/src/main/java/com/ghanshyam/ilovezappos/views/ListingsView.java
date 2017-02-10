package com.ghanshyam.ilovezappos.views;

/**
 * Created by GHANSHYAM on 06-Feb-17.
 */

public interface ListingsView<T>
{
    void addItem(T item);

    void addItems(T[] items);

    void clearItems();

}
