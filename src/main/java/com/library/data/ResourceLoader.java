package com.library.data;

import java.util.List;

public interface ResourceLoader<T> {
	
	List<T> loadData();
	
}
