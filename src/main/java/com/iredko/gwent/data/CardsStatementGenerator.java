package com.iredko.gwent.data;



import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardsStatementGenerator implements StatementGenerator{

    private String sql;
    private List<Object> parametersToSet;

    @Override
    public PreparedStatement generate(Connection conn, List<ColumnFilter> filters) throws SQLException {
        generateQuery(filters);
        PreparedStatement stmt = conn.prepareStatement(sql);
        for(int i=0;i<parametersToSet.size();i++) {
            stmt.setString(i+1,parametersToSet.get(i).toString());
        }
        return stmt;
    }

    private void generateQuery(List<ColumnFilter> filters) {
        sql = "select * from webapp.cards where 1=1";
        parametersToSet = new ArrayList<>();

        for (ColumnFilter filter : filters) {
            sql += "\n AND "+ filter.getQueryPart();
            parametersToSet.addAll(filter.getParametersToSet());
        }
    }

}
