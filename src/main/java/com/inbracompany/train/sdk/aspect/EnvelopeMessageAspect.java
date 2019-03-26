package com.inbracompany.train.sdk.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import com.inbracompany.train.sdk.model.messagemodel.impl.EnvelopeMessageModel;
import com.inbracompany.train.sdk.util.ParseUtils;

@Aspect
@Configuration
public class EnvelopeMessageAspect {
	
	private final Log log = LogFactory.getLog(EnvelopeMessageAspect.class.getClass());
	
    @Before("de.fraunhofer.train.sdk.aspect.CommonJoinPointConfig.trackMessageOrg() && target(instance)")
	public void before(JoinPoint joinPoint,Object instance) throws NoSuchMethodException, SecurityException{

    	log.debug("======> In EnvelopeMessageAspect");
    	EnvelopeMessageModel envelopeMessageModel = null;
    	String methodName = joinPoint.getSignature().getName();
    	log.info("===> "+methodName);
		   java.lang.reflect.Method method = instance.getClass().getDeclaredMethod(methodName, EnvelopeMessageModel.class);
		   
		   
		try {
			   Object[] signatureArgs = joinPoint.getArgs();
			   for (Object signatureArg: signatureArgs) {
			      if(signatureArg instanceof EnvelopeMessageModel) {
			    	  envelopeMessageModel = (EnvelopeMessageModel) signatureArg;
			    	  log.info("======> "+envelopeMessageModel.getAuthor());
			    	  log.info("Instance ====> "+instance);
			      }
			   }

			   method.invoke(instance, envelopeMessageModel);
               
			   if(envelopeMessageModel==null) {
				   throw new RuntimeException("Fail to do the casting from method arg to envelope message at class:"+EnvelopeMessageAspect.class);
			   }
		} catch (Exception e) {
			log.error("======> Exception: "+ParseUtils.getException(e));
			throw new RuntimeException("Fail to do the envelope message track at class:"+EnvelopeMessageAspect.class,e);
		}finally {
			
			log.debug("======> Out EnvelopeMessageAspect");
		}

	}
    
    

}
