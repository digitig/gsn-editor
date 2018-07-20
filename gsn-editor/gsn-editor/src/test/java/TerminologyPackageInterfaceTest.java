package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Test;

import model.terminology.TerminologyPackage;
import model.terminology.TerminologyPackageInterface;

class TerminologyPackageInterfaceTest {

	@Test
	void testTerminologyPackageInterface() {
		TerminologyPackage expected = mock(TerminologyPackage.class);
		TerminologyPackageInterface terminologyPackageInterface = new TerminologyPackageInterface(expected);
		assertEquals(expected, terminologyPackageInterface.getImplements());
	}

	@Test
	void testSetImplements() {
		PropertyChangeListener listener = mock(PropertyChangeListener.class);
		TerminologyPackage expected = mock(TerminologyPackage.class);
		TerminologyPackageInterface terminologyPackageInterface = new TerminologyPackageInterface(mock(TerminologyPackage.class));
		terminologyPackageInterface.addPropertyChangeListener("implements", listener);
		terminologyPackageInterface.setImplements(expected);
		assertEquals(expected, terminologyPackageInterface.getImplements());
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

}
