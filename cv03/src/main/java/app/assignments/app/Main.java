package main.java.app.assignments.app;

;
import app.assignments.message.CustomMessage;
import app.assignments.message.Message;
import app.assignments.message.PingMessage;

import app.assignments.message.ReplyMessage;
import app.assignments.writer.ListWriter;
import app.assignments.writer.StdoutWriter;
import app.assignments.writer.Writer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Main {

    @Bean
    public PingMessage pingMessage(){
        return new PingMessage();
    }

    @Bean
    public CustomMessage customMessage(){
        return new CustomMessage( );
    }

    @Bean
    public ReplyMessage replyMessage(){
        return new ReplyMessage(new PingMessage(), "pingRep");
    }

    @Bean
    public ListWriter listWriter(){
        return new ListWriter();
    }

    @Bean
    public StdoutWriter stdoutWriter(){
        return new StdoutWriter();
    }

    public static void main(String[] args) {


        ApplicationContext  applicationContext = new AnnotationConfigApplicationContext(Main.class);

        Message ping = (Message) applicationContext.getBean(PingMessage.class);
        Message hello = (Message) applicationContext.getBean(CustomMessage.class);
        Message pingReply = (Message) applicationContext.getBean(ReplyMessage.class);

        Writer stdoutWriter = (Writer) applicationContext.getBean(StdoutWriter.class);
        Writer listWriter = (Writer) applicationContext.getBean(ListWriter.class);
        stdoutWriter.write(ping);
        stdoutWriter.write(hello);
        stdoutWriter.write(pingReply);


        listWriter.write(ping);
        ((ListWriter) listWriter).listWrittenMessages().forEach(stdoutWriter::write);

    }

}
