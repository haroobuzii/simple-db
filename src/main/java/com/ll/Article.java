package com.ll;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

// article 테이블의 한 행(row)을 담는 클래스
// 필드 이름을 테이블 컬럼 이름과 똑같이 맞춰 두면, Sql.selectRow(Article.class) 가 알아서 채워준다
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Article {
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String title;
    private String body;
    private boolean isBlind; // Lombok 이 getter 를 isBlind() 로 만들어 준다
}
