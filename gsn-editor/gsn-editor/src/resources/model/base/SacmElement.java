package model.base;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * <h1>Description</h1> The base class for the ORM Structured Assurance Case
 * Metamodel
 * <h1>Semantics</h1> All the elements of a structured assurance case effort
 * created with SACM correspond to a SACMElement.
 * <h1>Constraints</h1>
 * <ul>
 * <li>If citedElement is populated, isCitation must be true.</li>
 * <li>When +abstractForm is used to refer to another SACMElement:
 * <ul>
 * <li>+isAbstract of the SACMElement is false;</li>
 * <li>the +isAbstract of the referred SACMElement should be true;</li>
 * <li>the referred SACMElement should be of the same type of the
 * SACMElement;</li>
 * <li>If ImplementationConstraints are expressed on the referred SACMElement,
 * the SACMElement should satisfy these ImplementationConstraints.</li>
 * </ul>
 * </ul>
 */
// TODO make SacmElement abstract
public class SacmElement {
	private final UUID gid;
	private boolean isCitation;
	private boolean isAbstract;
	protected Set<String> errors;
	protected PropertyChangeSupport pcs;
	private Optional<SacmElement> citedElement;
	private Optional<SacmElement> abstractForm;
	public static final String INCONSISTENT_IS_CITATION_ERROR = "SacmElement.1";
	public static final String INCONSISTENT_IS_ABSTRACT_ERROR = "SacmElement.2";
	public static final String INCONSISTENT_ABSTRACT_FORM_TYPE_ERROR = "SacmElement.3";
	
	/**
	 * Default constructor
	 */
	public SacmElement() {
		this(false, false, null, null);
	}
	
	/**
	 * Constructor
	 * @param isCitation a flag to indicate whether the SACMElement cites another SACMElement.
	 * @param isAbstract a flag to indicate whether the SACMElement is considered to be abstract.
	 * @param citedElement a reference to another SACMElement that this SACMElement cites.
	 * @param abstractForm an optional reference to another abstract SACMElement to which this concrete SACMElement conforms.
	 */
	public SacmElement(boolean isCitation, boolean isAbstract, SacmElement citedElement, SacmElement abstractForm) {
		pcs = new PropertyChangeSupport(this);
		gid = UUID.randomUUID();
		this.isCitation = isCitation;
		this.isAbstract = isAbstract;
		this.citedElement = Optional.ofNullable(citedElement);
		this.abstractForm = Optional.ofNullable(abstractForm);
		errors = new HashSet<>();
	}
	
	/**
	 * Get an identifier that is unique within the scope of the model instance. The
	 * SACM allows this to be optional, but in the GSN Editor it is guaranteed to be
	 * present (and to a very high certainty guaranteed to be unique across all
	 * models).
	 * 
	 * @return the gid.
	 */
	public String getGid() {
		return gid.toString();
	}
	
	/**
	 * Get a flag to indicate whether the SACMElement cites another SACMElement. Note that the name is potentially confusing:
	 * it indicates whether the SACMElement cites another element, not whether the element itself is a citation. If CitedElement
	 * is present, isCitation is always true.
	 * @return a flag to indicate whether the SACMElement cites another SACMElement.
	 */
	public boolean getIsCitation() {
		return isCitation;
	}
	
	/**
	 * Set a flag to indicate whether the SACMElement cites another SACMElement.
	 * @param value a flag to indicate whether the SACMElement cites another SACMElement.
	 */
	public void setIsCitation(boolean value) {
		if (isCitation != value) {
			Boolean oldIsCitation = isCitation;
			isCitation = value;
			pcs.firePropertyChange("isCitation", oldIsCitation, Boolean.valueOf(value));
			validate();
		}
	}
	
	/**
	 * Get a flag to indicate whether the SACMElement is considered to be abstract. For example, 
	 * this can be used to indicate whether an element is part of a pattern or template.
	 * @return a flag to indicate whether the SACMElement is considered to be abstract.
	 */
	public boolean getIsAbstract() {
		return isAbstract;
	}
	
	/**
	 * Get a flag to indicate whether the SACMElement is considered to be abstract. For example, 
	 * this can be used to indicate whether an element is part of a pattern or template.
	 * @param value a flag to indicate whether the SACMElement is considered to be abstract.
	 */
	public void setIsAbstract(boolean value) {
		if (value != isAbstract ) {
			Boolean oldisAbstract = isAbstract;
			isAbstract = value;
			pcs.firePropertyChange("isAbstract", oldisAbstract, Boolean.valueOf(value));
			validate();
		}
	}
	
	/**
	 * get a reference to another SACMElement that this SACMElement cites.
	 * 
	 * @return a reference to another SACMElement that the SACMElement cites.
	 */	
	public Optional<SacmElement> getCitedElement() {
		return citedElement;
	}
	
	/**
	 * Set a reference to another SACMElement that the SACMElement cites.
	 * 
	 * @param value a reference to another SACMElement that the SACMElement cites.
	 */
	public void setCitedElement(Optional<SacmElement> value) {
		if (!citedElement.equals(value)) {
			Optional<SacmElement> oldCitedElement = citedElement;
			citedElement = value;
			pcs.firePropertyChange("citedElement", oldCitedElement, value);
			validate();
		}
	}
	
	/**
	 * Set a reference to another SACMElement that the SACMElement cites.
	 * 
	 * @param value a reference to another SACMElement that the SACMElement cites.
	 */
	public void setCitedElement(SacmElement value) {
		setCitedElement(Optional.ofNullable(value));
	}
	
	/**
	 * Get an optional reference to another abstract SACMElement to which this
	 * concrete SACMElement conforms.
	 * 
	 * @return the reference to another abstract SACMElement.
	 */
	public Optional<SacmElement> getAbstractForm() {
		return abstractForm;
	}
	
	/**
	 * Set an optional reference to another abstract SACMElement to which this
	 * concrete SACMElement conforms.
	 * 
	 * @param value an optional reference to another abstract SACMElement.
	 */
	public void setAbstractForm(Optional<SacmElement> value) {
		if (!abstractForm.equals(value)) {
			Optional<SacmElement> oldValue = abstractForm;
			abstractForm = value;
			pcs.firePropertyChange("abstractForm", oldValue, abstractForm);
			validate();
		}
	}
	
	/**
	 * Set an optional reference to another abstract SACMElement to which this
	 * concrete SACMElement conforms.
	 * 
	 * @param value an optional reference to another abstract SACMElement.
	 */
	public void setAbstractForm(SacmElement value) {
		setAbstractForm(Optional.ofNullable(value));
	}

	protected void validate() {
		errors.clear();
		if (citedElement.isPresent() && !isCitation) errors.add(INCONSISTENT_IS_CITATION_ERROR);
		if (abstractForm.isPresent() && isAbstract) errors.add(INCONSISTENT_IS_ABSTRACT_ERROR);
		if (abstractForm.isPresent() && (abstractForm.get().getClass() != this.getClass())) {
			errors.add(INCONSISTENT_ABSTRACT_FORM_TYPE_ERROR);
		}
		// Fire change because errors *might* have changed.
		pcs.firePropertyChange("errors", null, errors);
	}
	
	/**
	 * Get an unmodifiable collection of error strings
	 * @return the error strings.
	 */
	public Collection<String> getErrors() {
		return Collections.unmodifiableCollection(errors);
	}
	
	/**
	 * Add a property change listener
	 * @param listener a property change listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	/**
	 * Add a property change listener to listen to a specific property
	 * @param property the property to listen to
	 * @param listener the listener
	 */
	public void addPropertyChangeListener(String property, PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(property, listener);
	}
	
	/**
	 * Remove a property change listener
	 * @param listener the property change listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
}