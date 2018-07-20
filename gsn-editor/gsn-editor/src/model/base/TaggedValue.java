package model.base;

/**
 * This class represents a simple key/value pair that can be attached to any element in 
 * SACM. This is a simple extension mechanism to allow users to add attributes to each 
 * element beyond those already specified in SACM.
 * <h1>Semantics</h1>
 * TaggedValues can be used to specify attributes, and their corresponding values, for 
 * ModelElements.
 * 
 * @author Tim Rowe
 *
 */
public class TaggedValue extends UtilityElement {
	MultiLangString key;
	
	public TaggedValue(MultiLangString key) {
		this.key = key;
	}
	
	/**
	 * Get the key of the TaggedValue.
	 * @return the key of the TaggedValue.
	 */
	public MultiLangString getKey() {
		return key;
	}
	
	/**
	 * <p>Set the key of the TaggedValue.</p>
	 * <p>Notifies <b>key</b> on change.</p>
	 * @param value the key of the TaggedValue.
	 */
	public void setKey(MultiLangString value) {
		MultiLangString oldValue = key;
		key = value;
		pcs.firePropertyChange("key", oldValue, key);
	}

}
