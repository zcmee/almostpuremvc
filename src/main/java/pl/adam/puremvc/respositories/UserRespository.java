package pl.adam.puremvc.respositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.adam.puremvc.entities.User;

import java.util.List;

/**
 * Created by SkyNET on 2017-11-12.
 */

public interface UserRespository extends JpaRepository<User, Integer> {
    List<User> findAll();
    User findById(Integer id);
    User save(User user);
    List<User> findAll(Sort firstName);
}


