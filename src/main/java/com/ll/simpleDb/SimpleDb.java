package com.ll.simpleDb;

public class SimpleDb {
    private final String host;
    private final String username;
    private final String password;
    private final String dbName;
    private boolean devMode = false;

    public SimpleDb(String host, String username, String password, String dbName) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.dbName = dbName;
    }

    public void setDevMode(boolean devMode) {
        this.devMode = devMode;
    }

    public int run(String sql, Object... params) {
        throw new UnsupportedOperationException("아직 구현 전");
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
}
