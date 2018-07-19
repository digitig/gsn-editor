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
package model.terminology;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The TerminologyPackage Class is the container class for SACM terminology
 * assets.
 * <h1>Semantics</h1> TerminologyPackages contain the TerminologyAssets that can
 * be used within the naming and description of SACM arguments and artifacts.
 * TerminologyPackage elements can be nested, and can contain citations
 * (references) to other TerminologyPackages.
 * 
 * @author Tim Rowe
 *
 */
public class TerminologyPackage extends TerminologyElement {
	private Set<TerminologyPackage> terminologyPackage;

	/**
	 * Default constructor
	 */
	public TerminologyPackage() {
		terminologyPackage = new HashSet<>();
	}

	/**
	 * Get the nested terminologyPackage contained in a given instance of a
	 * TerminologyPackage
	 * 
	 * @return The nested terminologyPackage contained in a given instance of a
	 *         TerminologyPackage
	 */
	public Set<TerminologyPackage> getTerminologyPackage() {
		return terminologyPackage;
	}

	/**
	 * <p>
	 * Adds the specified TerminologyPackage if it is not already present. If this
	 * package already contains the element, the call leaves the package unchanged
	 * and returns false. In combination with the restriction on Set constructors,
	 * this ensures that sets never contain duplicate elements.
	 * </p>
	 * <p>
	 * On change, notifies <b>terminologyPackage</b>
	 * </p>
	 * 
	 * @param value element to be added to this set
	 * @return true if this set did not already contain the specified element
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
	public boolean addTerminologyPackage(TerminologyPackage value)
			throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException {
		if (value == null)
			throw new NullPointerException();
		Set<TerminologyPackage> oldValue = new HashSet<>(terminologyPackage);
		boolean result = terminologyPackage.add(value);
		pcs.firePropertyChange("terminologyPackage", oldValue, terminologyPackage);
		return result;
	}

	/**
	 * <p>
	 * Removes the specified TermilologyPackage from this package if it is present.
	 * Returns true if this package contained the element (or equivalently, if this
	 * set changed as a result of the call). (This set will not contain the element
	 * once the call returns.)
	 * </p>
	 * <p>
	 * On change, notifies <b>terminologyPackage</b>
	 * </p>
	 * 
	 * @param value the TerminologyPackage to be removed
	 * @return true if the package contained value.
	 * @throws NullPointerException if value is null
	 */
	public boolean removeTerminologyPackage(TerminologyPackage value) throws NullPointerException {
		Set<TerminologyPackage> oldValue = new HashSet<>(terminologyPackage);
		boolean result = terminologyPackage.remove(value);
		pcs.firePropertyChange("terminologyPackage", oldValue, terminologyPackage);
		return result;
	}

	/**
	 * <p>
	 * Remove all terminology packages from this package.
	 * </p>
	 * <p>
	 * On change, notifies <b>terminologyPackage</b>
	 * </p>
	 */
	public void clearTerminologyPackage() {
		if (!terminologyPackage.isEmpty()) {
			terminologyPackage.clear();
			pcs.firePropertyChange("terminologyPackage", null, terminologyPackage);
		}
	}
}