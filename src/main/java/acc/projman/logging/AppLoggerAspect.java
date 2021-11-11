package acc.projman.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLoggerAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(acc.projman.controllers..*) || within(acc.projman.dao..*)")
	public void definePackagePointCuts() {
		//empty method, to name location especified int the pointcut	
	}
	
	@Around("definePackagePointCuts()")
	public Object aroundLog(ProceedingJoinPoint jp) {
		logger.debug("\n\n");
		logger.debug("********** BEFORE METHOD EXECUTION **********\n {}.{} () with arguments[s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(),Arrays.toString(jp.getArgs()));
		logger.debug("______________________________________________\n\n");
		
		Object o=null;
		try {
			o = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		logger.debug("**********  AFTER METHOD EXECUTION **********\n {}.{} () with arguments[s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(),Arrays.toString(jp.getArgs()));
		logger.debug("______________________________________________\n\n");
		
		return o;
	}
}