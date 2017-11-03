package springbootjsp;

import java.util.Date;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springbootjsp.controller.ITTaskJpaCrud;
import springbootjsp.model.TTasks;

@SpringBootApplication
public class SpringBootJsp2Application extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootJsp2Application.class); 
    }

    
        
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootJsp2Application.class, args);

	}
	
	@Bean
	public CommandLineRunner init(ITTaskJpaCrud crudJpa){
		return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				crudJpa.save(new TTasks("Task_1", "T1Descriptor1", new Date(), false));
				crudJpa.save(new TTasks("Task_2", "T1Descriptor2", new Date(), true));
				crudJpa.save(new TTasks("Task_3", "T1Descriptor3", new Date(), false));
			}
		};
	}

}
