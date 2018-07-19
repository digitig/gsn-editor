package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.terminology.Category;
import model.terminology.ExpressionElement;
import model.terminology.TerminologyAsset;

class ExpressionElementTest extends TerminologyAsset {
	class ConcreteExpressionElement extends ExpressionElement {
		
	}
	ExpressionElement expressionElement;
	PropertyChangeListener listener;
	
	@BeforeEach
	void setUp() throws Exception {
		expressionElement = new ConcreteExpressionElement();
		listener = mock(PropertyChangeListener.class);
	}

	@Test
	void testExpressionElement() {
		assertTrue(expressionElement.getValue().isEmpty());
		assertTrue(expressionElement.getCategory().isEmpty());
	}

	@Test
	void testSetValue() {
		expressionElement.addPropertyChangeListener("value", listener);
		String expected = "Expected";
		expressionElement.setValue(expected);
		assertEquals(expected, expressionElement.getValue());
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testAddCategory() {
		expressionElement.addPropertyChangeListener("category", listener);
		Category expected = mock(Category.class);
		expressionElement.addCategory(expected);
		assertTrue(expressionElement.getCategory().contains(expected));
		verify(listener).propertyChange(any(PropertyChangeEvent.class));		
	}

	@Test
	void testRemoveCategory() {
		expressionElement.addPropertyChangeListener("category", listener);
		Category expected = mock(Category.class);
		expressionElement.addCategory(expected);
		expressionElement.removeCategory(expected);
		assertFalse(expressionElement.getCategory().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));		
	}

	@Test
	void testClearCategory() {
		expressionElement.addPropertyChangeListener(listener);
		Category expected = mock(Category.class);
		expressionElement.addCategory(expected);
		expressionElement.clearCategory();
		assertFalse(expressionElement.getCategory().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));		
	}

}
