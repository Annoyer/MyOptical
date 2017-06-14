package resources.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.dialect.SQLServerDialect;

import java.sql.Types;

/**
 * Created by joy12 on 2017/6/14.
 */
public class MySQLServerDialect extends SQLServerDialect {
    public MySQLServerDialect() {
        super();
        registerColumnType(Types.VARCHAR, "nvarchar($l)");
        registerColumnType(-9, Hibernate.STRING.getName());
    }
}