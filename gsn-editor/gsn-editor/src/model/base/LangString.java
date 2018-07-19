package model.base;

import java.util.Optional;

/**
 * LangString is the format SACM uses for description. It serves the same purpose as String but with the 
 * additional specification of the language used for the content.
 * <h1>Semantics</h1>
 * LangString serves the same purpose as String, SACM uses LangString for description, which contains the 
 * information of the language it uses in the content.
 * @author Tim Rowe
 *
 */
public class LangString {
	Optional<String> lang;
	Optional<String> content;
	
	/**
	 * Default constructor
	 */
	public LangString() {
		lang = Optional.empty();
		content = Optional.empty();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof LangString)) return false;
		LangString langString = (LangString)obj;
		return langString.lang == this.lang && langString.content == this.content;
	}
	
	@Override
	public int hashCode() {
		return lang.hashCode() + content.hashCode();
	}
	
	/**
	 * a field to indicate the language used in the string.
	 * @return a field to indicate the language used in the string.
	 */
	public Optional<String> getLang() {
		return lang;
	}

	/**
	 * a field to indicate the language used in the string.
	 * @param value a field to indicate the language used in the string.
	 */
	public void setLang(String value) {
		lang = Optional.ofNullable(value);
	}
	
	/**
	 * a field to indicate the language used in the string.
	 * @param value a field to indicate the language used in the string.
	 */
	public void setLang(Optional<String> value) {
		lang = value;
	}
	
	/**
	 * the content of the string
	 * @return the content of the string
	 */
	public Optional<String> getContent() {
		return content;
	}
	
	/**
	 * the content of the string
	 * @param value the content of the string
	 */
	public void setContent(String value) {
		content = Optional.ofNullable(value);
	}
	
	/**
	 * the content of the string
	 * @param value the content of the string
	 */
	public void setContent(Optional<String> value) {
		content = value;

	}
}
