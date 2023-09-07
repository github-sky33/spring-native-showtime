package cn.mindray.showtime;

import cn.mindray.showtime.config.hints.ShowtimeServerHints;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "cn.mindray.**.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
@ImportRuntimeHints(ShowtimeServerHints.class)
public class ShowtimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowtimeApplication.class, args);
	}


}

