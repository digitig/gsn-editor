package model.terminology;

import java.util.Optional;

import model.base.ModelElement;

/**
 * Term is used to model both abstract and concrete terms in SACM. Abstract Terms can be considered 
 * placeholders for concrete terms and are denoted by the inherited isAbstract:Boolean attribute 
 * being set true. A concrete term is denoted by isAbstract:Boolean being false.
 * <h1>Semantics</h1>
 * <p>Term class is used to model both abstract and concrete terms in SACM. Abstract Terms can be 
 * considered placeholders for concrete terms and are denoted by the inherited isAbstract:Boolean 
 * attribute being set true. A concrete term is denoted by isAbstract:Boolean being false.</p>
 * <p>The externalReference attribute enables the referencing of the object signified by the term 
 * (i.e., the signifier). It also provides a mechanism whereby terms can reference concepts and 
 * terms defined in other ontology and terminology models</p>
 * @author Tim Rowe
 *
 */
public class Term extends ExpressionElement {
	private Optional<String> externalReference;
	private Optional<ModelElement> origin;
	/**
	 * Constructor
	 */
	public Term() {
		externalReference = Optional.empty();
		origin = Optional.empty();
	}
	
	/**
	 * Get an attribute recording an external reference (e.g., URI) to the object referred to by 
	 * the Term.
	 * @return the attribute recording an external reference
	 */
	public Optional<String> getExternalReference() {
		return externalReference;
	}
	
	/**
	 * <p>Set Get an attribute recording an external reference</p>
	 * <p>Notifies <b>externalReference</b> on change.</p>
	 * @param value the attribute recording an external reference
	 */
	public void setExternalReference(Optional<String> value) {
		Optional<String> oldValue = externalReference;
		externalReference = value;
		pcs.firePropertyChange("externalReference", oldValue, externalReference);
	}
	
	/**
	 * Set an attribute recording an external reference
	 * <p>Notifies <b>externalReference</b> on change.</p>
	 * @param value the attribute recording an external reference
	 */
	public void setExternalReference(String value) {
		setExternalReference(Optional.ofNullable(value));
	}
	
	/**
	 * Get a reference which points to the origin of the Term.
	 * @return the reference
	 */
	public Optional<ModelElement> getOrigin() {
		return origin;
	}
	
	/**
	 * Set a reference which points to the origin of the Term.
	 * <p>Notifies <b>origin</b> on change.</p>
	 * @param value a reference which points to the origin of the Term.
	 */
	public void setOrigin(Optional<ModelElement> value) {
		Optional<ModelElement> oldValue = origin;
		origin = value;
		pcs.firePropertyChange("origin", oldValue, origin);
	}
	
	/**
	 * Set a reference which points to the origin of the Term.
	 * @param value a reference which points to the origin of the Term.
	 */
	public void setOrigin(ModelElement value) {
		setOrigin(Optional.ofNullable(value));
	}
}
