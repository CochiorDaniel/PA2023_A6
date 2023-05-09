package DataAcces;

import ObjModel.Artist;
import ObjModel.Entity;

import java.sql.*;

public abstract class DAO {
    public abstract Entity findById(int id) throws SQLException;
    public abstract Entity findByName(String name) throws SQLException;
}
