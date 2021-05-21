package ru.itis.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CriterySearchDto {
    private Long minPrice;
    private Long maxPrice;
    private String serviceName;
}
