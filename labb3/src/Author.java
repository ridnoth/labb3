/**
 *
 * @author Hampus Glantz and Fatih Yalcin
 */
public class Author implements java.io.Serializable {

    private String name;

    public Author(String name) {
        this.name = name;
    }
/**
 *Returns one Authors name
 */
    public String getAuthor() {
        return name;
    }
}
