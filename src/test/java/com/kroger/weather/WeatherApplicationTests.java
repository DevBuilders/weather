package com.kroger.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("unittest")
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApplicationTests
{
	@Test
	public void contextLoads()
	{
	}
}
