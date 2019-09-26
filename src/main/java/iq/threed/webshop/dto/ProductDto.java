package iq.threed.webshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDto {

    private int id;
    private String code;
    private String description;
    private int quantity;
    private byte[] image;
    private double price;
    private Date lastUpdate;

    private int categoryId;
}
