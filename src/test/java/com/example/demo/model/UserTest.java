package com.example.demo.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTest {

	@Test
	public void getAndSets() {
		User user = User.builder().id(1).name("brad").email("blv.moon@gmail.com").phone("309-319-6299").username("bradmoon")
				.website("http://google.com").build();
		assertEquals("brad", user.getName());
		assertEquals(1, user.getId());
		System.out.println(user);
	}

}
