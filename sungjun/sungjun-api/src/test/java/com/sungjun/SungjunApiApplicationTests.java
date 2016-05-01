package com.sungjun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sungjun.configuration.SungjunApiApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SungjunApiApplication.class)
@WebAppConfiguration
public class SungjunApiApplicationTests {

	@Test
	public void contextLoads() {
	}

}
