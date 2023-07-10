package com.group1.piarealestate.business.concretes;

import com.group1.piarealestate.business.abstracts.AuthService;
import com.group1.piarealestate.business.requests.UserLoginRequest;
import com.group1.piarealestate.business.requests.UserRegisterRequest;
import com.group1.piarealestate.business.responses.UserLoginResponse;
import com.group1.piarealestate.core.utilities.mapper.ModelMapperService;
import com.group1.piarealestate.dataAccess.UserRepository;
import com.group1.piarealestate.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private UserRepository userRepository;

    private ModelMapperService modelMapperService;

    private PasswordEncoder passwordEncoder;


    @Override
    public String userRegister(@Valid UserRegisterRequest userRegisterRequest,BindingResult bindingResult) {
        String errorMessage = "";
        User existingUserByEmail = userRepository.findByEmail(userRegisterRequest.getEmail());
        User existingUserByPhoneNumber = userRepository.findByPhoneNumber(userRegisterRequest.getPhoneNumber());


        if (existingUserByEmail != null) {
            return "Girilen E-mail zaten kayıtlı. ";
        }
        if (existingUserByPhoneNumber != null) {
            return "Girilen Telefon Numarası Zaten Kayıtlı adı zaten kayıtlı. ";
        }
        if(bindingResult.hasErrors()){
            if (bindingResult.hasFieldErrors("email")) {
                errorMessage += "E-mail alanı boş bırakılamaz. ";
            }
            if (bindingResult.hasFieldErrors("surName")) {
                errorMessage += "Soyad alanı boş bırakılamaz. ";
            }
            if (bindingResult.hasFieldErrors("phoneNumber")) {
                errorMessage += "Telefon alanı boş bırakılamaz. ";
            }if (bindingResult.hasFieldErrors("password")) {
                errorMessage += "Şifre alanı boş bırakılamaz. ";
            }
            return errorMessage;
        }else {

            String encodedPassword = passwordEncoder.encode(userRegisterRequest.getPassword());

            // User nesnesini oluştur ve kaydet
            User newUser = new User();
            newUser.setEmail(userRegisterRequest.getEmail());
            newUser.setName(userRegisterRequest.getName());
            newUser.setSurName(userRegisterRequest.getSurName());
            newUser.setPhoneNumber(userRegisterRequest.getPhoneNumber());
            newUser.setPassword(encodedPassword);

            userRepository.save(newUser);

            // Başarılı kayıt mesajı
            return "Kullanıcı başarıyla kaydedildi.";

        }



    }

    @Override
    public UserLoginResponse userLogin(UserLoginRequest userLoginRequest,BindingResult bindingResult) {
        String msg = "";
        User user1 = userRepository.findByEmail(userLoginRequest.getEmail());
        if (user1 != null) {
            String password = userLoginRequest.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(userLoginRequest.getEmail(), encodedPassword);

                if (user.isPresent()) {
                    UserLoginResponse response = modelMapperService.convertToLoginResponse(user.get());
                    response.setMessage("Login Success");
                    return response;
                } else {
                    UserLoginResponse userLoginResponse = new UserLoginResponse();
                    userLoginResponse.setMessage("Giriş İşlemi Başarısız.");
                    return userLoginResponse;
                }
            } else {
                UserLoginResponse userLoginResponse = new UserLoginResponse();
                userLoginResponse.setMessage("Girilen parola yanlış");
                return userLoginResponse;
            }
        } else {
            UserLoginResponse userLoginResponse = new UserLoginResponse();
            userLoginResponse.setMessage("Girilen kullanıcı adı yanlış");
            return userLoginResponse;
        }
    }

}
