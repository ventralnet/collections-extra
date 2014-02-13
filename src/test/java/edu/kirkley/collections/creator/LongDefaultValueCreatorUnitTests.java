package edu.kirkley.collections.creator;

import java.util.Random;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LongDefaultValueCreatorUnitTests {

	@Test
	public void createReturnsValueProvidedInConstructor() {
		Long expected = randomLong();
		
		LongDefaultValueCreator creator = new LongDefaultValueCreator(expected);
		
		assertEquals(expected,creator.create());
	}
	
	private long randomLong() {
		return new Random().nextLong();
	}
	
}
