package com.bookstore.repositories;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bookstore.models.User;

public interface UserRepository extends JpaRepository<User, String>
{
	@Modifying
	@Transactional
	@Query("update User set password=:pass where userid=:uid")
	void updatePassword(@Param("pass") String pa,@Param("uid") String id);
}
