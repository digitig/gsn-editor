package model.terminology;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * TerminologyGroup can be used to associate a number of TerminologyElements to a common group (e.g., 
 * representing a common type or purpose, or being of interest to a particular stakeholder).
 * <h1>Semantics</h1>
 * TerminologyGroup can be used to associate a number of TerminologyElements to a common group (e.g., 
 * representing a common type or purpose, or being of interest to a particular stakeholder). The name 
 * and the description of the TerminologyGroup should provide the semantic for understanding the 
 * TerminologyGroup. TerminologyGroups serve no structural purpose in the formation of the argument 
 * network, nor are they meant as a structural packaging mechanism (this should be done using 
 * TerminologyPackages).
 * 
 * @author Tim Rowe
 *
 */
public class TerminologyGroup extends TerminologyElement {
	Set<TerminologyElement> terminologyElement;
	
	/**
	 * Default constructor
	 */
	public TerminologyGroup() {
		terminologyElement = new HashSet<>();
	}
	
	/**
	 * A collection of TerminologyElements that are organized within the TerminologyGroup.
	 * @return the collection of TerminologyElements that are organized within the TerminologyGroup.
	 */
	public Set<TerminologyElement> getTerminologyElement() {
		return Collections.unmodifiableSet(terminologyElement);
	}
	
	
	/**
	 * <p>Add a terminology element to be organized within the TerminologyGroup.</p>
	 * <p>Notifies <b>terminologyElement</b> on change.</p>
	 * @param value the terminology element to be organized within the TerminologyGroup
	 * @return true iff the terminology group is changed as a result of this notification.
	 * @throws UnsupportedOperationException - if the add operation is not supported
	 *                                       by this set
	 * @throws ClassCastException            - if the class of the specified element
	 *                                       prevents it from being added to this
	 *                                       set
	 * @throws NullPointerException          - if the specified element is null
	 * @throws IllegalArgumentException      - if some property of the specified
	 *                                       element prevents it from being added to
	 *                                       this set
	 */
	public boolean addTerminologyElement(TerminologyElement value)
		throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException
	{
		if (value == null) throw new NullPointerException();
		Set<TerminologyElement> oldValue = new HashSet<>(terminologyElement);
		boolean result = terminologyElement.add(value);
		if (result) {
			pcs.firePropertyChange("terminologyElement", oldValue, terminologyElement);
		}
		return result;
	}
	
	/**
	 * remove a terminology element from the group
	 * @param value the terminology element to remove
	 * @return true iff the group changes as a result of this operation
	 * @throws NullPointerException if the specified element is null
	 */
	public boolean removeTerminologyElement(TerminologyElement value) throws NullPointerException {
		if (value == null) throw new NullPointerException();
		Set<TerminologyElement> oldValue = new HashSet<>(terminologyElement);
		boolean result = terminologyElement.remove(value);
		if (result) {
			pcs.firePropertyChange("terminologyElement", oldValue, terminologyElement);
		}
		return result;
	}
	
	/**
	 * Remove all terminology elements from this group
	 */
	public void clearTerminologyElement() {
		if (!terminologyElement.isEmpty()) {
			terminologyElement.clear();
			pcs.firePropertyChange("terminologyElement", null, terminologyElement);
		}
	}
}
