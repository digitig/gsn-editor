package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.base.ModelElement;
import model.base.SacmElement;

class TestSacmElement {
	SacmElement sacmElement;

	@BeforeEach
	void setUp() throws Exception {
		sacmElement = new SacmElement();
	}

	@Test
	void testGidUnique() {
		SacmElement element2 = new SacmElement();
		assertNotEquals(element2.getGid(), sacmElement.getGid());
	}
	
	@Test
	void testChangeIsCitation() {
		assertFalse(sacmElement.getIsCitation());
		sacmElement.setIsCitation(true);
		assertTrue(sacmElement.getIsCitation());
		sacmElement.setIsCitation(false);
		assertFalse(sacmElement.getIsCitation());
	}
	
	@Test
	void testChangeIsAbstract() {
		assertFalse(sacmElement.getIsAbstract());
		sacmElement.setIsAbstract(true);
		assertTrue(sacmElement.getIsAbstract());
		sacmElement.setIsAbstract(false);
		assertFalse(sacmElement.getIsAbstract());		
	}

	@Test 
	void testChangeCitedElement() {
		assertFalse(sacmElement.getCitedElement().isPresent());
		Optional<SacmElement> optionalCitedElement = Optional.of(sacmElement);
		sacmElement.setCitedElement(optionalCitedElement);
		assertEquals(optionalCitedElement, sacmElement.getCitedElement());
		SacmElement citedElement = null;
		sacmElement.setCitedElement(citedElement);
		assertFalse(sacmElement.getCitedElement().isPresent());
	}
	
	@Test
	void testChangeAbstractForm() {
		assertFalse(sacmElement.getAbstractForm().isPresent());
		Optional<SacmElement> optionalAbstractForm = Optional.of(sacmElement);
		sacmElement.setAbstractForm(optionalAbstractForm);
		assertEquals(optionalAbstractForm, sacmElement.getAbstractForm());
		SacmElement abstractForm = null;
		sacmElement.setAbstractForm(abstractForm);
		assertFalse(sacmElement.getAbstractForm().isPresent());		
	}
	
	@Test
	@DisplayName("If citedElement is populated, isCitation must be true.")
	void testCitedElementConsistent() {
		sacmElement.setCitedElement(sacmElement);
		assertTrue(sacmElement.getErrors().contains(SacmElement.INCONSISTENT_IS_CITATION_ERROR));
		sacmElement.setIsCitation(true);
		assertFalse(sacmElement.getErrors().contains(SacmElement.INCONSISTENT_IS_CITATION_ERROR));
	}
	
	@Test
	@DisplayName("When +abstractForm is used to refer to another SACMElement, +isAbstract of the SACMElement is false")
	void testAbstractFormConsistent() {
		sacmElement.setIsAbstract(true);
		sacmElement.setAbstractForm(sacmElement);
		assertTrue(sacmElement.getErrors().contains(SacmElement.INCONSISTENT_IS_ABSTRACT_ERROR));
		sacmElement.setIsAbstract(false);
		assertFalse(sacmElement.getErrors().contains(SacmElement.INCONSISTENT_IS_ABSTRACT_ERROR));
	}
	
	@Test
	@DisplayName("When +abstractForm is used to refer to another SACMElement, the referred SACMElement should be of the same type of the SACMElement")
	void testAbstractFormTypeConsistent() {
		ModelElement modelElement = new ModelElement();
		sacmElement.setAbstractForm(modelElement);
		assertTrue(sacmElement.getErrors().contains(SacmElement.INCONSISTENT_ABSTRACT_FORM_TYPE_ERROR));
	}
	// TODO Test "If ImplementationConstraints are expressed on the referred SACMElement, the SACMElement should satisfy these ImplementationConstraints."
}
