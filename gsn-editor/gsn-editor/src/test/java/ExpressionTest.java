package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.terminology.Expression;
import model.terminology.ExpressionElement;

class ExpressionTest {
	Expression expression;
	PropertyChangeListener listener;

	@BeforeEach
	void setUp() throws Exception {
		expression = new Expression();
		listener = mock(PropertyChangeListener.class);
	}

	@Test
	void testExpression() {
		assertTrue(expression.getElement().isEmpty());
	}

	@Test
	void testSetElement() {
		ExpressionElement expected = mock(ExpressionElement.class);
		expression.addPropertyChangeListener("element", listener);
		expression.addElement(expected);
		assertTrue(expression.getElement().contains(expected));
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testRemoveElement() {
		ExpressionElement expected = mock(ExpressionElement.class);
		expression.addPropertyChangeListener(listener);
		expression.addElement(expected);
		expression.removeElement(expected);
		assertFalse(expression.getElement().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testClearElement() {
		ExpressionElement expected = mock(ExpressionElement.class);
		expression.addPropertyChangeListener(listener);
		expression.addElement(expected);
		expression.clearElement();
		assertFalse(expression.getElement().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}

}
