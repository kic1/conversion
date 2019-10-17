package com.example.conversion.config;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LogbackTest {
	
	@Test
	public void t1_log() {
		log.error("logback-config test error");
		log.warn ("logback-config test warn");
		log.info ("logback-config test info");
		log.debug("logback-config test debug");
		log.trace("logback-config test trace - NOT APPEAR AS EXPECTED");
	}
}
