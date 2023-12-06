package sg.edu.nus.iss.d18lecture.model;

import java.util.Date;

// Reference
// https://medium.com/@himani.prasad016/validations-in-spring-boot-e9948aa6286b
// https://regex101.com/

public class Announcement {

    // required
    // only digits
    private Integer annId;

    // only contains letters [a-zA-Z]
    private String code;

    // required
    // min 10 characters, max 50 characters
    private String title;

    // required
    private String message;

    // date greater that today
    private Date startDate;
}
