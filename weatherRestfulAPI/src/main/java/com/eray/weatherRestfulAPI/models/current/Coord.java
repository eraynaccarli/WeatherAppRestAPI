package com.eray.weatherRestfulAPI.models.current;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coord {
    private double lat;
    private double lon;

}
