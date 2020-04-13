package com.therich.apps.dataproviders.members.persistence.entity;

import com.therich.apps.dataproviders.commons.persistence.mapped.Auditable;
import com.therich.apps.globals.codes.MemberStatusCode;
import com.therich.apps.globals.codes.RoleCode;
import com.therich.apps.globals.exceptions.AppsException;
import com.therich.apps.globals.services.encrypt.SHA256EncoderHelper;
import com.therich.apps.globals.services.encrypt.SaltGenerator;
import com.therich.apps.usecase.members.MemberRegisterUseCase;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

/**
 * Created by kh.jin on 2020. 2. 13.
 */
@Entity
@Table(name = "tb_account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "member")
@EqualsAndHashCode(callSuper = false)
public class Account extends Auditable<Long> {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "login_failed_cnt")
    private Integer loginFailedCount;

    @Column(name = "pw_changed_date")
    private LocalDateTime pwChangedDate;

    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;

    //@Convert(converter = RoleCodeConverter.class)
    @Column(name = "role_cd")
    @Enumerated(EnumType.STRING)
    private RoleCode role;

    @Column(name = "account_level")
    private Integer level;

    @Column(name = "status_cd")
    @Enumerated(EnumType.STRING)
    private MemberStatusCode memberStatusCode;

    public Account(MemberRegisterUseCase.Command command) {
        this.email = command.getEmail();
        this.salt = SaltGenerator.generate();
        this.password = this.encypt(command.getPassword(), salt);
        this.loginFailedCount = 0;
        this.lastLoginDate = LocalDateTime.now();
        this.pwChangedDate = LocalDateTime.now();
        this.memberStatusCode = MemberStatusCode.ACTIVE;
        this.role = RoleCode.OWNER;
        this.level = 0;
    }

    private String encypt(String password, String salt) {
        return SHA256EncoderHelper.getInstance().encypt(password, salt);
    }
}
