package com.therich.apps.dataproviders.persistences.members.entities;

import com.therich.apps.configurations.persistence.Auditable;
import lombok.*;

import javax.persistence.*;

/**
 * Created by kh.jin on 2020. 2. 13.
 */
@Entity
@Table(name = "tb_member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class Member extends Auditable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    @Getter
    private Long memberNo;

    @Column(name = "email")
    @Getter private String email;

    @Column(name = "member_nm")
    @Getter private String name;

    @Column(name = "address")
    @Getter private String address;

    @Column(name = "mobile")
    @Getter private String mobile;

    @Column(name = "social_id")
    @Getter private String socialId;
}