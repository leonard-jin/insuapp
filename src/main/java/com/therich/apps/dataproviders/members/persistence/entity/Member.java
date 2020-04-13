package com.therich.apps.dataproviders.members.persistence.entity;

import com.therich.apps.dataproviders.commons.persistence.mapped.Auditable;
import com.therich.apps.usecase.members.MemberRegisterUseCase;
import lombok.*;

import javax.persistence.*;

/**
 * Created by kh.jin on 2020. 2. 13.
 */
@Entity
@Table(name = "tb_member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Member extends Auditable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(name = "email")
    private String email;

    @Column(name = "member_nm")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "social_id")
    private String socialId;

    @OneToOne
    @JoinColumn(name = "email")
    private Account account;

    public Member(MemberRegisterUseCase.Command command) {
        this.email = command.getEmail();
        this.name = command.getName();
        this.mobile = command.getMobile();
        this.address = command.getAddress();
        this.socialId = command.getSocialId();
    }
}