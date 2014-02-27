collections-extra
===================

Collections and collections utilities I have written

DefaultValueMap
---------------

DefaultValueMap is a class that extends java.util.HashMap that, when a key does not exist
will return a default value that is provided during construction through a DefaultValueCreator.

For example
```java
  DefaultValueCreator<Long> zeroLongCreator = new DefaultValueCreator<Long>() {
    public Long create() {
      return 0L;
    }
  };
  DefaultValueMap<String, Long> defaultToZeroMap = new DefaultValueMap<String, Long>(zeroLongCreator);
  
  assertEquals((Long)0L,defaultToZeroMap.get("key_that_does_not_exist"));
```

CountMap
--------

CountMap is a subclass of DefaultValueMap which uses the default value of 0L. CountMap provides a
method .add(K key, Long addend) that will add the addend to the value specified at key.

For example
```java
  CountMap<String> countMap = new CountMap<String>();
  
  assertEquals((Long)0L, countMap.get("key_does_not_exist"));
  countMap.add("key_does_not_exist",100L);
  assertEquals((Long)100L,countMap.get("key_does_not_exist"));
```
