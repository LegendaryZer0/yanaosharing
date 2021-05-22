package ru.itis.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvailibleSearchDto {
    private Double xCor;
    private Double yCor;
    private String nameOfOrg;
    private String descrOfOrg;

}
