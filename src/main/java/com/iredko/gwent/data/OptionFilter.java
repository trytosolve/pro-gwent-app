package com.iredko.gwent.data;

import java.util.List;

public class OptionFilter<T> implements ColumnFilter {
    private final String columnName;
    private final List<T> possibleValues;

    public OptionFilter(String columnName, List<T> possibleValues) {
        this.columnName = columnName;
        this.possibleValues = possibleValues;
    }

    @Override
    public String getQueryPart() {
        return columnName + " in (" + buildQuestionMark() +")";
    }

    private String buildQuestionMark() {
        StringBuilder marks = new StringBuilder();
        boolean empty = true;
        for (T possibleValue : possibleValues) {
            if (!empty) {
                marks.append(",");
            }
            marks.append("?");
            empty = false;
        }
        return marks.toString();
    }

    @Override
    public List<T> getParametersToSet() {
        return possibleValues;
    }
}
