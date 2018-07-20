package model.base;

/**
 * ImplementationConstraint specifies details of any implementation constraints that must be 
 * satisfied whenever a referencing Model Element is to be converted from 
 * <i>isAbstract = true</i> to </i>isAbstract = false</i>. For example in the context
 * of a SACM pattern fragment, an element will need to satisfy the implementation rules of 
 * the pattern.
 * <h1>Semantics</h1>
 * ImplementationConstraints indicate the conditions to fulfil in order to allow an abstract 
 * ModelElement (isAbstract = true) to become non-abstract (isAbstract = false).
 * 
 * @author Tim Rowe
 *
 */
public class ImplementationConstraint extends UtilityElement {
	// Intentionally empty
}
