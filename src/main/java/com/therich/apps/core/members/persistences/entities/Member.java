package com.therich.apps.core.members.persistences.entities;

import com.therich.apps.globals.persistences.Auditable;
import lombok.*;

import javax.persistence.*;

/**
 * Created by kh.jin on 2020. 2. 13.
 */
@Entity
@Table(name = "tb_member")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Member extends Auditable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    @Getter
    private Long no;

    @Column(name = "member_id")
    @Getter private String id;

    @Column(name = "member_nm")
    @Getter private String name;

    @Column(name = "post_cd")
    @Getter private String postCode;

    @Column(name = "address")
    @Getter private String address;

    @Column(name = "mobile")
    @Getter private String mobile;

    @Column(name = "social_secret_id")
    @Getter private String socialSecretId;
}
