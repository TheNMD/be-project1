package be_project1.pet_project.constant;

public class RegexConst {

    // Login DTO
    public static final String USERNAME = "^[a-zA-Z0-9]+$"; // No special characters
    public static final String PASSWORD = "^(?!.*\\s).+$"; // No spaces

    // CRUD DTO
    public static final String NAME     = "^[a-zA-Z0-9 ]+$"; // No special characters except for spaces
    public static final String STATUS   = "^(active|inactive)$";
    public static final String TYPE   = "^(video|docx|pdf|slide)$";
    public static final String URL      = "^(https?:\\/\\/)?([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})(:[0-9]{1,5})?(\\/.*)?$";
    public static final String DATETIME = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$"; // yyyy-mm-dd hh:mm:ss

    public static final String RATING   = "\\d*(\\.\\d+)?";

    private RegexConst() {}
}
