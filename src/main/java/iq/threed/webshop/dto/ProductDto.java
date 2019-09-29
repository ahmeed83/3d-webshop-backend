package iq.threed.webshop.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductDto {

    private Long id;
    private String code;
    private String name;
    private String category;
    private String description;
    private int quantity;
    private byte[] image;
    private double price;
    private Date lastUpdate;

    private Long categoryId;
}
