package model.terminology;

/**
 * TerminologyPackageInterface is a kind of TerminologyPackage that defines an interface 
 * that may be exchanged between users. An TerminologyPackage may declare one or more 
 * TerminologyPackageInterfaces.
 * <h1>Semantics</h1>
 * TerminologyPackageInterface enables the declaration of the elements of a 
 * TerminologyPackage that might be referred to (cited) in another TerminologyPackage, 
 * thus the elements can be used for assurance in the scope of the latter 
 * AssuranceCasePackage.
 * 
 * @author Tim Rowe
 *
 */
public class TerminologyPackageInterface extends TerminologyElement {
	TerminologyPackage implementsValue;
	
	/**
	 * Default constructor
	 */
	public TerminologyPackageInterface(TerminologyPackage value) {
		implementsValue = value;
	}
	
	/**
	 * Gets the TerminologyPackage that the TerminologyPackageInterface declares.
	 * @return the TerminologyPackage that the TerminologyPackageInterface declares.
	 */
	public TerminologyPackage getImplements() {
		return implementsValue;
	}
	
	/**
	 * <p>Sets the TerminologyPackage that the TerminologyPackageInterface declares.</p>
	 * <p>Notifies <b>implements</b> on change.</p>
	 * @param value the TerminologyPackage that the TerminologyPackageInterface declares.
	 */
	public void setImplements(TerminologyPackage value) {
		TerminologyPackage oldValue = implementsValue;
		implementsValue = value;
		pcs.firePropertyChange("implements", oldValue, implementsValue);
	}
}
