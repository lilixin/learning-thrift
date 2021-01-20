package top.lilixin.thrift.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import top.lilixin.thrift.service.GreetingService;
import top.lilixin.thrift.service.GreetingServiceImpl;

import java.util.logging.Logger;

/**
 * @Description TODO
 * @Author lilixin
 * @Date 2021/1/20 11:42 上午
 **/
public class GreetingServer {
    private static final Logger logger = Logger.getLogger(GreetingServer.class.getName());

    public static void main(String[] args) {
        try {
            TServerSocket serverTransport = new TServerSocket(9999);
            TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();

            /**
             * 关联处理器与GreetingService服务实现
             */
            GreetingService.Processor processor = new GreetingService.Processor(new GreetingServiceImpl());

            TThreadPoolServer.Args serverArgs = new TThreadPoolServer.Args(serverTransport);
            serverArgs.processor(processor);
            serverArgs.protocolFactory(factory);

            TServer server  = new TThreadPoolServer(serverArgs);
            logger.info("Start server on port 9999...");
            server.serve();

        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
}
