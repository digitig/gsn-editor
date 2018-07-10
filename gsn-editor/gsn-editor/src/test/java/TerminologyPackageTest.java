package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

import model.terminology.TerminologyAsset;
import model.terminology.TerminologyPackage;
import model.terminology.TerminologyPackageCitation;

class TerminologyPackageTest {
	TerminologyPackage terminologyPackage;

	@BeforeEach
	void setUp() throws Exception {
		terminologyPackage = new TerminologyPackage();
	}

	@Test
	void testTerminologyPackage() {
		assertTrue(terminologyPackage.getTerminologyAsset().isEmpty());
		assertTrue(terminologyPackage.getTerminologyPackage().isEmpty());
		assertTrue(terminologyPackage.getTerminologyPackageCitation().isEmpty());
	}

	@Test
	void testSetTerminologyAsset() {
		TerminologyAsset expected = mock(TerminologyAsset.class);
		Set<TerminologyAsset> terminologyAssetSet = terminologyPackage.getTerminologyAsset();
		terminologyAssetSet.add(expected);
		terminologyPackage.setTerminologyAsset(terminologyAssetSet);
		assertTrue(terminologyPackage.getTerminologyAsset().contains(expected));
	}

	@Test
	void testSetTerminologyPackageCitation() {
		TerminologyPackageCitation expected = mock(TerminologyPackageCitation.class);
		Set<TerminologyPackageCitation> terminologyPackageCitation = terminologyPackage.getTerminologyPackageCitation();
		terminologyPackageCitation.add(expected);
		terminologyPackage.setTerminologyPackageCitation(terminologyPackageCitation);
		assertTrue(terminologyPackage.getTerminologyPackageCitation().contains(expected));
	}

	@Test
	void testSetTerminologyPackage() {
		TerminologyPackage expected = mock(TerminologyPackage.class);
		Set<TerminologyPackage> terminologyPackageSet = terminologyPackage.getTerminologyPackage();
		terminologyPackageSet.add(expected);
		terminologyPackage.setTerminologyPackage(terminologyPackageSet);
		assertTrue(terminologyPackage.getTerminologyPackage().contains(expected));
	}

}
