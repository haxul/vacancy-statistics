package com.posws.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum PositionTypes {
    JAVA, PYTHON, JAVASCRIPT, PRODUCT_MANAGER("менеджер проектов");

    private String detailedName = null;

    PositionTypes(String detailedName) {
        this.detailedName = detailedName;
    }

}
