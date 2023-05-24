package my.product.service.impl;

import my.product.data.Message;
import my.product.service.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class ServiceImpl implements Service {

    private final List<Message> q = new ArrayList<>();

    @Override
    public void queue(Message m) {
        q.add(m);
    }

    @Override
    public boolean process() {
        if (q.isEmpty()) {
            System.out.println(debugMessage());
            return false;
        } else {
            for (Iterator<Message> i = q.iterator(); i.hasNext(); ) {
                System.out.println(capitalize(i.next().get()));
                i.remove();
            }
            return true;
        }
    }

    String debugMessage() {
        return getClass().getModule().getName() + " >> Nothing to do";
    }
}
