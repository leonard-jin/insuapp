package com.therich.apps.dataproviders.recommends.persistence.entity;

import com.therich.apps.dataproviders.commons.persistence.mapped.Auditable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kh.jin on 2020. 3. 4.
 */
@Entity
@Table(name = "tb_recommend")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Recommend extends Auditable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "parent_member_no", insertable = false, updatable = false)
    private Long parentMemberNo;

    @Column(name = "member_no")
    @Getter private Long memberNo;

    @NotNull
    @Column(name = "pos")
    @Getter private Integer pos;


    @Builder
    public Recommend(Long parentMemberNo, Long memberNo, Integer pos) {
        this.parentMemberNo = parentMemberNo;
        this.memberNo = memberNo;
        this.pos = pos;
    }
}