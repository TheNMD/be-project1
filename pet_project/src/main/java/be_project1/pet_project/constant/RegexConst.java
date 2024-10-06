package be_project1.pet_project.constant;

public class RegexConst {
    public static final String ID       = "\\d+";

    public static final String USERNAME = "[a-zA-Z0-9.]+";

    public static final String NAME     = "[a-zA-Z0-9. ]+";

    public static final String PASSWORD = ".*\\s.*";

    public static final String RATING   = "[-+]?\\d*(\\.\\d+)?";

    // yyy-mm-dd hh:mm:ss
    public static final String DATETIME = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$";

    private RegexConst() {}
}
