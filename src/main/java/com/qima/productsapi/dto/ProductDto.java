package com.qima.productsapi.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean available;
    private Boolean obsolete;
    private Integer yearCreation;
    private String serialNumber;
    private String categoryPath;

}
