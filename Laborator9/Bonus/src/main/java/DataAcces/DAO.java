package DataAcces;

import ObjModel.Entity;

import java.sql.SQLException;

public abstract class DAO {
    public abstract Entity findById(int id) throws SQLException;
    public abstract Entity findByName(String name) throws SQLException;
}
