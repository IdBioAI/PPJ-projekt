package app.assignments.writer;

import app.assignments.message.Message;
import org.springframework.stereotype.Component;


public class StdoutWriter implements Writer {

    public void write(Message message) {
        System.out.println(String.format("MESSAGE\nFrom: %s\nTo: %s\n\n%s\n",
                message.getSender(),
                message.getRecipient(),
                message.getText()));
    }
}
