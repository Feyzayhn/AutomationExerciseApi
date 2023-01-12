package pojos;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Brand {

    private int id;
    public String brand;
}
