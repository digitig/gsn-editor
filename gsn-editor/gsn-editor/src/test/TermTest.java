package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.base.ModelElement;
import model.terminology.Term;

class TermTest {
	Term term;
	PropertyChangeListener listener;

	@BeforeEach
	void setUp() throws Exception {
		term = new Term();
		listener = mock(PropertyChangeListener.class);
	}

	@Test
	void testTerm() {
		assertFalse(term.getExternalReference().isPresent());
		assertFalse(term.getOrigin().isPresent());
	}

	@Test
	void testSetExternalReferenceOptionalOfString() {
		term.addPropertyChangeListener("externalReference", listener);
		Optional<String> expected = Optional.of("Expected");
		term.setExternalReference(expected);
		assertEquals(expected, term.getExternalReference());
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testSetExternalReferenceString() {
		term.addPropertyChangeListener(listener);
		String expected = "Expected";
		term.setExternalReference(expected);
		assertEquals(expected, term.getExternalReference().get());
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testSetOriginOptionalOfModelElement() {
		term.addPropertyChangeListener("origin", listener);
		Optional<ModelElement> expected = Optional.of(mock(ModelElement.class));
		term.setOrigin(expected);
		assertEquals(expected, term.getOrigin());
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testSetOriginModelElement() {
		term.addPropertyChangeListener("origin", listener);
		ModelElement expected = mock(ModelElement.class);
		term.setOrigin(expected);
		assertEquals(expected, term.getOrigin().get());
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

}
