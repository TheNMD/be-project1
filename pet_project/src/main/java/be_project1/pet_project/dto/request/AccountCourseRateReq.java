package be_project1.pet_project.dto.request;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import be_project1.pet_project.constant.RegexConst;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountCourseRateReq {
    @NotNull(message = "Rating cannot be null")
    @PositiveOrZero(message = "Rating must be greater than zero")
    private double rating;

    @Pattern(regexp = RegexConst.DATETIME, message = "Timestamp must be yyyy-mm-dd hh:mm:ss")
    private String createdDate;
    
    @Pattern(regexp = RegexConst.DATETIME, message = "Timestamp must be yyyy-mm-dd hh:mm:ss")
    private String updatedDate;
}
