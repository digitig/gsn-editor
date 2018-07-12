package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.terminology.TerminologyPackage;
import model.terminology.TerminologyPackageCitation;
import static org.mockito.Mockito.*
;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Optional;class TerminologyPackageCitationTest {

	
	TerminologyPackageCitation terminologyPackageCitation;
	PropertyChangeListener listener;

	@BeforeEach
	void setUp() throws Exception {
		terminologyPackageCitation = new TerminologyPackageCitation();
		listener = mock(PropertyChangeListener.class);
	}

	@Test
	void testTerminologyPackageCitation() {
		assertFalse(terminologyPackageCitation.getCitedElement().isPresent());
	}

	@Test
	void testSetCitedPackage() {
		terminologyPackageCitation.addPropertyChangeListener(listener);
		TerminologyPackage terminologyPackage = mock(TerminologyPackage.class);
		terminologyPackageCitation.setCitedPackage(terminologyPackage);
		assertEquals(Optional.of(terminologyPackage), terminologyPackageCitation.getCitedPackage());
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

}
