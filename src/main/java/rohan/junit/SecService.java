package rohan.junit;

import java.security.NoSuchAlgorithmException;

import org.springframework.util.DigestUtils;

public class SecService {

    public String md5(String password) throws NoSuchAlgorithmException {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

}
