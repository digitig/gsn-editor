package model;

import java.beans.PropertyChangeListener;

/**
 * Interface for classes that handle property change listeners
 * @author Tim Rowe
 *
 */
public interface INotifier {
	/**
	 * Add a property change listener
	 * @param listener a property change listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener);
	
	/**
	 * Add a property change listener to listen to a specific property
	 * @param property the property to listen to
	 * @param listener the listener
	 */
	public void addPropertyChangeListener(String property, PropertyChangeListener listener);
	
	/**
	 * Remove a property change listener
	 * @param listener the property change listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener);
}
