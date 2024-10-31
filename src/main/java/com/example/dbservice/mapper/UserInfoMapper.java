package com.example.dbservice.mapper;
import com.example.dbservice.po.UserInfoPO;
import com.example.dbservice.vo.UserInfoVO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {
    @Mapping(target = "id", ignore = true)
    UserInfoPO toUserInfoPO(UserInfoVO userInfoVO);


}
