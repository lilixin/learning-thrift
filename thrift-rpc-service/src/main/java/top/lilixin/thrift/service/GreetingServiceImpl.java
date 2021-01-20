package top.lilixin.thrift.service;

import org.apache.thrift.TException;

import java.util.logging.Logger;

/**
 * @Description TODO
 * @Author lilixin
 * @Date 2021/1/20 11:37 上午
 **/
public class GreetingServiceImpl implements GreetingService.Iface{
    private static final Logger logger =  Logger.getLogger(GreetingServiceImpl.class.getName());

    public String sayHello(String name) throws TException {
        logger.info(String.format("welcome to my world! name = {%s}", name));

        return "Hello, " + name;
    }
}
