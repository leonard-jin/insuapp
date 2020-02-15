package com.therich.apps.core.members.persistences.codes;

import com.therich.apps.globals.exceptions.BusinessException;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kh.jin on 2020. 2. 15.
 */
public enum MemberStatusCode {
    NORMAL(1)
    ,
    DORMANT(2)
    ,
    LOCKED(3)
    ,
    BLOCKED(4)
    ;

    @Getter
    private int code;

    MemberStatusCode(int code) {
        this.code = code;
    }

    private static final Map<Integer, MemberStatusCode> map =
            Stream.of(MemberStatusCode.values()).collect(Collectors.toMap(MemberStatusCode::getCode, Function.identity()));

    public MemberStatusCode from(int code) {
        return Optional.ofNullable(map.get(code)).orElseThrow(() -> new BusinessException());
    }
}
