package edu.kirkley.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

public class CountMapUnitTests {

	private static final Long ZERO = 0L;
	
	@Test
	public void isAnInstanceOfDefaultValueMap() {
		CountMap<String> countMap = new CountMap<String>();
		
		assertTrue(countMap instanceof DefaultValueMap);
	}
	
	@Test
	public void countMapReturnsZeroIfKeyDNE() {
		String doesNotExistKey = randomString();
		
		CountMap<String> countMap = new CountMap<String>();
		
		assertFalse(countMap.containsKey(doesNotExistKey));
		assertEquals(ZERO, countMap.get(doesNotExistKey));
	}
	
	@Test
	public void countAddsAddendToValue() {
		Long expected = 100L;
		String key = randomString();
		CountMap<String> countMap = new CountMap<>();
		
		assertFalse(countMap.containsKey(key));
		countMap.add(key, expected);
		
		assertEquals(expected, countMap.get(key));
		
		Long addend = 1000L;
		expected = expected + addend;
		
		countMap.add(key, addend);
		assertEquals(expected, countMap.get(key));
	}
	
	private String randomString() {
		return UUID.randomUUID().toString();
	}
	
}
