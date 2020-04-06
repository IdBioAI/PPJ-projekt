package ppj.assignments.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import ppj.assignments.writer.DevelWriter;
import ppj.assignments.writer.ProdWriter;

public class WriterConfiguration {

    @Bean
    @Profile({"devel"})
    public DevelWriter DevelWriter(){
        return new DevelWriter();
    }

    @Bean
    @Profile({"!devel"})
    public ProdWriter ProdWriter(){
        return new ProdWriter();
    }

}
