package com.iredko.gwent.data;

import java.util.List;

public interface ColumnFilter<T> {
    String getQueryPart();
    List<T> getParametersToSet();
}
