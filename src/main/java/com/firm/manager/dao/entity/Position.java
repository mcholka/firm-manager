package com.firm.manager.dao.entity;

public enum Position {
    OFFICE("Pracownik biurowy"),
    OWNER("Wlasciciel"),
    DIRECTOR("Dyrektor"),
    WORKMAN("Pracownik fizyczny");

    private final String viewName;

    Position(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;

    }
}
