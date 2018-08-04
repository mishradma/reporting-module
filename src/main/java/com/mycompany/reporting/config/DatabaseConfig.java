package com.mycompany.reporting.config;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mycompany.reporting.domain.Transaction;
import com.mycompany.reporting.repositories.TransactionRepository;
import com.mycompany.reporting.utils.CommonConstantUtils;

@Configuration
@EnableJpaRepositories(basePackages = "com.mycompany.reporting.repositories")
@EntityScan(basePackages = "com.mycompany.reporting.domain")
public class DatabaseConfig {

	@Autowired
	TransactionRepository products;

	@Bean
	InitializingBean feedData() {
		return () -> {
			for (int i = 0; i < 1000; i++) {
				int randomDate = Double.valueOf(Math.random() * 30).intValue();
				Calendar cal = Calendar.getInstance(Locale.US);
				cal.set(Calendar.DAY_OF_MONTH, randomDate);
				Date instructionDate = cal.getTime();
				cal.add(Calendar.DATE, 2);
				Date settlementDate = cal.getTime();
				products.save(new Transaction(CommonConstantUtils.createRandomCode(3),
						CommonConstantUtils.createRandomCode(1, "BS"), Math.random(),
						CommonConstantUtils.createRandomCurrency(), instructionDate, settlementDate,
						Math.random() * 1000, 10.0));
			}
		};
	}
}
