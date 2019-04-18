package com.library.data;

import java.util.List;

public interface ResourceLoader<T> {

    /**
     * Parse all the data into the resource loader generic type.
     * @return the list of the parsed data
     */
    List<T> loadData();

}
