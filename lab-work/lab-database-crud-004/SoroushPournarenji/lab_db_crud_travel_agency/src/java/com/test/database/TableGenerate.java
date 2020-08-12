package com.test.database;

import com.test.persistence.Column;
import com.test.persistence.Table;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableGenerate {
    public void createTable(Object object) {
        DBConnection dbConnection = DBConnection.getInstance();
        Connection connection = null;
        try {
            connection = dbConnection.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Table table = object.getClass().getDeclaredAnnotation(Table.class);
        StringBuilder query = new StringBuilder("CREATE TABLE " + table.name() + "(");
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Column) {
                    Column column = field.getAnnotation(Column.class);
                    query.append(column.name() + " " + column.dataType() + "(" + column.length() + "),");
                }

            }
        }
        if (query.toString().trim().endsWith(",")) {
            query.deleteCharAt(query.length() - 1);
        }
        query.append(")");
        System.out.println(query);
        assert connection != null;
        try (PreparedStatement statement = connection.prepareStatement(query.toString())) {
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
