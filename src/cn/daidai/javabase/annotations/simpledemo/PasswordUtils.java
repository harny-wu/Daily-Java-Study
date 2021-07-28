package cn.daidai.javabase.annotations.simpledemo;

import java.util.List;

/**
 * @author Lenovo
 * @description: TODO
 * @date 2021/7/27 16:54
 */
public class PasswordUtils {
    @UseCase(id=47,description ="Password must contain at least one numeric" )
    public boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }
    @UseCase(id=48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }
    @UseCase(id=49,description = "new passwords can not equal previously used ones")
    public boolean checkForNewPassword(List<String>prevPasswords,String password){
        return !prevPasswords.contains(password);
    }
}
