package model.artifact;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import model.base.ArtifactElement;

/**
 * ArtifactGroup can be used to associate a number of ArtifactElements to a common group (e.g., 
 * representing a common type or purpose, or being of interest to a particular stakeholder).
 * <h1>Semantics</h1>
 * ArtifactGroup can be used to associate a number of ArtifactElements to a common group (e.g., 
 * representing a common type or purpose, or being of interest to a particular stakeholder). The name 
 * and the description of the ArtifactGroup should provide the semantic for understanding the 
 * ArtifactGroup. ArtifactGroups serve no structural purpose in the formation of the argument 
 * network, nor are they meant as a structural packaging mechanism (this should be done using
 * ArtifactPackage).
 * 
 * @author Tim Rowe
 *
 */
public class ArtifactGroup extends ArtifactElement {
	Set<ArtifactElement> artifactElement;
	
	/**
	 * Constructor
	 */
	public ArtifactGroup() {
		artifactElement = new HashSet<>();
	}
	
	/**
	 * Gets the collection of ArtifactElements organised within the ArtifactGroup.
	 * @return the collection of ArtifactElements organised within the ArtifactGroup.
	 */
	public Set<ArtifactElement> getArtifactElement() {
		return Collections.unmodifiableSet(artifactElement);
	}
	
	/**
	 * <p>Add an ArtifactElement organised within the ArtifactGroup.</p>
	 * <p>Notifies <b>artifactElement</b> if the group is changed</p>
	 * @param value the ArtifactElement
	 * @return true iff the group is changed by the addition
	 */
	public boolean addArtifactElement(ArtifactElement value) {
		Set<ArtifactElement> oldValue = new HashSet<>(artifactElement);
		boolean result = artifactElement.add(value);
		pcs.firePropertyChange("artifactElement", oldValue, artifactElement);
		return result;
	}
	
	/**
	 * <p>Remove an ArtifactElement organised within the ArtifactGroup.</p>
	 * <p>Notifies <b>artifactElement</b> if the group is changed</p>
	 * @param value the ArtifactElement
	 * @return true iff the group is changed by the addition
	 */
	public boolean removeArtifactElement(ArtifactElement value) {
		Set<ArtifactElement> oldValue = new HashSet<>(artifactElement);
		boolean result = artifactElement.remove(value);
		pcs.firePropertyChange("artifactElement", oldValue, artifactElement);
		return result;
	}
	
	/**
	 * <p>Clear all ArtifactElements organised within the ArtifactGroup.</p>
	 * <p>Notifies <b>artifactElement</b> if the group is changed</p>
	 */
	public void clearArtifactElement() {
		Set<ArtifactElement> oldValue = new HashSet<>(artifactElement);
		artifactElement.clear();
		pcs.firePropertyChange("artifactElement", oldValue, artifactElement);
	}
}
