package com.therich.apps.dataproviders.members.persistence.mapper;

import com.therich.apps.dataproviders.members.persistence.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by kh.jin on 2020. 3. 25.
 */
@Mapper
public interface MemberMapper {

    @Select("select * from tb_member")
    List<MemberVO> selectMembers();
}
