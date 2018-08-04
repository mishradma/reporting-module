package com.mycompany.reporting.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPConfig {
	/**
	 *
	 */
	private static final String LOG_MESSAGE_DEFAULT = "********************************{} *********************************** {}";
	private static final Logger LOGGER = LoggerFactory.getLogger(AOPConfig.class);

	/**
	 * A join point is in the web layer if the method is defined in a type in the
	 * com.xyz.someapp.web package or any sub-package under that.
	 */
	@Pointcut("within(com.mycompany.reporting.controller..*)")
	public void inWebLayer() {
	}

	@Before("execution(* com.mycompany.reporting.controller.*.*(..))")
	public void beforeSampleCreation() {
		AOPConfig.LOGGER.info(AOPConfig.LOG_MESSAGE_DEFAULT, " All controller");
	}

	@AfterReturning("inWebLayer()")
	public void beforeSampleCreation1() {
		AOPConfig.LOGGER.info(AOPConfig.LOG_MESSAGE_DEFAULT, " Web layer Accessed");
	}

	@Around("inWebLayer()")
	public Object doBasicProfiling(final ProceedingJoinPoint pjp) throws Throwable {
		AOPConfig.LOGGER.info(AOPConfig.LOG_MESSAGE_DEFAULT, pjp.getSignature());
		return pjp.proceed();

	}

}