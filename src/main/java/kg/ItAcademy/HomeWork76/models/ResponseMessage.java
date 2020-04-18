package kg.ItAcademy.HomeWork76.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import kg.ItAcademy.HomeWork76.enttities.Confirmation;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ResponseMessage<T> {
    Boolean status;
    String message;
    T json;
}
