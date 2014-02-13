package edu.kirkley.collections;

import java.util.HashMap;

import edu.kirkley.collections.creator.DefaultValueCreator;

public class DefaultValueMap<K, V> extends HashMap<K, V> {

	private static final long serialVersionUID = 1L;

	private DefaultValueCreator<V> defaultValue;

	public DefaultValueMap(DefaultValueCreator<V> defaultValue) {
		super();
		this.defaultValue = defaultValue;
	}

	@Override
	public boolean containsKey(Object key) {
		return super.get(key) != null;
	}
	
	@SuppressWarnings("unchecked")
	public V get(Object key) {
		V value = super.get(key);
		if (value == null) {
			V newValue = this.defaultValue.create();
			put((K) key, newValue);
			return newValue;
		} else {
			return super.get(key);
		}
	}

	public V put(K key, V value) {
		if (value == null) {
			value = defaultValue.create();
		}
		return super.put(key, value);
	}

}