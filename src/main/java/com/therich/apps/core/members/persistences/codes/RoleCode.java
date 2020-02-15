package com.therich.apps.core.members.persistences.codes;

import com.therich.apps.globals.exceptions.BusinessException;
import com.therich.apps.globals.exceptions.codes.BusinessErrorCode;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kh.jin on 2020. 2. 15.
 */
public enum RoleCode {
    OWNER(1)
    ,
    ADMIN(2)
    ;

    @Getter
    private int code;

    RoleCode(int code) {
        this.code = code;
    }

    private static final Map<Integer, RoleCode> map =
            Stream.of(RoleCode.values()).collect(Collectors.toMap(RoleCode::getCode, Function.identity()));

    public RoleCode from(int code) {
        return Optional.ofNullable(map.get(code)).orElseThrow(() -> new BusinessException(BusinessErrorCode.EMPTY));
    }
}
