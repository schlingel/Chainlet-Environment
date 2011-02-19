package at.chainlet.rse.plugin;

/**
 * <p>This is a model class which is used in a client code jar. The RSE interpreter
 * is build upon the principle that the very basics must be enough for the interpreter
 * and everything else - e.g. IFs or LOOPs - are build in client libraries which could
 * be plugged in.</p>
 * <p>Such a plugin is very simple constructed:</p>
 * <pre>
 * + Jar-Root
 * |
 * +- mapping.xml
 * +- class1
 * +- class2
 * +- directory
 *        |
 *        +- class 3
 *        +- class 4
 * ...
 * </pre>
 * <p>The mapping file contains a listing of the classes and the dictionary which contains them. If
 * the JAR-file contains classes which are not mentioned in a dictionary tag, then they are added to the
 * default dictionary. If the mapping doesn't contain a default dictionary the classes get ignored.</p>
 */
public class Mapping {
	/**
	 * The default dictionary for the words without defined dictionary.
	 */
	private String defaultDictionary;
	
	/**
	 * The mappings of the dictionary.
	 */
	private DictionaryMapping[] dictionaryMappings;
	
	/**
	 * Gets the default dictionary.
	 */
	public String getDefaultDictionary() {
		return defaultDictionary;
	}
	
	/**
	 * Sets the default dictionary.
	 * @param dict
	 */
	public void setDefaultDictionary(String dict) {
		defaultDictionary = dict;
	}
	
	/**
	 * Gets the dictionary mappings.
	 * @return mappings
	 */
	public DictionaryMapping[] getDictionaryMappings() {
		return dictionaryMappings;
	}
	
	/**
	 * Sets the dictionary mapping.
	 * @param mappings
	 */
	public void setDictionaryMappings(DictionaryMapping[] mappings) {
		dictionaryMappings = mappings;
	}
}
