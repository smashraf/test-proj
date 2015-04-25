package rohan.junit;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class UserServiceTest {
    
    UserServiceImpl userService; //System under test
    
    String originalPasswd = "abcd";
    
    @Test
    public void assignPasswordTest() throws Exception {
        User user = new User(originalPasswd);
        SecService secService = Mockito.mock(SecService.class); // Stub - indirect input
        UserDAO userDAO = Mockito.mock(UserDAO.class); // Test spy - indirect output - user password updated
        when(secService.md5(user.getPassword())).thenReturn("e2fc714c4727ee9395f324cd2e7f331f");
        userService = new UserServiceImpl(userDAO, secService);
        userService.assignPassword(user);
        Assert.assertNotEquals(user.getPassword(),originalPasswd);
        verify(userDAO).updateUser(user);
    }

}
