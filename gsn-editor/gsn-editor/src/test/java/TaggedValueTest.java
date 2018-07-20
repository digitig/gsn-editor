package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import model.base.MultiLangString;
import model.base.TaggedValue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class TaggedValueTest {

	@Test
	void testTaggedValue() {
		MultiLangString expected = mock(MultiLangString.class);
		TaggedValue taggedValue = new TaggedValue(expected);
		assertEquals(expected, taggedValue.getKey());
	}

	@Test
	void testSetKey() {
		PropertyChangeListener listener = mock(PropertyChangeListener.class);
		MultiLangString expected = mock(MultiLangString.class);
		TaggedValue taggedValue = new TaggedValue(mock(MultiLangString.class));
		taggedValue.addPropertyChangeListener("key", listener);
		taggedValue.setKey(expected);
		assertEquals(expected, taggedValue.getKey());
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

}
