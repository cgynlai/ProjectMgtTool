package com.cyl.ppmtooljava.repositories;

import com.cyl.ppmtooljava.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: cyl
 * @Date: 19/5/2022 - 05 - 2022 - 12:57 PM
 * @Description: com.cyl.ppmtooljava.repositories
 * @version: 1.0
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

   public abstract User findByUsername(String username);
   User getById(Long id);
}
