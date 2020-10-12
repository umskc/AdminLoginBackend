package pl.plenczewski.jwtserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.plenczewski.jwtserver.model.User;
import pl.plenczewski.jwtserver.repository.UserRepository;

@Component
public class StartUp {

    @Autowired
    private UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void create(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("$2a$10$c/C7ovDoyJu8eh0ACaqTaO3xFk4Kgp9xkFMYVO6ol4BZ9Zsoch9U6");
        userRepository.save(user);
    }

}
