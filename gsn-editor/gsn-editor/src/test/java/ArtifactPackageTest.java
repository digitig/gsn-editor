package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.artifact.ArtifactPackage;
import model.base.ArtifactElement;

class ArtifactPackageTest {
	ArtifactPackage artifactPackage;
	PropertyChangeListener listener;

	@BeforeEach
	void setUp() throws Exception {
		artifactPackage = new ArtifactPackage();
		listener = mock(PropertyChangeListener.class);
	}

	@Test
	void testArtifactPackage() {
		assertTrue(artifactPackage.getArtifactElement().isEmpty());
	}

	@Test
	void testAddArtifactElement() {
		ArtifactElement expected = mock(ArtifactElement.class);
		artifactPackage.addPropertyChangeListener("artifactElement", listener);
		artifactPackage.addArtifactElement(expected);
		assertTrue(artifactPackage.getArtifactElement().contains(expected));
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testRemoveArtifactElement() {
		ArtifactElement expected = mock(ArtifactElement.class);
		artifactPackage.addPropertyChangeListener("artifactElement", listener);
		artifactPackage.addArtifactElement(expected);
		artifactPackage.removeArtifactElement(expected);
		assertFalse(artifactPackage.getArtifactElement().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testClearArtifactElement() {
		ArtifactElement expected = mock(ArtifactElement.class);
		artifactPackage.addPropertyChangeListener("artifactElement", listener);
		artifactPackage.addArtifactElement(expected);
		artifactPackage.clearArtifactElement();
		assertTrue(artifactPackage.getArtifactElement().isEmpty());
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}
}
