/*******************************************************************************
 * Copyright (C) 2018 Timothy G Rowe
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package model.base;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Optional;
import java.util.UUID;

import model.ValidationErrors;

/**
 * <h1>Description</h1> The base class for the ORM Structured Assurance Case
 * Metamodel
 * <h1>Semantics</h1> All the elements of a structured assurance case effort
 * created with SACM correspond to a ModelElement.
 * <h1>Constraints</h1>
 * <ul>
 * <li>If citedElement is populated, isCitation must be true.</li>
 * <li>When +abstractForm is used to refer to another ModelElement:
 * <ul>
 * <li>+isAbstract of the ModelElement is false;</li>
 * <li>the +isAbstract of the referred ModelElement should be true;</li>
 * <li>the referred ModelElement should be of the same type of the
 * ModelElement;</li>
 * <li>If ImplementationConstraints are expressed on the referred ModelElement,
 * the ModelElement should satisfy these ImplementationConstraints.</li>
 * </ul>
 * </ul>
 */
// TODO make ModelElement abstract
public abstract class ModelElement extends SacmElement {
	private final UUID gid;
	private boolean isCitation;
	private boolean isAbstract;
	protected EnumSet<ValidationErrors> errors;
	protected PropertyChangeSupport pcs;
	private Optional<ModelElement> citedElement;
	private Optional<ModelElement> abstractForm;
	
	/**
	 * Default constructor
	 */
	protected ModelElement() {
		this(false, false, null, null);
	}
	
	/**
	 * Constructor
	 * @param isCitation a flag to indicate whether the ModelElement cites another ModelElement.
	 * @param isAbstract a flag to indicate whether the ModelElement is considered to be abstract.
	 * @param citedElement a reference to another ModelElement that this ModelElement cites.
	 * @param abstractForm an optional reference to another abstract ModelElement to which this concrete ModelElement conforms.
	 */
	protected ModelElement(boolean isCitation, boolean isAbstract, ModelElement citedElement, ModelElement abstractForm) {
		pcs = new PropertyChangeSupport(this);
		gid = UUID.randomUUID();
		this.isCitation = isCitation;
		this.isAbstract = isAbstract;
		this.citedElement = Optional.ofNullable(citedElement);
		this.abstractForm = Optional.ofNullable(abstractForm);
		errors = EnumSet.noneOf(ValidationErrors.class);
	}
	
	/**
	 * Get an identifier that is unique within the scope of the model instance. The
	 * Model allows this to be optional, but in the GSN Editor it is guaranteed to be
	 * present (and to a very high certainty guaranteed to be unique across all
	 * models).
	 * 
	 * @return the gid.
	 */
	public final String getGid() {
		return gid.toString();
	}
	
	/**
	 * Get a flag to indicate whether the ModelElement cites another ModelElement. Note that the name is potentially confusing:
	 * it indicates whether the ModelElement cites another element, not whether the element itself is a citation. If CitedElement
	 * is present, isCitation is always true.
	 * @return a flag to indicate whether the ModelElement cites another ModelElement.
	 */
	public final boolean getIsCitation() {
		return isCitation;
	}
	
	/**
	 * <p>Set a flag to indicate whether the ModelElement cites another ModelElement.</p>
	 * <p>On change, notifies <b>isCitation</b></p>
	 * @param value a flag to indicate whether the ModelElement cites another ModelElement.
	 */
	public final void setIsCitation(boolean value) {
		if (isCitation != value) {
			Boolean oldIsCitation = isCitation;
			isCitation = value;
			pcs.firePropertyChange("isCitation", oldIsCitation, Boolean.valueOf(value));
			validate();
		}
	}
	
	/**
	 * Get a flag to indicate whether the ModelElement is considered to be abstract. For example, 
	 * this can be used to indicate whether an element is part of a pattern or template.
	 * @return a flag to indicate whether the ModelElement is considered to be abstract.
	 */
	public final boolean getIsAbstract() {
		return isAbstract;
	}
	
	/**
	 * <p>Get a flag to indicate whether the ModelElement is considered to be abstract. For example, 
	 * this can be used to indicate whether an element is part of a pattern or template.</p>
	 * <p>On change, notifies <b>isAbstract</b></p>
	 * @param value a flag to indicate whether the ModelElement is considered to be abstract.
	 */
	public final void setIsAbstract(boolean value) {
		if (value != isAbstract ) {
			Boolean oldisAbstract = isAbstract;
			isAbstract = value;
			pcs.firePropertyChange("isAbstract", oldisAbstract, Boolean.valueOf(value));
			validate();
		}
	}
	
	/**
	 * get a reference to another ModelElement that this ModelElement cites.
	 * 
	 * @return a reference to another ModelElement that the ModelElement cites.
	 */	
	public final Optional<ModelElement> getCitedElement() {
		return citedElement;
	}
	
	/**
	 * <p>Set a reference to another ModelElement that the ModelElement cites.</p>
	 * <p>On change, notifies <b>citedElement</b></p>
	 * 
	 * @param value a reference to another ModelElement that the ModelElement cites.
	 */
	public final void setCitedElement(Optional<ModelElement> value) {
		if (!citedElement.equals(value)) {
			Optional<ModelElement> oldCitedElement = citedElement;
			citedElement = value;
			pcs.firePropertyChange("citedElement", oldCitedElement, value);
			validate();
		}
	}
	
	/**
	 * <p>Set a reference to another ModelElement that the ModelElement cites.</p>
	 * <p>On change, notifies <b>citedElement</b></p> 
	 * @param value a reference to another ModelElement that the ModelElement cites.
	 */
	public final void setCitedElement(ModelElement value) {
		setCitedElement(Optional.ofNullable(value));
	}
	
	/**
	 * Get an optional reference to another abstract ModelElement to which this
	 * concrete ModelElement conforms.
	 * 
	 * @return the reference to another abstract ModelElement.
	 */
	public final Optional<ModelElement> getAbstractForm() {
		return abstractForm;
	}
	
	/**
	 * <p>Set an optional reference to another abstract ModelElement to which this
	 * concrete ModelElement conforms.</p>
	 * <p>On change, notifies <b>abstractForm</b></p>
	 * 
	 * @param value an optional reference to another abstract ModelElement.
	 */
	public final void setAbstractForm(Optional<ModelElement> value) {
		if (!abstractForm.equals(value)) {
			Optional<ModelElement> oldValue = abstractForm;
			abstractForm = value;
			pcs.firePropertyChange("abstractForm", oldValue, abstractForm);
			validate();
		}
	}
	
	/**
	 * <p>Set an optional reference to another abstract ModelElement to which this
	 * concrete ModelElement conforms.</p>
	 * <p>On change, notifies <b>abstractForm</b></p>
	 * 
	 * @param value an optional reference to another abstract ModelElement.
	 */
	public final void setAbstractForm(ModelElement value) {
		setAbstractForm(Optional.ofNullable(value));
	}
	
	private final void validateInconsistentIsCitation() {
		if (!getCitedElement().isPresent() || getIsCitation()) {
			errors.remove(ValidationErrors.INCONSISTENT_IS_CITATION_ERROR);			
		} else {
			errors.add(ValidationErrors.INCONSISTENT_IS_CITATION_ERROR);
		}		
	}
	
	private final void validateInconsistentIsAbstract() {
		if (abstractForm.isPresent() && isAbstract) {
			errors.add(ValidationErrors.INCONSISTENT_IS_ABSTRACT_ERROR);
		} else {
			errors.remove(ValidationErrors.INCONSISTENT_IS_ABSTRACT_ERROR);
		}		
	}
	
	private final void validateInconsistentAbstractFormType() {
		if (abstractForm.isPresent() && (abstractForm.get().getClass() != this.getClass())) {
			errors.add(ValidationErrors.INCONSISTENT_ABSTRACT_FORM_TYPE_ERROR);
		} else {
			errors.remove(ValidationErrors.INCONSISTENT_ABSTRACT_FORM_TYPE_ERROR);
		}
		
	}
	
	protected final void validate() {
		validateInconsistentIsCitation();
		validateInconsistentIsAbstract();
		validateInconsistentAbstractFormType();
	}
	
	/**
	 * Get an unmodifiable collection of error strings
	 * @return the error strings.
	 */
	public final Collection<ValidationErrors> getErrors() {
		return Collections.unmodifiableCollection(errors);
	}
	
	/**
	 * Add a property change listener
	 * @param listener a property change listener
	 */
	public final void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	/**
	 * Add a property change listener to listen to a specific property
	 * @param property the property to listen to
	 * @param listener the listener
	 */
	public final void addPropertyChangeListener(String property, PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(property, listener);
	}
	
	/**
	 * Remove a property change listener
	 * @param listener the property change listener
	 */
	public final void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
}
