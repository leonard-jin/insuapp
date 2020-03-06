package com.therich.apps.dataproviders.persistences.members.entities;

import com.therich.apps.configurations.persistence.Auditable;
import com.therich.apps.dataproviders.codes.RoleCode;
import com.therich.apps.dataproviders.codes.converters.RoleCodeConverter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank
    @Id
    @Column(name = "email")
    @Getter private String email;

    @NotBlank
    @Column(name = "password")
    @Getter private String password;

    @NotBlank
    @Column(name = "salt")
    @Getter private String salt;

    @NotNull
    @Column(name = "login_failed_cnt")
    @Getter private Integer loginFailedCount = 0;

    @NotNull
    @Column(name = "pw_changed_date")
    @Getter private LocalDateTime pwChangedDate = LocalDateTime.now();

    @NotNull
    @Column(name = "last_login_date")
    @Getter private LocalDateTime lastLoginDate;

    @NotNull
    @Convert(converter = RoleCodeConverter.class)
    @Column(name = "role_cd")
    @Getter private RoleCode role;

    @NotNull
    @Min(-1)
    @Column(name = "level")
    @Getter private Integer level;

    @Transient
    @Setter
    @Getter private Member member;
}
