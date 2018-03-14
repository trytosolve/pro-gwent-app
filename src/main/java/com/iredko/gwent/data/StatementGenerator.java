package com.iredko.gwent.data;

import java.sql.*;

import java.sql.SQLException;
import java.util.List;

public interface StatementGenerator {
        PreparedStatement generate(Connection conn, List<ColumnFilter> filters) throws SQLException;
}
