package org.lanettiesso.lan.test.mssql;

import org.junit.Test;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author lan
 * @date 2020/9/23
 */
public class MsSqlTest {

    @Test
    public void batchTest() throws SQLException {
        DataSource dataSource = dataSource();
        Connection connection = dataSource.getConnection();
        Statement stmt = connection.createStatement();
        stmt.addBatch("INSERT INTO TestTable (Col2, Col3) VALUES ('X', 100)");
        stmt.addBatch("INSERT INTO TestTable (Col2, Col3) VALUES ('Y', 200)");
        stmt.addBatch("INSERT INTO TestTable (Col2, Col3) VALUES ('Z', 300)");
        int[] updateCounts = stmt.executeBatch();
    }

    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.microsoft.sqlserver.jdbc.SQLServerDriver.class);
        dataSource.setUrl("jdbc:sqlserver://10.20.3.1:1433;DatabaseName=HEQS");
        dataSource.setUsername("sa");
        dataSource.setPassword("hjk123");

        return dataSource;
    }
}
