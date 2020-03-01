package com.therich.apps.core.members.persistences.entities;

import com.therich.apps.configurations.persistence.Auditable;
import com.therich.apps.core.members.codes.RoleCode;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by kh.jin on 2020. 2. 13.
 */
@Entity
@Table(name = "tb_account")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class Account extends Auditable<Long> {

    @Id
    @Column(name = "email")
    @Getter private String email;

    @Column(name = "password")
    @Getter private String password;

    @Column(name = "salt")
    @Getter private String salt;

    @Column(name = "login_failed_cnt")
    @Getter private Integer loginFailedCount = 0;

    @Column(name = "pw_changed_date")
    @Getter private LocalDateTime pwChangedDate = LocalDateTime.now();

    @Column(name = "last_login_date")
    @Getter private LocalDateTime lastLoginDate;

    @Column(name = "role_cd")
    @Getter private RoleCode role;

    @Column(name = "level")
    @Getter private Integer level;
}
