package model.terminology;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The ExpressionElement class is the abstract class for the elements in SACM that are necessary for 
 * modeling expressions.
 * <h1>Semantics</h1>
 * ExpressionElements are used to model (potentially structured) expressions in SACM.
 * @author Tim Rowe
 *
 */
public abstract class ExpressionElement extends TerminologyAsset {
	String value;
	Set<Category> category;
	/**
	 * Default constructor
	 */
	public ExpressionElement() {
		value = "";
		category = new HashSet<>();
	}
	
	/**
	 * <p>the value of the expression.</p>
	 * <p>Notifies <b>value</b> if this changes the ExpressionElement
	 * @param value the value of the expression.
	 */
	public void setValue(String value) {
		if (value == null) throw new NullPointerException();
		String oldValue = this.value;
		this.value = value;
		pcs.firePropertyChange("value", oldValue, value);
	}
	
	/**
	 * the value of the expression.
	 * @return the value of the expression.
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * association of the ExpressionElement with one or more terminology categories.
	 * @return the terminology categories.
	 */
	public Set<Category> getCategory() {
		return Collections.unmodifiableSet(category);
	}
	
	/**
	 * <p>Add a terminology category.</p>
	 * <p>Notifies <b>terminologyCategory</b> on change.
	 * @param value the terminology category
	 * @return true iff this changes the ExpressionElement.
	 */
	public boolean addCategory(Category value) {
		Set<Category> oldValue = new HashSet<>(category);
		boolean result = category.add(value);
		pcs.firePropertyChange("category", oldValue, category);
		return result;
	}
	
	/**
	 * <p>Removes a terminology category.</p>
	 * <p>Notifies <b>terminologyCategory</b> on change.</p>
	 * @param value the terminology category to remove
	 * @return true iff this changes the ExpressionElement.
	 */
	public boolean removeCategory(Category value) {
		Set<Category> oldValue = new HashSet<>(category);
		boolean result = category.remove(value);
		pcs.firePropertyChange("category", oldValue, category);
		return result;
	}

	/**
	 * <p>Removes all terminology categories.</p>
	 * <p>Notifies <b>terminologyCategory</b></p>.
	 */
	public void clearCategory() {
		category.clear();
		pcs.firePropertyChange("category", null, category);
	}
}
