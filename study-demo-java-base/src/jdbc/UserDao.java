package jdbc;

/**
 * @author daiYang_wu
 */
public interface UserDao {

    public void add(User user);

    public User findByUsername(String username);

}
