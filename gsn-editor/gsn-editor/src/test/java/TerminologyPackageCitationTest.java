package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.terminology.TerminologyPackage;
import model.terminology.TerminologyPackageCitation;
import static org.mockito.Mockito.*
;

import java.util.Optional;class TerminologyPackageCitationTest {

	
	TerminologyPackageCitation terminologyPackageCitation; 

	@BeforeEach
	void setUp() throws Exception {
		terminologyPackageCitation = new TerminologyPackageCitation();
	}

	@Test
	void testTerminologyPackageCitation() {
		assertFalse(terminologyPackageCitation.getCitedElement().isPresent());
	}

	@Test
	void testSetCitedPackage() {
		TerminologyPackage terminologyPackage = mock(TerminologyPackage.class);
		terminologyPackageCitation.setCitedPackage(terminologyPackage);
		assertEquals(Optional.of(terminologyPackage), terminologyPackageCitation.getCitedPackage());
	}

}
