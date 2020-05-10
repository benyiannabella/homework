package homework8_jdbc;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Accommodation {

    private int id;
    private String type;
    private String bedType;
    private int maxGuests;
    private String description;

}
