package com.therich.apps.dataproviders.members.persistence.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * Created by kh.jin on 2020. 3. 25.
 */
@Data
@Alias("member")
public class MemberVO {
    private String memberNo;
}
