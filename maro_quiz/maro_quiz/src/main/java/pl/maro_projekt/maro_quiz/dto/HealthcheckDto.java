package pl.maro_projekt.maro_quiz.dto;

//public class HealthcheckDto {
//    private boolean status;
//    private String message;
//
//    public HealthcheckDto(boolean status, String message) {
//        this.status = status;
//        this.message = message;
//    }
//
//    public boolean isStatus() {
//        return status;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//}

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HealthcheckDto {
    private boolean status;
    private String message;
}
