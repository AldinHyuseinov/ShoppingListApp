package bg.softuni.shoppinglist.services;

import bg.softuni.shoppinglist.models.dto.LoginUserDTO;
import bg.softuni.shoppinglist.models.dto.RegisterUserDTO;
import bg.softuni.shoppinglist.models.entities.User;
import bg.softuni.shoppinglist.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserService {
    private final UserRepository userRepository;

    private final ModelMapper mapper;

    public void registerUser(RegisterUserDTO registerUserDTO) {
        userRepository.saveAndFlush(mapper.map(registerUserDTO, User.class));
    }

    public Optional<User> loginUser(LoginUserDTO loginUserDTO) {
        return userRepository.findByUsernameAndPassword(loginUserDTO.getUsername(), loginUserDTO.getPassword());
    }
}
