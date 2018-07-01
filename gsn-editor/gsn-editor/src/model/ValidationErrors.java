package model;

public enum ValidationErrors {
	INCONSISTENT_IS_CITATION_ERROR("SacmElement.1"),
	INCONSISTENT_IS_ABSTRACT_ERROR("SacmElement.2"),
	INCONSISTENT_ABSTRACT_FORM_TYPE_ERROR("SacmElement.3");
	
	private final String id;
	
	ValidationErrors(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
