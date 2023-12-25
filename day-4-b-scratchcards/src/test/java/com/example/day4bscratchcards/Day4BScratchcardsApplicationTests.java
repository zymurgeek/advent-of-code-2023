package com.example.day4bscratchcards;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.day4bscratchcards.model.Card;

@SpringBootTest
class Day4BScratchcardsApplicationTests {

	@Mock
	InputParser parser;

	@Mock
	CardListAnalyzer analyzer;

	List<Card> list = List.of();

	@InjectMocks
	Day4BScratchcardsApplication underTest;

	@Test
	void contextLoads() {
	}

	@Test
	void run() throws Exception {
		Logger logger = (Logger) LoggerFactory.getLogger(Day4BScratchcardsApplication.class);
		ListAppender<ILoggingEvent> appender = new ListAppender<>();
		appender.start();
		logger.addAppender(appender);
		when(parser.parseLines(any(BufferedReader.class))).thenReturn(list);
		when(analyzer.sumCards(list)).thenReturn(7);

		underTest.run(Arrays.array(""));

		assertThat(appender.list.getFirst().getMessage()).isEqualTo("Total of all cards = 7");
		verify(analyzer).addWinningCards(list);
	}

}
