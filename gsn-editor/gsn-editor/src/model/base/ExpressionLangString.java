package model.base;

import model.terminology.ExpressionElement;

/**
 * ExpressionLangString is used to denote a structured expression, it contains a 
 * description (LangString) and an ExpressionElement.
 * <h1>Semantics</h1>
 * ExpressionLangString provides a means 
 * for description, it can also be used to link to an ExpressionElement in the
 * Terminology package.
 * @author Tim Rowe
 *
 */
public class ExpressionLangString extends LangString {
	ExpressionElement element;
	/**
	 * Constructor
	 * @param element a reference to an ExpressionElement in the TerminologyPackage
	 * @throws NullPointerException if element is null
	 */
	public ExpressionLangString(ExpressionElement element) throws NullPointerException {
		if (element == null) throw new NullPointerException();
		this.element = element;
	}
	
	/**
	 * a reference to an ExpressionElement in the TerminologyPackage
	 * @return a reference to an ExpressionElement in the TerminologyPackage
	 */
	public ExpressionElement getElement() {
		return element;
	}
	
	/**
	 * a reference to an ExpressionElement in the TerminologyPackage
	 * @param value a reference to an ExpressionElement in the TerminologyPackage
	 */
	public void setElement(ExpressionElement value) {
		if (element == null) throw new NullPointerException();
		this.element = value;
	}
}
