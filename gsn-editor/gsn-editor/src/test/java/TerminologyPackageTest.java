package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.terminology.TerminologyAsset;
import model.terminology.TerminologyPackage;
import model.terminology.TerminologyPackageCitation;

class TerminologyPackageTest {
	TerminologyPackage terminologyPackage;
	PropertyChangeListener listener;

	@BeforeEach
	void setUp() throws Exception {
		terminologyPackage = new TerminologyPackage();
		listener = mock(PropertyChangeListener.class);
	}

	@Test
	void testTerminologyPackage() {
		assertTrue(terminologyPackage.getTerminologyAsset().isEmpty());
		assertTrue(terminologyPackage.getTerminologyPackage().isEmpty());
		assertTrue(terminologyPackage.getTerminologyPackageCitation().isEmpty());
	}

	@Test
	void testAddTerminologyAsset() {
		terminologyPackage.addPropertyChangeListener("terminologyAsset", listener);
		TerminologyAsset expected = mock(TerminologyAsset.class);
		terminologyPackage.addTerminologyAsset(expected);
		assertTrue(terminologyPackage.getTerminologyAsset().contains(expected));
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test()
	void testAddNullTerminologyAsset() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			terminologyPackage.addTerminologyAsset(null);
		});
	}

	@Test
	void testRemoveTerminologyAsset() {
		terminologyPackage.addPropertyChangeListener("terminologyAsset", listener);
		TerminologyAsset expected = mock(TerminologyAsset.class);
		terminologyPackage.addTerminologyAsset(expected);
		terminologyPackage.removeTerminologyAsset(expected);
		assertFalse(terminologyPackage.getTerminologyAsset().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testNullRemoveTerminologyAsset() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			terminologyPackage.removeTerminologyAsset(null);
		});
	}

	@Test
	void testClearTerminologyAsset() {
		terminologyPackage.addPropertyChangeListener("terminologyAsset", listener);
		TerminologyAsset expected = mock(TerminologyAsset.class);
		terminologyPackage.addTerminologyAsset(expected);
		terminologyPackage.clearTerminologyAsset();
		assertFalse(terminologyPackage.getTerminologyAsset().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testAddTerminologyPackageCitation() {
		terminologyPackage.addPropertyChangeListener("terminologyPackageCitation", listener);
		TerminologyPackageCitation expected = mock(TerminologyPackageCitation.class);
		terminologyPackage.addTerminologyPackageCitation(expected);
		assertTrue(terminologyPackage.getTerminologyPackageCitation().contains(expected));
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testAddNullTerminologyPackageCitation() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			terminologyPackage.addTerminologyPackageCitation(null);
		});
	}

	@Test
	void testRemoveTerminologyPackageCitation() {
		terminologyPackage.addPropertyChangeListener("terminologyPackageCitation", listener);
		TerminologyPackageCitation expected = mock(TerminologyPackageCitation.class);
		terminologyPackage.addTerminologyPackageCitation(expected);
		terminologyPackage.removeTerminologyPackageCitation(expected);
		assertFalse(terminologyPackage.getTerminologyPackageCitation().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testRemoveNullTerminologyPackageCitation() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			terminologyPackage.addTerminologyPackageCitation(null);
		});
	}

	@Test
	void testClearTerminologyPackageCitation() {
		terminologyPackage.addPropertyChangeListener("terminologyPackageCitation", listener);
		TerminologyPackageCitation expected = mock(TerminologyPackageCitation.class);
		terminologyPackage.addTerminologyPackageCitation(expected);
		terminologyPackage.clearTerminologyPackageCitation();
		;
		assertFalse(terminologyPackage.getTerminologyPackageCitation().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
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
