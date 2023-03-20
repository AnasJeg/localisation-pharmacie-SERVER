package me.localisationpharmacie.service;

import me.localisationpharmacie.DAO.Dao;
import me.localisationpharmacie.entity.User;
import me.localisationpharmacie.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements Dao<User> {

    @Autowired
    private UserRep userRep;
    @Override
    public User save(User c) {
        return userRep.save(c);
    }

    @Override
    public User findById(int id) {
        return userRep.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRep.findAll();
    }

    @Override
    public void delete(User c) {
            userRep.delete(c);
    }

    @Override
    public void update(User c) {
            userRep.save(c);
    }
}
