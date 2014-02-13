package edu.kirkley.collections;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.HashMap;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import edu.kirkley.collections.creator.DefaultValueCreator;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultValueMapUnitTests {

	private static final String DEFAULT_STRING = "default_string";

	@Mock
	private DefaultValueCreator<String> mockDefaultValueCreator;

	@Before
	public void setup() {
		when(mockDefaultValueCreator.create()).thenReturn(DEFAULT_STRING);
	}

	@Test
	public void isInstanceOfHashMap() {
		@SuppressWarnings("unchecked")
		DefaultValueMap<Object, Object> mock = mock(DefaultValueMap.class);
		assertTrue(mock instanceof HashMap);
	}

	@Test
	public void getReturnsDefaultValueIfKeyDNE() {
		DefaultValueMap<String, String> defaultValueMap = new DefaultValueMap<String, String>(
				mockDefaultValueCreator);
		String key = "key_does_not_exist";

		assertEquals(0, defaultValueMap.size());
		String result = defaultValueMap.get(key);
		assertNotNull(result);
		assertEquals(DEFAULT_STRING, result);
	}

	@Test
	public void putPutsValueAndgetReturnsValueIfKeyExists() {
		DefaultValueMap<String, String> defaultValueMap = new DefaultValueMap<String, String>(
				mockDefaultValueCreator);
		String key = "key_exists";

		assertEquals(0, defaultValueMap.size());

		String expected = randomString();
		defaultValueMap.put(key, expected);

		String result = defaultValueMap.get(key);
		assertNotNull(result);
		assertEquals(expected, result);
	}

	private String randomString() {
		return UUID.randomUUID().toString();
	}
}
