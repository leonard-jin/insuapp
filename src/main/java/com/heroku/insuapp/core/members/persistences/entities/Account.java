package com.heroku.insuapp.core.members.persistences.entities;

import com.heroku.insuapp.globals.persistences.Auditable;
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

    @Column(name = "password")
    @Getter private String password;

    @Column(name = "salt")
    @Getter private String salt;


}
