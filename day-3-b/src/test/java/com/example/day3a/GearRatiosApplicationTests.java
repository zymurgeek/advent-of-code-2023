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
class GearRatiosApplicationTests {

	@MockBean
	EngineSchematicAnalyzer engineSchematicAnalyzer;

	@Captor
	ArgumentCaptor<BufferedReader> captor;

	@Test
	void contextLoads() {
	}

	@Test
	void run() throws Exception {
		GearRatiosApplication underTest = new GearRatiosApplication(engineSchematicAnalyzer);
		when(engineSchematicAnalyzer.sumGearRatios(captor.capture())).thenReturn(7);

		underTest.run(null);

		assertThat(captor.getValue()).isNotNull();
	}

}
