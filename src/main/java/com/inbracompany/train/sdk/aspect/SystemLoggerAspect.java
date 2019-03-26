package com.inbracompany.train.sdk.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import com.inbracompany.train.sdk.util.ParseUtils;

@Aspect
@Configuration
public class SystemLoggerAspect {

	private final Log log = LogFactory.getLog(this.getClass());

	@AfterThrowing(pointcut = "de.fraunhofer.train.sdk.aspect.CommonJoinPointConfig.logAllExceptions()", throwing = "ex")
	public void logError(Exception ex) {
		log.error("===========================================");
		log.error("\n\n");
		log.error("====>  "+ParseUtils.getException(ex));
		log.error("\n\n");
		log.error("===========================================");
	}

	@Around("de.fraunhofer.train.sdk.aspect.CommonJoinPointConfig.logAllMethods()")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("\n\n");
		log.info("===========================================");
		log.info("\n\n");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object retVal = joinPoint.proceed();

		stopWatch.stop();

		StringBuffer logMessage = new StringBuffer();
		logMessage.append(joinPoint.getTarget().getClass().getName());
		logMessage.append(".");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append("(");
		// append args
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			logMessage.append(args[i]).append(",");
		}
		if (args.length > 0) {
			logMessage.deleteCharAt(logMessage.length() - 1);
		}

		logMessage.append(")");
		logMessage.append(" execution time: ");
		logMessage.append(stopWatch.getTotalTimeMillis());
		logMessage.append(" ms");
		log.info("=====> "+logMessage.toString());
		log.info("\n\n");
		log.info("===========================================");
		log.info("\n\n");
		return retVal;
	}
}
