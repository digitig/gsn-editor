package model.terminology;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The Expression class is used to model both abstract and concrete phrases in SACM. Abstract 
 * Expressions are denoted by the inherited isAbstract:Boolean attribute being set true. A concrete 
 * expression (denoted by isAbstract:Boolean being false) is one that has a literal string value and 
 * references only concrete ExpressionElements.
 * <h1>Semantics</h1>
 * Expressions are used to model phrases and sentences. These are defined using the value property. 
 * Alternatively, the expression can also be defined (using the value property) as a production rule 
 * involving other ExpressionElements. In this case, the value must use a suitable (string) form for 
 * denoting the position of involved ExpressionElements (e.g., “$<ExpressionElement.name>$”) within 
 * the production rule, and expressing production rule operators (e.g., Extended Backus-Naur Form 
 * operators).
 * <h1>Constraints</h1>
 * <p>Where an Expression has associated ExpressionElements (the +element property), these should 
 * be referenced by name within the +value property.</p>
 * <p>Where the +value property references ExpressionElement by name, these ExpressionElements 
 * should be associated (using the +element property) with Expression. A concrete expression should 
 * have references to only concrete ExpressionElements.</p>
 * 
 * @author Tim Rowe
 *
 */
public class Expression extends ExpressionElement {
	Set<ExpressionElement> element;
	
	/**
	 * Constructor
	 */
	public Expression() {
		element = new HashSet<>();
	}
	
	public Set<ExpressionElement> getElement() {
		return Collections.unmodifiableSet(element);
	}
	
	public boolean addElement(ExpressionElement value) {
		Set<ExpressionElement> oldValue = new HashSet<>(element);
		boolean result = element.add(value);
		pcs.firePropertyChange("element", oldValue, element);
		return result;
	}
	
	public boolean removeElement(ExpressionElement value) {
		Set<ExpressionElement> oldValue = new HashSet<>(element);
		boolean result = element.remove(value);
		pcs.firePropertyChange("element", oldValue, element);
		return result;
	}
	
	public void clearElement() {
		Set<ExpressionElement> oldValue = new HashSet<>(element);
		element.clear();
		pcs.firePropertyChange("element", oldValue, element);
	}
}
