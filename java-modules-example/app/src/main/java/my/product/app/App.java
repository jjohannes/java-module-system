package my.product.app;

import org.slf4j.LoggerFactory;

import static my.product.modulea.StringUtils.join;
import static my.product.modulea.StringUtils.split;

public class App {
    public static void main(String[] args) {
        Message message = new Message();
        String result = splitAndJoin(message.getMessage());
        LoggerFactory.getLogger(App.class).info("running app in module "
                + App.class.getModule().getName());
        System.out.println(result);
    }

    private static String splitAndJoin(String s) {
        return join(split(s));
    }
}
