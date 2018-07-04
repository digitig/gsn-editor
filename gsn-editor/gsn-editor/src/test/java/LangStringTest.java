package test.java;

import static org.junit.jupiter.api.Assertions.*;

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
	void defaultConstructorTest() {
		assertFalse(langString.getLang().isPresent());
		assertFalse(langString.getContent().isPresent());
	}
	
	@Test
	void setLangTest() {
		String expected = "Test";
		langString.setLang(expected);
		assertTrue(langString.getLang().isPresent());
		assertEquals(expected, langString.getLang().get());
	}
	
	@Test
	void setContentTest() {
		String expected = "test";
		langString.setContent(expected);
		assertTrue(langString.getContent().isPresent());
		assertEquals(expected, langString.getContent().get());
	}

}
