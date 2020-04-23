import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class AccommodationToRoomFairRelation {

    private int id;
    private int idAccommodation;
    private int idRoomFair;

}
