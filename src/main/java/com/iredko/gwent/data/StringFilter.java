package com.iredko.gwent.data;

import java.util.Collections;
import java.util.List;

public class StringFilter implements ColumnFilter<String> {
    private final String columnName;
    private final String expectedValue;

    public StringFilter(String columnName, String expectedValue) {
        this.columnName = columnName;
        this.expectedValue = expectedValue;
    }

    @Override
    public String getQueryPart() {
        return columnName + "=? ";
    }

    @Override
    public List<String> getParametersToSet() {
        return Collections.singletonList(expectedValue);
    }
}
