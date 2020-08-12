package com.test.database;

import com.test.persistence.Column;
import com.test.persistence.Id;
import com.test.persistence.Table;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUD {
    DBConnection dbConnection = null;
    Connection connection = null;

    public void save(Object object) throws IllegalAccessException, SQLException, IOException, ClassNotFoundException {
        StringBuilder query = new StringBuilder("insert into ");
        Table table = object.getClass().getDeclaredAnnotation(Table.class);
        query.append(table.name() + "(");
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                query.append(column.name() + ",");
            }
        }
        editQuery(query);
        query.append(") VALUES(");
        for (Field field : fields) {
            if (field.getType().getSimpleName().endsWith("String")) {
                query.append("'" + field.get(object) + "',");
            } else {
                query.append(field.get(object) + ",");
            }
        }
        editQuery(query);
        query.append(")");
        System.out.println(query);
        dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query.toString());
        statement.execute();

    }

    private void editQuery(StringBuilder query) {
        if (query.toString().trim().endsWith(",")) {
            query.deleteCharAt(query.length() - 1);
        }
    }

    public void update(Object object) throws IllegalAccessException, SQLException, IOException, ClassNotFoundException {
        Table table = object.getClass().getDeclaredAnnotation(Table.class);
        StringBuilder query = new StringBuilder("UPDATE " + table.name() + " SET ");
        Field[] fields = object.getClass().getDeclaredFields();
        Object id2 = null;
        String idColumn = null;
        for (Field field : fields) {
            field.setAccessible(true);
            Column column = field.getDeclaredAnnotation(Column.class);
            Id id = field.getDeclaredAnnotation(Id.class);
            if (id != null) {

                id2 = field.get(object);
                idColumn = field.getName();
            } else if (column != null) {
                if (field.getType().getSimpleName().endsWith("String")) {
                    query.append(column.name() + "='" + field.get(object) + "',");
                } else {
                    query.append(column.name() + "=" + field.get(object) + ",");
                }
            }
        }

        editQuery(query);
        query.append("WHERE " + idColumn + " = " + id2);
        System.out.println(query);
        dbConnection = DBConnection.getInstance();
        connection = dbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query.toString());
        statement.executeUpdate();
    }
}
