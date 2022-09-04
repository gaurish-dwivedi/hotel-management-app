package com.hotel.management;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HotelManagementApplicationTests {

	@Test
	void contextLoads() {

		boolean actual = true;

		assertEquals(true, actual);
	}
	
	  @Test
	   public void main() {
	      HotelManagementApplication.main(new String[] {});
	   }

}
