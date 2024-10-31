package com.example.dbservice.service;

import com.example.dbservice.po.UserInfoPO;
import com.example.dbservice.vo.UserInfoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DataAccessService {
    private final JdbcTemplate jdbcTemplate;

    public UserInfoPO getSingleUser(String id) {
        String sql = "SELECT * from user_info WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserInfoPO.class), id);
    }

    public int createUserInfo(UserInfoVO userInfoVO) {

        String sql = "INSERT INTO user_info (first_name, last_name, email, gender, ip_address) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, userInfoVO.getFirstName(), userInfoVO.getLastName(), userInfoVO.getEmail(), userInfoVO.getGender(), userInfoVO.getIpAddress());
    }
}
