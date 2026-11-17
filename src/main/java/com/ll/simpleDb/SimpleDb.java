package com.ll.simpleDb;

import java.sql.*;
import java.util.List;

public class SimpleDb {
    private final String url;
    private final String username;
    private final String password;
    private boolean devMode = false;

    private Connection connection;

    public SimpleDb(String host, String username, String password, String dbName) {
        this.url = "jdbc:mysql://%s:3306/%s".formatted(host, dbName);
        this.username = username;
        this.password = password;
    }

    public void setDevMode(boolean devMode) {
        this.devMode = devMode;
    }

    // DDL(CREATE, DROP, TRUNCATE)·DML(INSERT, UPDATE, DELETE) 실행. 영향받은 행 수를 돌려준다
    public int run(String sql, Object... params) {
        return executeUpdate(sql, List.of(params));
    }

    public Sql genSql() {
        return new Sql(this);
    }

    public void startTransaction() {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public void commit() {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public void rollback() {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public void close() {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    // ---------- Sql 이 사용하는 실행 메서드 (같은 패키지에서만 사용) ----------

    // INSERT 실행 후 AUTO_INCREMENT 로 생성된 주키를 돌려준다
    long executeInsert(String sql, List<Object> params) {
        try (PreparedStatement stmt = prepare(sql, params, Statement.RETURN_GENERATED_KEYS)) {
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                return keys.next() ? keys.getLong(1) : 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // UPDATE·DELETE 등 실행 후 영향받은 행 수를 돌려준다
    int executeUpdate(String sql, List<Object> params) {
        try (PreparedStatement stmt = prepare(sql, params, Statement.NO_GENERATED_KEYS)) {
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // SQL 의 ? 자리에 파라미터를 순서대로 채운 PreparedStatement 를 만든다
    // 값을 문자열로 이어 붙이지 않고 바인딩하므로 SQL 인젝션에 안전하다
    private PreparedStatement prepare(String sql, List<Object> params, int generatedKeys) throws SQLException {
        if (devMode) {
            System.out.println("== rawSql ==\n" + sql.trim() + "\n== params == " + params);
        }

        PreparedStatement stmt = getConnection().prepareStatement(sql, generatedKeys);

        for (int i = 0; i < params.size(); i++) {
            stmt.setObject(i + 1, params.get(i)); // JDBC 는 1번부터 센다
        }

        return stmt;
    }

    private Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
        }

        return connection;
    }
}
