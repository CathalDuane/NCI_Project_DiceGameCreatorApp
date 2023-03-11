package com.app.RollToo;

import static org.assertj.core.api.Assertions.assertThat;
import com.app.RollToo.entity.User;
import com.app.RollToo.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("testUser@gmail.com");
        user.setPassword("password");
        user.setUsername("TestUser");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindByEmail(){
        String email = "user1@gmail.com";

        User user = repo.findByEmail(email);

        assertThat(user).isNotNull();
    }

    @Test
    public void testFindByEmailFail(){
        String email = "1user1@gmail.com";

        User user = repo.findByEmail(email);

        assertThat(user).isNotNull();
    }

}
