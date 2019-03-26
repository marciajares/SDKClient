package com.inbracompany.train.sdk.aspect;

public class RemoveMe {
	
//  @Before("de.fraunhofer.train.sdk.aspect.CommonJoinPointConfig.trackMessageOrg()")
//	public void around(ProceedingJoinPoint joinPoint,EnvelopeMessageModel envelopeMessageModel) throws Throwable{
//		String content = null;
//
//		try {
//			content = (String) joinPoint.getTarget();
//			System.out.println(envelopeMessageModel.getAuthor());
//			System.out.println(content);
//		} catch (Exception e) {
//			throw new RuntimeException("Fail to do the envelope message track at class:"+EnvelopeMessageAspect.class,e);
//		}
//
//	}
	
//	@Around("@annotation(de.fraunhofer.train.sdk.annotation.SaveComposedTrain)")
//	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//	    return joinPoint.proceed();
//	}
	//Before(value="@annotation(SaveComposedTrain)")
	//Around("execution(public * *(..)) && @annotation(de.fraunhofer.train.sdk.annotation.SaveComposedTrain))")
	
	
	
//	@Before(value="@annotation(saveEnvelope)")
//	public void logGoldOutput4(org.aspectj.lang.JoinPoint jp, EnvelopeMessageModel message) {
//	    System.out.println("=====> " + message.getAuthor());
//	}
//	

	
//	@Before(value="@annotation(de.fraunhofer.train.sdk.annotation.SaveComposedTrain)")
//	public void logGoldOutput3(org.aspectj.lang.JoinPoint jp, EnvelopeMessageModel message) {
//	    System.out.println("=====> " + message.getAuthor());
//	}
	
//	@Before(value="execution(* de.fraunhofer.train.sdk.persistence.mongo.config.repository.trainmodelrepository.ITrainModelRepository.save())")
//	public void logGoldOutput2(org.aspectj.lang.JoinPoint jp, EnvelopeMessageModel message) {
//	    System.out.println("=====> " + message.getAuthor());
//	}
//	@Before(value="@annotation(de.fraunhofer.train.sdk.annotation.SaveComposedTrain)")
//	public void logGoldOutput1(org.aspectj.lang.JoinPoint jp, EnvelopeMessageModel message) {
//	    System.out.println("=====> " + message.getAuthor());
//	}
	
//	@Around("@annotation(SaveComposedTrain)")
//  public String handleException3(ProceedingJoinPoint jp, Object controller) throws Throwable {
//      String view = null;
//       
//      try {
//          view = (String) jp.proceed();
//      } catch (DataAccessException e) {
//          System.out.println("=====> error in {}"+ controller.getClass().getSimpleName()+ e);
//          return "errorPage";
//      }
//       
//      return view;
//  }
//	
//	@Around("@annotation(de.fraunhofer.train.sdk.annotation.Message)")
//  public String handleException2(ProceedingJoinPoint jp, Object controller) throws Throwable {
//      String view = null;
//       
//      try {
//          view = (String) jp.proceed();
//      } catch (DataAccessException e) {
//          System.out.println("=====> error in {}"+ controller.getClass().getSimpleName()+ e);
//          return "errorPage";
//      }
//       
//      return view;
//  }
//	
//	@Around("execution(public * *(..)) && @annotation(de.fraunhofer.train.sdk.annotation.Message)")
//  public String handleException1(ProceedingJoinPoint jp, Object controller) throws Throwable {
//      String view = null;
//       
//      try {
//          view = (String) jp.proceed();
//      } catch (DataAccessException e) {
//          System.out.println("=====> error in {}"+ controller.getClass().getSimpleName()+ e);
//          return "errorPage";
//      }
//       
//      return view;
//  }
	
//	@Pointcut("execution(..)")
//	public void test2(){
//		System.out.println("test");
//	}
//	
//	@Pointcut("execution(..)")
//	public void test1(){
//		System.out.println("test");
//	}
//
//
//	
//	@Before("execution(deafult String save(..))")
//	public void getNameAdvice(){
//		System.out.println("==>  Executing Advice on getName()");
//	}
//	
//	@Before("execution(* com.journaldev.spring.service.*.get*())")
//	public void getAllAdvice4(){
//		System.out.println("==> Service method getter called");
//
//	}
//
//	
//	@Before("execution(* de.fraunhofer.train.sdk.*.save(..))")
//	public void getAllAdvice3(){
//		System.out.println("==> Service method getter called");
//	}
//	
//	@Before("execution(de.fraunhofer.train.sdk.persistence.mongo.config.repository.messagemodelrepository.IEnvelopeMessageModelRepository)")
//	public void getAllAdvice2(){
//		System.out.println("==> Service method getter called");
//	}
//	
//	@Before("execution(* de.fraunhofer.train.sdk.*.save(..))")
//	public void getAllAdvice1(){
//		System.out.println("==> Service method getter called");
//	}
//	

}
