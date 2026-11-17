package com.ll.simpleDb;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Sql {
    private final SimpleDb simpleDb;

    Sql(SimpleDb simpleDb) {
        this.simpleDb = simpleDb;
    }

    public Sql append(String sqlPart, Object... params) {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public Sql appendIn(String sqlPart, Object... params) {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public long insert() {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public int update() {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public int delete() {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public List<Map<String, Object>> selectRows() {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public Map<String, Object> selectRow() {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public <T> List<T> selectRows(Class<T> cls) {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public <T> T selectRow(Class<T> cls) {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public LocalDateTime selectDatetime() {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public Long selectLong() {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public List<Long> selectLongs() {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public String selectString() {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public Boolean selectBoolean() {
        throw new UnsupportedOperationException("아직 구현 전");
    }
}
