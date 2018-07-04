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

import java.util.Optional;

/**
 * <h1>Description</h1>
 * The TerminlogyPackageCitation is a citation (reference) to another TerminologyPackage.
 * <h1>Semantics</h1>
 * <p>TerminologyPackageCitations make it possible to cite other TerminologyPackages.</p>
 * <p>For example, within a TerminologyPackage it can be useful to refer to another TerminologyPackage 
 * (to reference terminology) that is not contained with the same TerminologyPackage and is defined 
 * elsewhere.</p>
 * <h1>Constraints</h1>
 * The citedPackage referred to by a TerminologyPackageCitation must be outside of the containment 
 * hierarchy containing the citation.
 * 
 * @author owner
 *
 */
public class TerminologyPackageCitation extends TerminologyElement {
	private Optional<TerminologyPackage> citedPackage;
	
	/**
	 * Default constructor
	 */
	public TerminologyPackageCitation() {
		citedPackage = Optional.empty();
	}
	
	/**
	 * Get the TerminologyPackage being cited by the TerminologyPackageCitation.
	 * @return The TerminologyPackage being cited by the TerminologyPackageCitation.
	 */
	public Optional<TerminologyPackage> getCitedPackage() {
		return citedPackage;
	}
	
	/**
	 * Set the TerminologyPackage being cited by the TerminologyPackageCitation.
	 * @param value The TerminologyPackage being cited by the TerminologyPackageCitation.
	 */
	public void setCitedPackage(Optional<TerminologyPackage> value) {
		Optional<TerminologyPackage> oldValue = citedPackage;
		this.citedPackage = value;
		pcs.firePropertyChange("citedPackage", oldValue, value);
	}
	
	/**
	 * Set the TerminologyPackage being cited by the TerminologyPackageCitation.
	 * @param value The TerminologyPackage being cited by the TerminologyPackageCitation.
	 */
	public void setCitedPackage(TerminologyPackage value) {
		setCitedPackage(Optional.ofNullable(value));
	}
}
