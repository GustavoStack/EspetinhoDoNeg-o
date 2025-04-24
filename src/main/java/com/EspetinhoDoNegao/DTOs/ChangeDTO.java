package com.EspetinhoDoNegao.DTOs;

import java.math.BigDecimal;

public record ChangeDTO(boolean needChange, BigDecimal changeValue) {

}
