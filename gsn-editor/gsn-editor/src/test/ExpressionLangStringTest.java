package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.base.ExpressionLangString;
import model.terminology.ExpressionElement;

class ExpressionLangStringTest {
	ExpressionLangString expressionLangString;
	ExpressionElement expressionElement;

	@BeforeEach
	void setUp() throws Exception {
		expressionElement = mock(ExpressionElement.class);
		expressionLangString = new ExpressionLangString(expressionElement);
	}

	@Test
	void testExpressionLangString() {
		assertEquals(expressionElement, expressionLangString.getElement());
	}

	@Test
	void testSetElement() {
		ExpressionElement expected = mock(ExpressionElement.class);
		expressionLangString.setElement(expected);
		assertEquals(expected, expressionLangString.getElement());
	}

}
