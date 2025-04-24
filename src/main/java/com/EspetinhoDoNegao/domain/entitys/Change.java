package com.EspetinhoDoNegao.domain.entitys;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Change {
    private boolean needChange;
    private BigDecimal changeValue;
}
