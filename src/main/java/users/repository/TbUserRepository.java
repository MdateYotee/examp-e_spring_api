package users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import users.model.TbUser;


public interface TbUserRepository extends JpaRepository<TbUser, Long>{

}
