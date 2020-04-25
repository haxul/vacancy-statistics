package com.posws.enums;

import lombok.Getter;

@Getter
public enum CityNames {
    SAMARA(78), SAINT_PETERSBURG(2), MOSCOW(1);

    private int id;

    CityNames(int id) {
        this.id = id;
    }
}
