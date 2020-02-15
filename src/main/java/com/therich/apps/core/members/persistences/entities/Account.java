package com.therich.apps.core.members.persistences.entities;

import com.therich.apps.core.members.persistences.codes.RoleCode;
import com.therich.apps.globals.persistences.Auditable;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kh.jin on 2020. 2. 13.
 */
@Entity
@Table(name = "tb_account")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Account extends Auditable<Long> {

    @Id
    @Column(name = "member_id")
    @Getter private String id;

    @Column(name = "role_cd")
    private RoleCode role;

    @Column(name = "owner_level")
    private Integer ownerLevel;

    @Column(name = "admin_level")
    private Integer adminLevel;
}
