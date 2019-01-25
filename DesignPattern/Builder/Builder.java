package DesignPattern.Builder;

import DesignPattern.AbstractFactory.ISender;
import DesignPattern.Factory.MailSender;
import DesignPattern.Factory.SmsSender;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private List<ISender> list = new ArrayList<>();
    public void produceMailSender(int count)
    {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count)
    {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }

    public List<ISender> getList()
    {
        return list;
    }
}
