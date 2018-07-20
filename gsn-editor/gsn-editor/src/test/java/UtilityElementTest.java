package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.base.MultiLangString;
import model.base.UtilityElement;

class UtilityElementTest {
	class ConcreteUtilityElement extends UtilityElement {
		
	}
	UtilityElement utilityElement;
	PropertyChangeListener listener;

	@BeforeEach
	void setUp() throws Exception {
		utilityElement = new ConcreteUtilityElement();
		listener = mock(PropertyChangeListener.class);
	}

	@Test
	void testUtilityElement() {
		assertFalse(utilityElement.getContent().isPresent());
	}

	@Test
	void testSetContent() {
		MultiLangString expected = mock(MultiLangString.class);
		utilityElement.addPropertyChangeListener(listener);
		utilityElement.setContent(Optional.of(expected));
		assertEquals(expected, utilityElement.getContent().get());
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

}
