package com.example.dataroutetest;

import com.example.dataroutetest.domain.User;
import com.example.dataroutetest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DataSourceRoutingTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional(readOnly = true) // slave 데이터소스 사용
    void testSlaveDataSource() {
        List<User> users = userMapper.findAll();
        assertThat(users).hasSize(2);
        assertThat(users.get(0).getName()).startsWith("Slave");
    }

    @Test
    @Transactional // master 데이터소스 사용
    void testMasterDataSource() {
        List<User> users = userMapper.findAll();
        assertThat(users).hasSize(2);
        assertThat(users.get(0).getName()).startsWith("Master");
    }
}
