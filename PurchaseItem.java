package com.rpy.monthly.expences.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseItem {

   private String id;
   private List<MonthlyItems> monthlyItems;

    private Month month;
    private Double Amount;

    private String quantity;
    private String unit;
    private boolean select;
    private Double TotalAmount;

}
