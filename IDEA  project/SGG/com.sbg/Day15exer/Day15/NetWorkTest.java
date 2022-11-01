package Day15exer.Day15;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/17 - 09 - 17
 * @Description: Day15
 */
public class NetWorkTest {
    public static void main(String[] args) {

        Serve serve = new Serve();
        ProxyServe proxyServe = new ProxyServe(serve);
        proxyServe.browse();

    }
}

interface NetWork {
     void browse ();
}

// 被代理类
class Serve implements NetWork {

    @Override
    public void browse() {
        System.out.println("真实的服务器访问网络");
    }
}

// 代理类
class ProxyServe implements NetWork {


    private NetWork netWork;

    public ProxyServe(NetWork netWork) {
        this.netWork = netWork;
    }
    public void Check () {
        System.out.println("检查细节");
    }

    @Override
    public void browse() {
        Check();
        netWork.browse();
    }
}