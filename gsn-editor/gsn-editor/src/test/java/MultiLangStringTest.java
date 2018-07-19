package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.base.LangString;
import model.base.MultiLangString;

class MultiLangStringTest {
	MultiLangString multiLangString;

	@BeforeEach
	void setUp() throws Exception {
		multiLangString = new MultiLangString();
	}

	@Test
	void testMultiLangString() {
		assertTrue(multiLangString.getValue().isEmpty());
	}

	@Test
	void testGetValueString() {
		String language = "lang";
		String content = "content";
		multiLangString.addLangString(language, content);
		assertEquals(content, multiLangString.getValue().get(language));
	}

	@Test
	void testAddLangStringLangString() {
		String language = "lang";
		String content = "content";
		LangString langString = new LangString();
		langString.setLang(language);
		langString.setContent(content);
		multiLangString.addLangString(langString);
 	}
}
