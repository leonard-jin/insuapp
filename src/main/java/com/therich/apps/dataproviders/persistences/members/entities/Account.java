package com.therich.apps.dataproviders.persistences.members.entities;

import com.therich.apps.configurations.persistence.Auditable;
import com.therich.apps.dataproviders.codes.RoleCode;
import com.therich.apps.dataproviders.codes.converters.RoleCodeConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by kh.jin on 2020. 2. 13.
 */
@Entity
@Table(name = "tb_account")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "member")
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

    @Convert(converter = RoleCodeConverter.class)
    @Column(name = "role_cd")
    @Getter private RoleCode role;

    @Column(name = "level")
    @Getter private Integer level;

    @Transient
    @Setter
    @Getter private Member member;
}
