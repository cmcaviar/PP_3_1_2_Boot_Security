package ru.kata.spring.boot_security.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User user) {
        entityManager.merge(user);
    }
    @Override
    @Transactional
    public User findUserByUsername(String username) throws UsernameNotFoundException {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username= :username", User.class);
        query.setParameter("username", username);
        if (username == null) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = query.getSingleResult();
        user.getRoles().size();
        return user;
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(show(id));
    }
}
