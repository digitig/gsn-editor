package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.base.LangString;

class LangStringTest {

	LangString langString;

	@BeforeEach
	void setUp() throws Exception {
		langString = new LangString();
	}

	@Test
	void testLangString() {
		assertFalse(langString.getLang().isPresent());
		assertFalse(langString.getContent().isPresent());
	}

	@Test
	void testSetLangString() {
		String expected = "Expected";
		langString.setLang(expected);
		assertTrue(langString.getLang().isPresent());
		assertEquals(expected, langString.getLang().get());
	}

	void testSetLangStringNull() {
		String expected = null;
		langString.setLang(expected);
		assertFalse(langString.getLang().isPresent());
	}

	@Test
	void testSetLangOptionalOfString() {
		Optional<String> expected = Optional.of("Expected");
		langString.setLang(expected);
		assertEquals(expected, langString.getLang());
	}

	@Test
	void testSetContentString() {
		String expected = "Expected";
		langString.setContent(expected);
		assertTrue(langString.getContent().isPresent());
		assertEquals(expected, langString.getContent().get());
	}

	@Test
	void testSetContentStringNull() {
		String expected = null;
		langString.setContent(expected);
		assertFalse(langString.getContent().isPresent());
	}

	@Test
	void testSetContentOptionalOfString() {
		Optional<String> expected = Optional.of("Expected");
		langString.setContent(expected);
		assertEquals(expected, langString.getContent());
	}

}
