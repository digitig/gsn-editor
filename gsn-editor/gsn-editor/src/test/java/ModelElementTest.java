package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.ValidationErrors;
import model.base.ModelElement;

class ModelElementTest {
	class ConcreteModelElement extends ModelElement {
		
	}
	
	class AlternateModelElement extends ModelElement {
		
	}
	
	ModelElement modelElement;
	PropertyChangeListener listener;
	
	@BeforeEach
	void setUp() throws Exception {
		modelElement = new ConcreteModelElement();
		listener = mock(PropertyChangeListener.class);
	}

	@Test
	void testGidUnique() {
		ModelElement element2 = new ConcreteModelElement();
		assertNotEquals(element2.getGid(), modelElement.getGid());
	}
	
	@Test
	void testChangeIsCitation() {
		modelElement.addPropertyChangeListener("isCitation", listener);
		assertFalse(modelElement.getIsCitation());
		modelElement.setIsCitation(true);
		assertTrue(modelElement.getIsCitation());
		modelElement.setIsCitation(false);
		assertFalse(modelElement.getIsCitation());
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}
	
	@Test
	void testChangeIsAbstract() {
		modelElement.addPropertyChangeListener("isAbstract", listener);
		assertFalse(modelElement.getIsAbstract());
		modelElement.setIsAbstract(true);
		assertTrue(modelElement.getIsAbstract());
		modelElement.setIsAbstract(false);
		assertFalse(modelElement.getIsAbstract());		
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test 
	void testChangeCitedElement() {
		modelElement.addPropertyChangeListener("citedElement", listener);
		assertFalse(modelElement.getCitedElement().isPresent());
		Optional<ModelElement> optionalCitedElement = Optional.of(modelElement);
		modelElement.setCitedElement(optionalCitedElement);
		assertEquals(optionalCitedElement, modelElement.getCitedElement());
		ModelElement citedElement = null;
		modelElement.setCitedElement(citedElement);
		assertFalse(modelElement.getCitedElement().isPresent());
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}
	
	@Test
	void testChangeAbstractForm() {
		modelElement.addPropertyChangeListener("abstractForm", listener);
		assertFalse(modelElement.getAbstractForm().isPresent());
		Optional<ModelElement> optionalAbstractForm = Optional.of(modelElement);
		modelElement.setAbstractForm(optionalAbstractForm);
		assertEquals(optionalAbstractForm, modelElement.getAbstractForm());
		ModelElement abstractForm = null;
		modelElement.setAbstractForm(abstractForm);
		assertFalse(modelElement.getAbstractForm().isPresent());		
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}
	
	@Test
	@DisplayName("If citedElement is populated, isCitation must be true.")
	void testCitedElementConsistent() {
		modelElement.setCitedElement(modelElement);
		assertTrue(modelElement.getErrors().contains(ValidationErrors.INCONSISTENT_IS_CITATION_ERROR));
		modelElement.setIsCitation(true);
		assertFalse(modelElement.getErrors().contains(ValidationErrors.INCONSISTENT_IS_CITATION_ERROR));
	}
	
	@Test
	@DisplayName("When +abstractForm is used to refer to another ModelElement, +isAbstract of the ModelElement is false")
	void testAbstractFormConsistent() {
		modelElement.setIsAbstract(true);
		modelElement.setAbstractForm(modelElement);
		assertTrue(modelElement.getErrors().contains(ValidationErrors.INCONSISTENT_IS_ABSTRACT_ERROR));
		modelElement.setIsAbstract(false);
		assertFalse(modelElement.getErrors().contains(ValidationErrors.INCONSISTENT_IS_ABSTRACT_ERROR));
	}
	
	@Test
	@DisplayName("When +abstractForm is used to refer to another ModelElement, the referred ModelElement should be of the same type of the ModelElement")
	void testAbstractFormTypeConsistent() {
		modelElement.setAbstractForm(new AlternateModelElement());
		assertTrue(modelElement.getErrors().contains(ValidationErrors.INCONSISTENT_ABSTRACT_FORM_TYPE_ERROR));
	}
	// TODO Test "If ImplementationConstraints are expressed on the referred ModelElement, the ModelElement should satisfy these ImplementationConstraints."
}
