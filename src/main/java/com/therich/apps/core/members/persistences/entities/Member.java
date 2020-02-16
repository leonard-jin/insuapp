package com.therich.apps.core.members.persistences.entities;

import com.therich.apps.core.members.persistences.codes.BankCode;
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

    @Column(name = "email")
    @Getter private String email;

    @Column(name = "member_nm")
    @Getter private String name;

    @Column(name = "post_cd")
    @Getter private String postCode;

    @Column(name = "address")
    @Getter private String address;

    @Column(name = "mobile")
    @Getter private String mobile;

    @Column(name = "social_id")
    @Getter private String socialId;

    @Column(name = "bank_cd")
    @Getter private BankCode bankCode;

    @Column(name = "bank_account")
    @Getter private String bankAccount;

    @OneToOne
    @JoinColumn(name = "id")
    private Auth auth;

    @OneToOne
    @JoinColumn(name = "id")
    private Account account;

    @Builder
    public Member(String email, String name, String postCode, String address, String mobile, String socialId, BankCode bankCode, String bankAccount) {
        this.email = email;
        this.name = name;
        this.postCode = postCode;
        this.address = address;
        this.mobile = mobile;
        this.socialId = socialId;
        this.bankCode = bankCode;
        this.bankAccount = bankAccount;
    }
}
