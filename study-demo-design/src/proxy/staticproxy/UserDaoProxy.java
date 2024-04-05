package proxy.staticproxy;

/**
 * @author daiYang_wu
 */
public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始代理");
        target.save();
        System.out.println("结束代理");
    }
}
