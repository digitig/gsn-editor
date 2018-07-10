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

import model.INotifier;

/**
 * SACMElement is the base class for SACM.
 * <h1>Semantics</h1>
 * All the elements of a structured assurance case effort created with SACM correspond to a SACMElement.
 * 
 * @author Tim Rowe
 *
 */
public abstract class SacmElement implements INotifier {
	protected PropertyChangeSupport pcs;

	public SacmElement() {
		pcs = new PropertyChangeSupport(this);
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
