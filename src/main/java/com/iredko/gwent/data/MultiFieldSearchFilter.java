package com.iredko.gwent.data;

import java.util.ArrayList;
import java.util.List;

public class MultiFieldSearchFilter implements ColumnFilter{
    private List<String> listColumnsName;
    private String expectedValue;

    public MultiFieldSearchFilter(List<String> listColumnsName, String expectedValue) {
        this.listColumnsName = listColumnsName;
        this.expectedValue = expectedValue;
    }

    @Override
    public String getQueryPart() {
        String result = "( ";
        boolean empty = true;
        for(int i=0;i<listColumnsName.size();i++) {
            if (!empty) {
                result = result + " or ";
            }
            result = result + listColumnsName.get(i) + " like concat('%', ?, '%')";
            empty=false;
        }
        result = result + " )";
        return result;
    }

    @Override
    public List<String> getParametersToSet() {
        List<String> list = new ArrayList<>();
        for(int i=0; i<listColumnsName.size(); i++) {
            list.add(expectedValue);
        }
        return list;
    }
}



