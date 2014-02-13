package edu.kirkley.collections.creator;


public class LongDefaultValueCreator implements DefaultValueCreator<Long> {
    long defaultValue;

    public LongDefaultValueCreator(long defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Long create() {
        return defaultValue;
    }
}
