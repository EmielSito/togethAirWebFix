package com.realdolmen.group7.repository;

import com.realdolmen.group7.AbstractPersistenceTest;
import com.realdolmen.group7.domain.users.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by PMTBF30 on 12/11/2017.
 */
public class UserRepositoryTest extends AbstractPersistenceTest{

    private UserRepository userRepository;

    @Before
    public void initializeRepository() {
        userRepository = new UserRepository();
        userRepository.em = em;
    }

    @Test
    public void save() throws Exception {
        User user = new User();
        user.setEmail("user111@test.com");
        user.setPassword("testtest");
        userRepository.save(user);
        assertNotNull(user.getId());
    }

    @Test
    public void findByEmail() throws Exception {
        User user = userRepository.findByEmail("sara@home.net");
        assertEquals("98745", user.getPassword());
    }

    @Test
    public void findById() throws Exception {
        User user = em.find(User.class, 1000L);
        assertEquals("abc@def.com", user.getEmail());
        assertEquals("12345", user.getPassword());
    }

}