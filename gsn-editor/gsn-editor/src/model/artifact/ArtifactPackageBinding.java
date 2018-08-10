package model.artifact;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The ArtifactPackageBinding is a subtype of ArtifactPackage used to record 
 * ArtifactAssetRelationships between the ArtifactAssets of two or more ArtifactPackages.
 * <h1>Semantics</h1>
 * ArtifactPackageBindings can be used to map dependencies between the cited ArtifactAssets of two 
 * or more ArtifactPackages. For example, a binding could be used to record a "derivedFrom" 
 * ArtifactAssetRelationship between the ArtifactAsset of one package to the ArtifactAsset of 
 * another.
 * <h1>Constraints</h1>
 * <p>ArtifactPackageBindings must only contain ArtifactAssetRelationships with source and target 
 * Artifacts, with isCitation = true citing ArtifactAssets contained within the ArtifactPackages 
 * associated by participantPackage.</p>
 * <p>The number of participant packages is at least two.</p>
 * @author Tim Rowe
 *
 */
public class ArtifactPackageBinding extends ArtifactPackage {
	Set<ArtifactPackage> participantPackage;
	
	public ArtifactPackageBinding() {
		participantPackage = new HashSet<>();
	}
	
	/**
	 * Get the ArtifactPackages containing the ArtifactAssets being related together by
	 * the ArtifactPackageBinding.
	 * @return the ArtifactPackages
	 */
	public Set<ArtifactPackage> getParticipantPackage() {
		return Collections.unmodifiableSet(participantPackage);
	}
	
	/**
	 * <p>Add an ArtifactPackage containing ArtifactAssets being related by
	 * the ArtifactPackageBinding.</p>
	 * <p>Notifies <b>participantPackage</b> if the participant packages are changed by the operation.</p>
	 * @param value the ArtifactPackage to add
	 * @return true iff the participant packages are changed by this operation
	 */
	public boolean addParticipantPackage(ArtifactPackage value) {
		Set<ArtifactPackage> oldValue = new HashSet<>(participantPackage);
		boolean result = participantPackage.add(value);
		pcs.firePropertyChange("participantPackage", oldValue, participantPackage);
		return result;
	}
	
	/**
	 * <p>Remove an ArtifactPackage containing ArtifactAssets being related by
	 * the ArtifactPackageBinding.</p>
	 * <p>Notifies <b>participantPackage</b> if the participant packages are changed by the operation.</p>
	 * @param value the ArtifactPackage to remove
	 * @return true iff the participant packages are changed by this operation
	 */
	public boolean removeParticipantPackage(ArtifactPackage value) {
		Set<ArtifactPackage> oldValue = new HashSet<>(participantPackage);
		boolean result = participantPackage.remove(value);
		pcs.firePropertyChange("participantPackage", oldValue, participantPackage);
		return result;
	}
	
	/**
	 * <p>Clear all participant packages.</p>
	 * <p>Notifies <b>participantPackage</b> if the participant packages are changed by the operation.</p>
	 */
	public void clearParticipantPackage() {
		Set<ArtifactPackage> oldValue = new HashSet<>(participantPackage);
		participantPackage.clear();
		pcs.firePropertyChange("participantPackage", oldValue, participantPackage);
	}
}
