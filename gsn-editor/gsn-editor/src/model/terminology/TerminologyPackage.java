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

import java.util.HashSet;
import java.util.Set;

/**
 * The TerminologyPackage Class is the container class for SACM terminology assets.
 * <h1>Semantics</h1>
 * TerminologyPackages contain the TerminologyAssets that can be used within the naming and description
 * of SACM arguments and artifacts. TerminologyPackage elements can be nested, and can contain citations 
 * (references) to other TerminologyPackages.
 */
public class TerminologyPackage extends TerminologyElement {
	private Set<TerminologyAsset> terminologyAsset;
	private Set<TerminologyPackage> terminologyPackage;
	private Set<TerminologyPackageCitation> terminologyPackageCitation;
	
	/**
	 * Default constructor
	 */
	public TerminologyPackage() {
		terminologyAsset = new HashSet<>();
		terminologyPackage = new HashSet<>();
		terminologyPackageCitation = new HashSet<>();
	}
	
	/**
	 * Get the TerminologyAssets contained in a given instance of a TerminologyPackage.
	 * @return The TerminologyAssets contained in a given instance of a TerminologyPackage.
	 */
	public Set<TerminologyAsset> getTerminologyAsset() {
		return terminologyAsset;
	}
	
	/**
	 * Set the TerminologyAssets contained in a given instance of a TerminologyPackage.
	 * @param value The TerminologyAssets contained in a given instance of a TerminologyPackage.
	 */
	public void setTerminologyAsset(Set<TerminologyAsset> value) {
		Set<TerminologyAsset> oldValue = terminologyAsset;
		terminologyAsset = value;
		pcs.firePropertyChange("terminologyAsset", oldValue, value);
	}
	
	/**
	 * Get the nested terminologyPackage contained in a given instance of a TerminologyPackage
	 * @return The nested terminologyPackage contained in a given instance of a TerminologyPackage
	 */
	public Set<TerminologyPackage> getTerminologyPackage() {
		return terminologyPackage;
	}
	
	/**
	 * Set the nested terminologyPackage contained in a given instance of a TerminologyPackage
	 * @param value The nested terminologyPackage contained in a given instance of a TerminologyPackage
	 */
	public void setTerminologyPackageCitation(Set<TerminologyPackage> value) {
		Set<TerminologyPackage> oldValue = terminologyPackage;
		terminologyPackage = value;
		pcs.firePropertyChange("terminologyPackage", oldValue, value);
	}
	
	/**
	 * Get the nested terminologyPackageCitation contained in a given instance of a TerminologyPackage
	 * @return The nested terminologyPackageCitation contained in a given instance of a TerminologyPackage
	 */
	public Set<TerminologyPackageCitation> getTerminologyPackageCitation() {
		return terminologyPackageCitation;
	}
	
	/**
	 * Set the nested terminologyPackageCitation contained in a given instance of a TerminologyPackage
	 * @param value The nested terminologyPackageCitation contained in a given instance of a TerminologyPackage
	 */
	public void setTerminologyPackage(Set<TerminologyPackageCitation> value) {
		Set<TerminologyPackageCitation> oldValue = terminologyPackageCitation;
		terminologyPackageCitation = value;
		pcs.firePropertyChange("terminologyPackageCitation", oldValue, value);
	}
}
