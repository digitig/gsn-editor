package model.base;

import java.util.Optional;

/**
 * LangString is the format SACM uses for description. It serves the same 
 * purpose as String but with the additional specification of the language 
 * used for the content.
 */
public class LangString {
	Optional<String> lang;
	Optional<String> content;
	
	public LangString() {
		lang = Optional.empty();
		content = Optional.empty();
	}
	
	/**
	 * Get the language of the string.
	 * @return the language of the string
	 */
	public Optional<String> getLang() {
		return lang;
	}
	
	/**
	 * Set the language. 
	 * @param value the language. Whitespace is trimmed.
	 */
	public void setLang(Optional<String> value) {
		lang = value;
	}
	
	/**
	 * Set the language. 
	 * @param value the language. Whitespace is trimmed.
	 */
	public void setLang(String value) {
		setLang(Optional.ofNullable(value));
	}
	
	/**
	 * Get the content of the string.
	 * @return the content of the string
	 */
	public Optional<String> getContent() {
		return content;
	}
	
	/**
	 * Set the content of the string.
	 * @param value the content of the string.
	 */
	public void setContent(Optional<String> value) {
		content = value;
	}
	
	/**
	 * Set the content of the string.
	 * @param value the content of the string.
	 */
	public void setContent(String value) {
		setContent(Optional.ofNullable(value));
	}
}
