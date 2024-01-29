package com.gitlab.rmarzec.framework.common;

import java.util.Objects;

public class SelectOption {
    private final String value;
    private final String label;

    public SelectOption(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectOption that = (SelectOption) o;
        return Objects.equals(value, that.value)
                && Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, label);
    }

    @Override
    public String toString() {
        return "SelectedOption{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
