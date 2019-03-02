package pl.piotrschodzinski.codeschool.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbUtil {
    private static final String CTX_NAME = "java:comp/env/jdbc/school";

    private static DataSource ds;

    public static Connection getConn() throws SQLException, ClassNotFoundException {
        String className = "com.mysql.cj.jdbc.Driver";
        Class.forName(className);
        return getInstance().getConnection();
    }

    private static DataSource getInstance() {
        if (ds == null) {
            try {
                Context ctx = new InitialContext();
                ds = (DataSource) ctx.lookup(CTX_NAME);
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return ds;
    }
}