package com.jigaspace;

import com.jigaspace.infrastructure.common.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JigaspaceApp.class)
@WebAppConfiguration
@ActiveProfiles(Constants.SPRING_PROFILE_TEST)
@PropertySource("classpath:application-test.properties")
public class JigaspaceAppTests {

	@Test
	public void contextLoads() {
	}

}
