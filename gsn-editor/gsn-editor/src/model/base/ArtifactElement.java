package model.base;

/**
 * ArtifactElement acts as the base class for elements in other SACM packages. Essentially, 
 * all elements which extend ArtifactElement are considered to be an artifact, and therefore 
 * can be referenced using Argument:ArtifactReference.
 * <h1>Semantics</h1>
 * ArtifactElement corresponds to the base class for specifying all the identifiable units 
 * of data modelled and managed in a structured assurance case effort.
 * 
 * @author Tim Rowe
 *
 */
public abstract class ArtifactElement extends ModelElement {
	// Intentionally empty
}
