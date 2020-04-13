package com.therich.apps.dataproviders.commons.persistence.converter;

import com.therich.apps.globals.codes.RoleCode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by kh.jin on 2020. 3. 2.
 */
@Converter
public class RoleCodeConverter implements AttributeConverter<RoleCode, Integer> {

    @Override
    public Integer convertToDatabaseColumn(RoleCode roleCode) {
        return null;
    }

    @Override
    public RoleCode convertToEntityAttribute(Integer code) {
        return RoleCode.from(code);
    }
}
