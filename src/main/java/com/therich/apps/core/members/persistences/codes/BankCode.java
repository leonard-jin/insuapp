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
 * Created by kh.jin on 2020. 2. 16.
 */
@Getter
public enum BankCode {

    KB("031", "국민은행")
    ,
    ;

    private String code;
    private String value;

    BankCode(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private final static Map<String,BankCode> map = Stream.of(BankCode.values()).collect(Collectors.toMap(BankCode::getCode, Function.identity()));

    public static BankCode from(String code) {
        return Optional.ofNullable(map.get(code)).orElseThrow(() -> new BusinessException(BusinessErrorCode.EMPTY));
    }
}