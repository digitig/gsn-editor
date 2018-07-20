package model.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * MultiLangString, as its name suggests, provides a means to describe things 
 * using different languages.
 * <h1>Semantics</h1>
 * MultiLangString provides a means to describing things using different languages. 
 * It contains a list of ExpressionLangString, with which the user can specify their 
 * languages and the descriptions in the languages.
 * <h1>Constraints</h1>
 * For each of the ExpressionLangString in the value property, their +lang must be unique.
 * @author Tim Rowe
 *
 */
public class MultiLangString {
	// TODO implement INotifier
	Map<String, String> value;
	
	public MultiLangString() {
		value = new HashMap<>();
	}
	
	/**
	 * Get the LangStrings in the MultiLangString. Rather than returning a set of
	 * LangString, per the SACM, this returns a dictionary mapping from language to 
	 * the LangString content. Contrary to the SACM, there may be no LangStrings.
	 * @return a dictionary of mappings from language identifiers to content strings
	 */
	public Map<String, String> getValue() {
		return Collections.unmodifiableMap(value);
	}
	
	/**
	 * Get the LangString for a specific language. If there is no such LangString, returns
	 * a LangString with content not present.
	 * @param lang the language required
	 * @return the LangString corresponding to the required language
	 */
	public LangString getValue(String lang) {
		LangString result = new LangString();
		result.setLang(lang);
		result.setContent(value.get(lang));
		return result;
	}
	
	/**
	 * <p>Add a LangString to the MultiLangString. If an entry with the same language
	 * specifier already exists (case sensitive) it will be silently overwritten.</p>
	 * 
	 * @param value the LangString to add.
	 */
	public void addLangString(LangString value) {
		this.value.put(value.getLang().get(), value.getContent().get());
		
	}
	
	/**
	 * Add a (language, content) pair as a LangString.
	 * @param lang the language of the entry
	 * @param content the content of the entry
	 */
	public void addLangString(String lang, String content) {
		value.put(lang, content);
	}
}
