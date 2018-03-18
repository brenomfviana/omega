/*
 * GLP-3.0 License.
 */
package omegaserver.domain;

/**
 *
 * @author Breno Viana
 * @author Murilo Bento
 */
public enum Language {

    UNKNOW("", ""),
    DUTCH("nl", "Nederlands"),
    ENGLISH("en", "English"),
    FRENCH("fr", "Français"),
    GERMAN("de", "Deutsch"),
    ITALIAN("it", "Italiano"),
    SPANISH("es", "Español"),
    BRAZILIAN_PORTUGUESE("pt_br", "Português Brasileiro");

    // Language ID
    private String id;
    // Language Name
    private String name;

    private Language(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
