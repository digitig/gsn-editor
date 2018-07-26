package model.terminology;

/**
 * Elements within the TerminologyPackage can be bound together by means of 
 * TerminologyPackageBindings. TerminologyPackageBindings bind the participant packages by means of 
 * terminology elements that connect the cited elements of the participant packages.
 * <h1>Semantics</h1>
 * TerminologyPackageBinding binds TerminologyPackages together to indicate the relationship between 
 * two TerminologyPackages.
 * <h1>Constraints</h1>
 * The participantPackages should be either TerminologyPackage or TerminologyPackageInterface.
 * 
 * @author Tim Rowe
 *
 */
public class TerminologyPackageBinding extends TerminologyPackage {
	// Intentionally empty
}
