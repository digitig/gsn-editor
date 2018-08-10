package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.artifact.ArtifactPackage;
import model.artifact.ArtifactPackageBinding;
import model.base.ArtifactElement;

class ArtifactPackageBindingTest {
	ArtifactPackageBinding artifactPackageBinding;
	PropertyChangeListener listener;
	
	@BeforeEach
	void setUp() throws Exception {
		artifactPackageBinding = new ArtifactPackageBinding();
		listener = mock(PropertyChangeListener.class);
	}

	@Test
	void testGetParticipantPackage() {
		assertTrue(artifactPackageBinding.getParticipantPackage().isEmpty());
	}

	@Test
	void testAddParticipantPackage() {
		ArtifactPackage expected = mock(ArtifactPackage.class);
		artifactPackageBinding.addPropertyChangeListener("participantPackage", listener);
		artifactPackageBinding.addParticipantPackage(expected);
		assertTrue(artifactPackageBinding.getParticipantPackage().contains(expected));
		verify(listener).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testRemoveParticipantPackage() {
		ArtifactPackage expected = mock(ArtifactPackage.class);
		artifactPackageBinding.addPropertyChangeListener("participantPackage", listener);
		artifactPackageBinding.addParticipantPackage(expected);
		artifactPackageBinding.removeParticipantPackage(expected);
		assertFalse(artifactPackageBinding.getParticipantPackage().contains(expected));
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
	}

	@Test
	void testClearParticipantPackage() {
		ArtifactPackage expected = mock(ArtifactPackage.class);
		artifactPackageBinding.addPropertyChangeListener("participantPackage", listener);
		artifactPackageBinding.addParticipantPackage(expected);
		artifactPackageBinding.clearParticipantPackage();
		assertTrue(artifactPackageBinding.getParticipantPackage().isEmpty());
		verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));

	}

}
