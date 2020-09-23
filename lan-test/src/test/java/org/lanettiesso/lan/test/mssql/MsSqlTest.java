package org.lanettiesso.lan.test.mssql;

import org.junit.Test;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Arrays;

/**
 * @author lan
 * @date 2020/9/23
 */
public class MsSqlTest {
    DataSource dataSource = dataSource();

    @Test
    public void generatedKey() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement stmt = connection.createStatement();
        String SQL = "insert into sys_role(role_name) values ('x')";
        int count = stmt.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        if (rs.next()) {
            do {
                for (int i = 1; i <= columnCount; i++) {
                    String key = rs.getString(i);
                    System.out.println("KEY " + i + " = " + key);
                }
            } while (rs.next());
        } else {
            System.out.println("NO KEYS WERE GENERATED.");
        }
    }

    /**
     * <a href="https://github.com/Microsoft/mssql-jdbc/issues/245">Github issue</a>
     *
     * @throws SQLException SQLException
     */
    @Test
    public void batchTest() throws SQLException {
        DataSource dataSource = dataSource();
        Connection connection = dataSource.getConnection();
        Statement stmt = connection.createStatement();
        stmt.addBatch("insert into sys_role(role_name) values ('x')");
        stmt.addBatch("insert into sys_role(role_name) values ('x')");
        stmt.addBatch("insert into sys_role(role_name) values ('x')");
        stmt.addBatch("insert into sys_role(role_name) values ('x')");
        int[] updateCounts = stmt.executeBatch();
        System.out.println(Arrays.toString(updateCounts));
        ResultSet rs = stmt.getGeneratedKeys();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        if (rs.next()) {
            do {
                for (int i = 1; i <= columnCount; i++) {
                    String key = rs.getString(i);
                    System.out.println("KEY " + i + " = " + key);
                }
            } while (rs.next());
        } else {
            System.out.println("NO KEYS WERE GENERATED.");
        }
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
