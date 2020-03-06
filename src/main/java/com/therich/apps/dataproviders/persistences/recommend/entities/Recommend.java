package com.therich.apps.dataproviders.persistences.recommend.entities;

import com.therich.apps.configurations.persistence.Auditable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by kh.jin on 2020. 3. 4.
 */
@Entity
@Table(name = "tb_recommend")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Recommend extends Auditable<Long> {

    @EmbeddedId
    protected PK id;

    @NotNull
    @Column(name = "pos")
    private Integer pos;


    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PK implements Serializable {
        private static final long serialVersionUID = 1L;

        @NotNull
        @Column(name = "member_no")
        private Long memberNo;

        @NotNull
        @Column(name = "parent_member_no")
        private Long parentMemberNo;
    }
}