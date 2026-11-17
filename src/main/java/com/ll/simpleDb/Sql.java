package com.ll.simpleDb;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// SQL 문장을 조각조각 이어 붙이고(append), 마지막에 실행하는 객체
// 예) simpleDb.genSql().append("SELECT * FROM article").append("WHERE id = ?", 1).selectRow()
public class Sql {
    private final SimpleDb simpleDb;
    private final StringBuilder sqlBuilder = new StringBuilder();
    private final List<Object> params = new ArrayList<>();

    Sql(SimpleDb simpleDb) {
        this.simpleDb = simpleDb;
    }

    // SQL 조각과 그 조각의 ? 에 들어갈 값들을 추가한다. 자기 자신을 돌려주므로 .append().append() 로 이어 쓸 수 있다
    public Sql append(String sqlPart, Object... params) {
        sqlBuilder.append(sqlPart).append('\n');
        this.params.addAll(Arrays.asList(params));
        return this;
    }

    public Sql appendIn(String sqlPart, Object... params) {
        throw new UnsupportedOperationException("아직 구현 전");
    }

    public long insert() {
        return simpleDb.executeInsert(getSql(), params);
    }

    public int update() {
        return simpleDb.executeUpdate(getSql(), params);
    }

    public int delete() {
        return simpleDb.executeUpdate(getSql(), params);
    }

    public List<Map<String, Object>> selectRows() {
        return simpleDb.executeSelect(getSql(), params);
    }

    // 첫 번째 행만. 결과가 없으면 null
    public Map<String, Object> selectRow() {
        List<Map<String, Object>> rows = selectRows();

        return rows.isEmpty() ? null : rows.getFirst();
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

    private String getSql() {
        return sqlBuilder.toString();
    }
}
