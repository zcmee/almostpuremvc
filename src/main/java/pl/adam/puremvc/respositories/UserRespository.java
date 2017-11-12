package pl.adam.puremvc.respositories;

import org.springframework.data.repository.CrudRepository;
import pl.adam.puremvc.entities.User;

import java.util.List;

/**
 * Created by SkyNET on 2017-11-12.
 */

public interface UserRespository extends CrudRepository<User, Integer> {
    List<User> findAll();
    User findById(Integer id);
    User save(User user);
}


