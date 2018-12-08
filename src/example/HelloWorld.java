package example;

import service.ImgService;
import service.Impl.ImgServiceImpl;
import service.Impl.UserServiceImpl;
import service.UserService;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
@WebService
public class HelloWorld {
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from lidiwen1," + from;
    System.out.println(result);
    return result;
  }
  public static void main(String args[]){
    Object implementor = new HelloWorld();
    String addrres="http://localhost:8081/HelloWorld";
    String addrres2="http://localhost:8081/Img";
    String addrres3="http://localhost:8081/User";
    ImgServiceImpl imgService = new ImgServiceImpl();
    UserServiceImpl userService=new UserServiceImpl();
    //发布服务 地址+服务实现类
    Endpoint.publish(addrres2, imgService);
    Endpoint.publish(addrres3, userService);

   Endpoint.publish(addrres,implementor);
  }
}
