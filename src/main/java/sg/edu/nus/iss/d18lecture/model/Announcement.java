package sg.edu.nus.iss.d18lecture.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Reference
// https://medium.com/@himani.prasad016/validations-in-spring-boot-e9948aa6286b
// https://regex101.com/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {

    // required
    // only digits
    @NotNull(message = "Announcement ID is required")
    @Digits(fraction = 0, integer = 10000, message = "Numerics only")
    private Integer annId;

    // only contains letters [a-zA-Z]
    @Pattern(regexp = "^[a-zA-Z}*$]", message="Code can only contains alphabets a-z and/or A-Z")
    private String code;

    // required
    // min 10 characters, max 50 characters
    @NotEmpty(message = "Title is required")
    @Size(min=10, max=50, message="Min 10 characters, max 50 characters")
    private String title;

    // required
    @NotEmpty(message = "Message is required")
    private String message;

    // date greater that today
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Date must be a future date")
    private Date startDate;
}
