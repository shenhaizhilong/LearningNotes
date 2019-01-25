package DesignPattern;

import DesignPattern.Builder.Builder;
import DesignPattern.Factory.ISender;

import java.util.List;

public class BuilderDemo {

    public static void main(String[] args) {

        Builder builder = new Builder();
        builder.produceMailSender(10);
        builder.produceSmsSender(5);
        List<ISender>  list = builder.getList();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).send();
        }
    }
}
