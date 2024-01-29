package com.gitlab.rmarzec.framework.w3schools;

public enum CarMake {
    VOLVO("Volvo"),
    SAAB("Saab"),
    OPEL("Opel"),
    AUDI("Audi");

    private final String label;

    CarMake(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
