package com.therich.apps.globals.codes;


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
    OWNER("ROLE_OWNER")
    ,
    ADMIN("ROLE_ADMIN")
    ;

    @Getter
    private String code;

    RoleCode(String code) {
        this.code = code;
    }

    private static final Map<String, RoleCode> map =
            Stream.of(RoleCode.values()).collect(Collectors.toMap(RoleCode::getCode, Function.identity()));

    public static RoleCode from(int code) {
        return Optional.ofNullable(map.get(code)).orElseThrow(() -> new BusinessException(BusinessErrorCode.NO_DATA));
    }
}
