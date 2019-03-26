package com.inbracompany.train.sdk.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	

//	@Pointcut("execution(* com.in28minutes.spring.aop.springaop.data.*.*(..))")
//	public void dataLayerExecution(){}
//	
//	@Pointcut("execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))")
//	public void businessLayerExecution(){}
//	
//	@Pointcut("dataLayerExecution() && businessLayerExecution()")
//	public void allLayerExecution(){}
//	
//	@Pointcut("bean(*dao*)")
//	public void beanContainingDao(){}
//	
//	@Pointcut("within(com.in28minutes.spring.aop.springaop.data..*)")
//	public void dataLayerExecutionWithWithin(){}

	@Pointcut("@annotation(de.fraunhofer.train.sdk.annotation.TrackMessageOrg)")
	public void trackMessageOrg(){}
	
	
	@Pointcut("execution(* de.fraunhofer.train.sdk..*.*(..))")
	public void logAllMethods(){}
	
	@Pointcut("execution(* de.fraunhofer.train.sdk.*.*.*(..)) && execution(* de.fraunhofer.train.sdk.*.*.*())")
	public void logAllExceptions(){}

}
