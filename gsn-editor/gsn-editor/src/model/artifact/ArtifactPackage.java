package model.artifact;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import model.base.ArtifactElement;

/**
 * ArgumentPackage is the containing element for artifacts involved in a structured assurance case.
 * <h1>Semantics</h1>
 * ArtifactPackages contain ArtifactElements that represent the artifact forming part of a 
 * structured assurance case. ArtifactPackages can also be nested.
 * 
 * @author Tim Rowe
 *
 */
public class ArtifactPackage extends ArtifactElement {
	Set<ArtifactElement> artifactElement;
	
	/**
	 * Constructor
	 */
	public ArtifactPackage() {
		artifactElement = new HashSet<>();
	}
	
	/**
	 * Gets a collection of ArtifactElements forming an artifact package in a structured assurance 
	 * case.
	 * @return the collection of ArtifactElements
	 */
	public Set<ArtifactElement> getArtifactElement() {
		return Collections.unmodifiableSet(artifactElement);
	}
	
	/**
	 * <p>Add an ArtifactElement to the collection</p>
	 * <p>Notifies <b>artifactElement</b> on change</p>
	 * @param value the element to add
	 * @return true iff the collection is changed by this operation
	 */
	public boolean addArtifactElement(ArtifactElement value) {
		Set<ArtifactElement> oldValue = new HashSet<>(artifactElement);
		boolean result = artifactElement.add(value);
		pcs.firePropertyChange("artifactElement", oldValue, artifactElement);
		return result;
	}
	
	/**
	 * <p>Remove an ArtifactElement from this collection</p>
	 * <p>Notifies <b>artifactElement</b> on change</p>
	 * @param value the element to remove
	 * @return true iff the collection is changed by this operation
	 */
	public boolean removeArtifactElement(ArtifactElement value) {
		Set<ArtifactElement> oldValue = new HashSet<>(artifactElement);
		boolean result = artifactElement.remove(value);
		pcs.firePropertyChange("artifactElement", oldValue, artifactElement);
		return result;
	}
	
	/**
	 * <p>Clear every ArtifactElement from this collection</p>
	 * <p>Notifies <b>artifactElement</b> on change</p>
	 */
	public void clearArtifactElement() {
		Set<ArtifactElement> oldValue = new HashSet<>(artifactElement);
		artifactElement.clear();
		pcs.firePropertyChange("artifactElement", oldValue, artifactElement);
	}
}
