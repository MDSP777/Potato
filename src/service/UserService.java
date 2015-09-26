package service;

import javax.persistence.TypedQuery;

import model.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserService extends JpaService {
	public void add(User u){
		openTransaction();
		try{
			entityManager.persist(u);
		} finally {
			closeTransaction();
		}
	}
	
	public User retrieve(int userId){
		openTransaction();
		try{
			TypedQuery<User> q = entityManager.createQuery(
					"Select u from User u where u.id=:userId", User.class)
					.setParameter("userId", userId);
			return q.getSingleResult();
		} finally {
			closeTransaction();
		}
	}
}
