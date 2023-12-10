package com.example.day3a;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.BufferedReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureWebMvc
class Day3AApplicationTests {

	@MockBean
	Solver solver;

	@Captor
	ArgumentCaptor<BufferedReader> captor;

	@Test
	void contextLoads() {
	}

	@Test
	void run() throws Exception {
		Day3AApplication underTest = new Day3AApplication(solver);
		when(solver.solve(captor.capture())).thenReturn(7);

		underTest.run(null);

		assertThat(captor.getValue()).isNotNull();
	}

}
