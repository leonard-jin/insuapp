package com.therich.apps.dataproviders.persistences.members.entities;

import com.therich.apps.configurations.persistence.Auditable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    @NotBlank
    @Column(name = "email")
    @Getter private String email;

    @NotBlank
    @Column(name = "member_nm")
    @Getter private String name;

    @NotBlank
    @Column(name = "address")
    @Getter private String address;

    @NotBlank
    @Size(min = 11, max = 13)
    @Column(name = "mobile")
    @Getter private String mobile;

    @NotBlank
    @Size(min = 14, max = 14)
    @Column(name = "social_id")
    @Getter private String socialId;
}