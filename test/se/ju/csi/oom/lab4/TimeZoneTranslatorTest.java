package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime dateTest = new DateTime(2018, 10, 9, 10, 0, 0);
		DateTime dateTestIKnow = new DateTime(2018, 10, 9, 14, 0, 0);
		
		dateTest = TimeZoneTranslator.shiftTimeZone(dateTest, 0, 4);

		System.out.println(String.format("First test:%s", dateTest.toString()));
		System.out.println(String.format("First test:%s", dateTestIKnow.toString()));
		
		
		assertEquals(dateTest.toString(), dateTestIKnow.toString());
		
		DateTime dateTest1 = new DateTime(2016, 1, 1, 6, 0, 0);
		String dateTestIKnow1 = "2015-12-31 20:00:00";
		
		dateTest1 = TimeZoneTranslator.shiftTimeZone(dateTest1, 0, -10);
		
		System.out.println(String.format("First test1:%s", dateTest1.toString()));
		System.out.println(String.format("First test1:%s", dateTestIKnow1.toString()));
		
		assertEquals(dateTest1.toString(), dateTestIKnow1);
		
	}

	@Test
	public void testShiftEventTimeZone() {
		DateTime eventTestStart = new DateTime(2018, 10 ,9, 10, 0, 0);
		DateTime eventTestEnd = new DateTime(2018, 10 ,9, 14, 0, 0);
		Person robert = new Person("Robert");
		Person mans = new Person("Mans");
		Place somewhere = new Place("somewhere", 0.0, 0.0, 0.0);
		
		Event firstTest = new Event("Test boi",
				eventTestStart,
				eventTestEnd,
				new HashSet<>(Arrays.asList(robert, mans)),
				somewhere);
		
		DateTime eventIKnowStart = new DateTime(2018, 10, 9, 14, 0, 0);
		DateTime eventIKnowEnd = new DateTime(2018, 10 ,9, 18, 0, 0);
		
		Event firstTestIKnow = new Event("Test boi",
				eventIKnowStart,
				eventIKnowEnd,
				new HashSet<>(Arrays.asList(robert, mans)),
				somewhere);
		
		firstTest = TimeZoneTranslator.shiftEventTimeZone(firstTest, TimeZone.GREENWICH_UTC, TimeZone.UNITED_ARAB_EMIRATES);
		
		System.out.println(String.format("Second test:%s", firstTest.toString()));
		System.out.println(String.format("Second test:%s", firstTestIKnow.toString()));
		
		assertEquals(firstTest.toString(), firstTestIKnow.toString());
		
		
		
	}

}
