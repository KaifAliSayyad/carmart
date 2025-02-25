package carmart.db;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class DBConnection {
    private static JdbcRowSet rs;
    private static String url = "jdbc:postgresql://localhost:5432/carmartdb";
    private static String uname = "postgres";
    private static String pass = "tiger";

    public static JdbcRowSet getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            rs = RowSetProvider.newFactory().createJdbcRowSet();;
            rs.setUrl(url);
            rs.setUsername(uname);
            rs.setPassword(pass);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public static void closeConnection() {
        try {
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
