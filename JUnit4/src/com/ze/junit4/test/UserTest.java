package com.ze.junit4.test;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.Matchers.*;

import com.ze.junit4.User;

//TDD : test driven development
public class UserTest {

	@Test
	public void testGetName() {
		//fail("Not yet implemented");
		assertThat(new User(), is("ze"));
	}

}
