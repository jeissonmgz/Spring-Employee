package com.jeissonmgz.employee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class EmployeeApplicationTests {

    @Test
    void contextLoads() {
	assertThat(true).isTrue();
    }

}
