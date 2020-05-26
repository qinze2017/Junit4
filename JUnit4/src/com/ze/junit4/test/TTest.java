package com.ze.junit4.test;

// use static methods, Assert is a Class
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.ze.junit4.T;

public class TTest {
	
	// construct environment for example DB connection build 
	@BeforeClass
	public static void beforeClass() {
		System.out.println("BeforeClass");
	}
	
	//DB connection close 
	@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass");
	}
	
	@Before
	public void before() {
		System.out.println("Before");
	}

	// keeps the bar green, to keeps the code clean
	@Test
	public void testAdd() {
		//fail("Not yet implemented");
		double d = 2.8;
		int n = 8;
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("k", "v");
		List<String> list= Arrays.asList("a","b","d","e");
		int z = new T().add(5, 3);
		
	    /*assertEquals(8, z);
	    assertTrue(z > 3);
	    assertTrue("z could not more than 8", z > 10);*/
		assertThat(z, is(8));
		assertThat(z, allOf(greaterThan(5), lessThan(10)));
		assertThat(z, anyOf(greaterThan(5), lessThan(10)));
		assertThat(z,anything());
		assertThat(z, equalTo(n));
		
		assertThat(d, closeTo(3.0, 0.3));
		assertThat(d, greaterThan(2.0));
		assertThat(d, lessThan(10.0));
		assertThat(d, greaterThanOrEqualTo(2.1));
		assertThat(d, lessThanOrEqualTo(10.4));
		
		assertThat(map, hasEntry("k","v"));
		assertThat(list, hasItem("e"));
		assertThat(map, hasKey("k"));
		assertThat(map, hasValue("v"));
	}
	
	@Test
	public void testConcat() {

		String s = new T().concat("abc", "def");
		
		assertThat(s, is("abc def"));
		assertThat(s, not("abc"));
		
		assertThat(s, containsString("def"));
		assertThat(s,endsWith("ef"));
		assertThat(s,startsWith("ab"));

		assertThat(s, equalToIgnoringCase("ABc DEf"));
		assertThat(s, equalToIgnoringWhiteSpace(" abc  def "));
	}
	
	@Ignore
	@Test(expected=java.lang.ArithmeticException.class, timeout=100)
	public void testDivide() {
		
		int r = new T().divide(8, 2);
		//expected
		int w = new T().divide(8, 0);
		
		assertThat(r, is(4));
	}
	
	@After
	public void after() {
		System.out.println("After");
	}

}

