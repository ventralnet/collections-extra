package edu.kirkley.collections;

import edu.kirkley.collections.creator.DefaultValueCreator;


public class CountMap<K> extends DefaultValueMap<K, Long> {
	private static final long serialVersionUID = 1L;

	private static final DefaultValueCreator<Long> ZERO = new DefaultValueCreator<Long>() {
		public Long create() {
			return 0L;
		}
	};

	public CountMap() {
		super(ZERO);
	}

	public void add(K key, long addend) {
		put(key, get(key) + addend);
	}
}
