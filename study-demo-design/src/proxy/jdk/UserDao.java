package proxy.jdk;

import proxy.jdk.IUserDao;

/**
 * 被代理类
 * @author daiYang_wu
 */
public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("Save data");
    }
}
