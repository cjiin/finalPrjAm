package com.kh.finalPrjAm.entity;

import com.kh.finalPrjAm.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // JPA에 Entity 클래스 임을 알려줌, Entity는 반드시 기본키가 있어야 함.
@Getter @Setter @ToString
public class Item {
    @Id // 해당 키가 Primary Key 임을 지정
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO) // JPA 구현체의 생성 전략을 따름
    private Long id; // Primary Key

    @Column(nullable = false, length = 50) // null 허용 안하고 길이 50 제한
    private String itemNm; // 상품 코드

    @Column(nullable = false)
    private int price; // 가격

    @Column(nullable = false)
    private int stockNumber; // 재고수량

    @Lob // 기존 문자열보다 더 긴 문자열 사용할 때 추가
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; // 상품 판매 상태
    private LocalDateTime regTime; //등록 시간
    private LocalDateTime updateTime; //수정 시간
}
