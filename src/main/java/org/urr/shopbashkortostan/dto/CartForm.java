package org.urr.shopbashkortostan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartForm {
    private BigDecimal price;
    private String Text;
    private int density;
    private String mark;
    private float height;
}
