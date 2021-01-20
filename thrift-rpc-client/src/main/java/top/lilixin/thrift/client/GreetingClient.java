package top.lilixin.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import top.lilixin.thrift.service.GreetingService;

import java.util.logging.Logger;

/**
 * @Description TODO
 * @Author lilixin
 * @Date 2021/1/20 11:48 上午
 **/
public class GreetingClient {
    private static final Logger logger = Logger.getLogger(GreetingClient.class.getName());

    public static void main(String[] args) {
        try {
            TTransport transport  = new TSocket("127.0.0.1",9999);
            transport.open();

            TBinaryProtocol tBinaryProtocol = new TBinaryProtocol(transport);

            GreetingService.Client client = new GreetingService.Client(tBinaryProtocol);

            String name = "lilixin";
            logger.info("client 请求参数name="+name);
            String result = client.sayHello(name);
            logger.info("server 返回结果result="+result);
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }
}
