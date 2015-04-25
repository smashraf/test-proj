package rohan.junit;

public class UserServiceImpl {
    
    private UserDAO userDAO;
    
    private SecService secService;
    
    public void assignPassword(User user) throws Exception {
        String passwordMd5 = secService.md5(user.getPassword());
        user.setPassword(passwordMd5);
        userDAO.updateUser(user);
    }

    public UserServiceImpl(UserDAO userDAO, SecService secService) {
        this.userDAO = userDAO;
        this.secService = secService;
    }
    
}
