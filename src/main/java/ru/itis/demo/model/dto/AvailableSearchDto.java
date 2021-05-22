package ru.itis.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvailableSearchDto {
    private Double xсor;
    private Double yсor;
    private String nameOfOrg;
    private String descrOfOrg;

}
