package com.therich.apps.core.members.persistences.entities;

import com.therich.apps.core.members.persistences.codes.MemberStatusCode;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by kh.jin on 2020. 2. 15.
 */
@Entity
@Table(name = "tb_auth")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Auth {

    @Id
    @Column(name = "member_no")
    @Getter private Long no;

    @Column(name = "password")
    @Getter private String password;

    @Column(name = "salt")
    @Getter private String salt;

    @Column(name = "status_cd")
    @Getter private MemberStatusCode status;

    @Column(name = "login_failed_cnt")
    @Getter private Integer loginFailedCount;

    @Column(name = "last_pwd_changed_date")
    @Getter private LocalDateTime lastPasswordChangedDate;

    @Column(name = "last_login_date")
    @Getter private LocalDateTime lastLoginDate;

    @OneToOne(mappedBy = "auth")
    private Member member;
}
