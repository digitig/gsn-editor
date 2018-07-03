package model;

import java.util.function.Predicate;
import model.base.SacmElement;

public enum ValidationErrors {
	INCONSISTENT_IS_CITATION_ERROR(null),
	INCONSISTENT_IS_ABSTRACT_ERROR(null),
	INCONSISTENT_ABSTRACT_FORM_TYPE_ERROR(null);
	
	private final Predicate<? extends SacmElement> isValid;
	
	ValidationErrors(Predicate<? extends SacmElement> isValid) {
		this.isValid = isValid;
	}

	public Predicate<? extends SacmElement> getIsValid() {
		return isValid;
	}
}
