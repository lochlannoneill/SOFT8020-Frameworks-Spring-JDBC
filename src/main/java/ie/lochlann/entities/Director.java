package ie.lochlann.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Component //automatically initialised bean???

public class Director {
    private int directorId;
    private String fname;
    private String lname;
    private boolean stillActive;
}
