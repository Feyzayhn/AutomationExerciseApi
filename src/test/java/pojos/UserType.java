package pojos;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserType {

  private String userType;
}



/*
     "responseCode": 200,
        "products": [
            {
                "id": 1,
                "name": "Blue Top",
                "price": "Rs. 500",
                "brand": "Polo",
                "category": {
                    "usertype": {
                        "usertype": "Women"
                    },
                    "category": "Tops"
                }
            },
     */