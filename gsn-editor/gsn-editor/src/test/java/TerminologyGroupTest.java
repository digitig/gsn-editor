package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.terminology.TerminologyElement;
import model.terminology.TerminologyGroup;

class TerminologyGroupTest {
	TerminologyGroup terminologyGroup;
	PropertyChangeListener listener;

	@BeforeEach
	void setUp() throws Exception {
		terminologyGroup = new TerminologyGroup();
		listener = mock(PropertyChangeListener.class);
	}

	@Test
	void testTerminologyGroup() {
		assertTrue(terminologyGroup.getTerminologyElement().isEmpty());
	}

	@Test
	void testAddTerminologyElement() {
		terminologyGroup.addPropertyChangeListener("terminologyElement", listener);
		TerminologyElement expected = mock(TerminologyElement.class);
		terminologyGroup.addTerminologyElement(expected);
		assertTrue(terminologyGroup.getTerminologyElement().contains(expected));
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test()
	void testAddNullTerminologyElement() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			terminologyGroup.addTerminologyElement(null);
		});
	}

	@Test
	void testRemoveTerminologyElement() {
		terminologyGroup.addPropertyChangeListener("terminologyElement", listener);
		TerminologyElement expected = mock(TerminologyElement.class);
		terminologyGroup.addTerminologyElement(expected);
		terminologyGroup.removeTerminologyElement(expected);
		assertFalse(terminologyGroup.getTerminologyElement().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testNullRemoveTerminologyElement() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			terminologyGroup.removeTerminologyElement(null);
		});
	}


	@Test
	void testClearTerminologyElement() {
		terminologyGroup.addPropertyChangeListener("terminologyElement", listener);
		TerminologyElement expected = mock(TerminologyElement.class);
		terminologyGroup.addTerminologyElement(expected);
		terminologyGroup.clearTerminologyElement();
		assertFalse(terminologyGroup.getTerminologyElement().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}

}
