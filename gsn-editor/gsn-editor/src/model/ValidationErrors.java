package model;

import java.util.function.Predicate;
import model.base.ModelElement;

public enum ValidationErrors {
	INCONSISTENT_IS_CITATION_ERROR(null),
	INCONSISTENT_IS_ABSTRACT_ERROR(null),
	INCONSISTENT_ABSTRACT_FORM_TYPE_ERROR(null);
	
	private final Predicate<? extends ModelElement> isValid;
	
	ValidationErrors(Predicate<? extends ModelElement> isValid) {
		this.isValid = isValid;
	}

	public Predicate<? extends ModelElement> getIsValid() {
		return isValid;
	}
}
