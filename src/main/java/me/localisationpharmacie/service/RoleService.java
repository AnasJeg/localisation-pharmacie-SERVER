package me.localisationpharmacie.service;

import me.localisationpharmacie.DAO.Dao;
import me.localisationpharmacie.entity.Role;
import me.localisationpharmacie.repository.RoleRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements Dao<Role> {

    @Autowired
    private RoleRep roleRep;

    @Override
    public Role save(Role c) {
        return roleRep.save(c);
    }

    @Override
    public Role findById(int id) {
        return roleRep.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleRep.findAll();
    }

    @Override
    public void delete(Role c) {
        roleRep.delete(c);
    }

    @Override
    public void update(Role c) {
        roleRep.save(c);
    }
}
