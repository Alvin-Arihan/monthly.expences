package com.rpy.monthly.expences.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyItems {

    private int id;
    private String name;
    private Category category;

}
