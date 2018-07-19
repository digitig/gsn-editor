package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.terminology.TerminologyPackage;

class TerminologyPackageTest {
	TerminologyPackage terminologyPackage;
	PropertyChangeListener listener;

	@BeforeEach
	void setUp() throws Exception {
		terminologyPackage = new TerminologyPackage();
		listener = mock(PropertyChangeListener.class);
	}

	@Test
	void testAddTerminologyPackage() {
		terminologyPackage.addPropertyChangeListener("terminologyPackage", listener);
		TerminologyPackage expected = mock(TerminologyPackage.class);
		terminologyPackage.addTerminologyPackage(expected);
		assertTrue(terminologyPackage.getTerminologyPackage().contains(expected));
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testNullAddTerminologyPackage() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			terminologyPackage.addTerminologyPackage(null);
		});
	}

	@Test
	void testRemoveTerminologyPackage() {
		terminologyPackage.addPropertyChangeListener("terminologyPackage", listener);
		TerminologyPackage expected = mock(TerminologyPackage.class);
		terminologyPackage.addTerminologyPackage(expected);
		terminologyPackage.removeTerminologyPackage(expected);
		assertFalse(terminologyPackage.getTerminologyPackage().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testRemoveNullTerminologyPackage() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			terminologyPackage.addTerminologyPackage(null);
		});
	}

	@Test
	void testClearTerminologyPackage() {
		terminologyPackage.addPropertyChangeListener("terminologyPackage", listener);
		TerminologyPackage expected = mock(TerminologyPackage.class);
		terminologyPackage.addTerminologyPackage(expected);
		terminologyPackage.clearTerminologyPackage();
		assertFalse(terminologyPackage.getTerminologyPackage().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}
}
