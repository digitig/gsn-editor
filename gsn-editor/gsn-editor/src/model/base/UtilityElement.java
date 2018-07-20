package model.base;

import java.util.Optional;

public abstract class UtilityElement extends SacmElement {
	Optional<MultiLangString> content;
	
	
	public UtilityElement() {
		content = Optional.empty();
	}
	
	public Optional<MultiLangString> getContent() {
		return content;
	}
	
	public void setContent(Optional<MultiLangString> value) {
		Optional<MultiLangString> oldValue = content;
		content = value;
		pcs.firePropertyChange("content", oldValue, content);
	}
}
