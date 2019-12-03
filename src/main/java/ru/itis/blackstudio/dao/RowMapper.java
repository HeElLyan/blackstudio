package ru.itis.blackstudio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface RowMapper<T> {
    T rowMap(ResultSet resultSet) throws SQLException;
}
