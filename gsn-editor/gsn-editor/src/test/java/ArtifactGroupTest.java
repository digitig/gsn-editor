package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.artifact.ArtifactGroup;
import model.base.ArtifactElement;

class ArtifactGroupTest {
	ArtifactGroup artifactGroup;
	PropertyChangeListener listener;

	@BeforeEach
	void setUp() throws Exception {
		artifactGroup = new ArtifactGroup();
		listener = mock(PropertyChangeListener.class);
	}

	@Test
	void testArtifactGroup() {
		assertTrue(artifactGroup.getArtifactElement().isEmpty());
	}

	@Test
	void testAddArtifactElement() {
		ArtifactElement expected = mock(ArtifactElement.class);
		artifactGroup.addPropertyChangeListener("artifactElement", listener);
		artifactGroup.addArtifactElement(expected);
		assertTrue(artifactGroup.getArtifactElement().contains(expected));
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testRemoveArtifactElement() {
		ArtifactElement expected = mock(ArtifactElement.class);
		artifactGroup.addPropertyChangeListener("artifactElement", listener);
		artifactGroup.addArtifactElement(expected);
		artifactGroup.removeArtifactElement(expected);
		assertFalse(artifactGroup.getArtifactElement().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testClearArtifactElement() {
		ArtifactElement expected = mock(ArtifactElement.class);
		artifactGroup.addPropertyChangeListener("artifactElement", listener);
		artifactGroup.addArtifactElement(expected);
		artifactGroup.clearArtifactElement();
		assertTrue(artifactGroup.getArtifactElement().isEmpty());
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}

}
