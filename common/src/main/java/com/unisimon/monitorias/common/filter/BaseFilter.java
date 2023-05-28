package com.unisimon.monitorias.common.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseFilter {

    private Integer pageNumber = 1;
    private Integer allElements = 10;

}
