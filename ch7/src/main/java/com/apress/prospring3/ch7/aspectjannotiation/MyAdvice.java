package com.apress.prospring3.ch7.aspectjannotiation;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

	/*- Temporary removed -*/
/*	@Pointcut("execution(* com.apress.prospring3.ch7..foo*(int)) && args(intValue)")
	public void fooExecution(int intValue) {

		//Nobody
	}

	@Pointcut("bean(myDependency*)")
	public void inMyDependency() {

		//Nobody
	}

	@Before("fooExecution(intValue) && inMyDependency()")
	public void fooBefore(JoinPoint joinPoint, int intValue) {

		// Execute only when intValue is not 100 
		if (intValue != 100) {
			System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName() + " "
					+ joinPoint.getSignature().getName() + " argument: " + intValue);
		}
	}

	@Around("fooExecution(intValue) && inMyDependency()")
	public Object fooAround(ProceedingJoinPoint pjp, int intValue) throws Throwable {

		System.out.println("Before execution: " + pjp.getSignature().getDeclaringTypeName() + " "
				+ pjp.getSignature().getName() + " argument: " + intValue);
		Object retVal = pjp.proceed();
		System.out.println("After execution: " + pjp.getSignature().getDeclaringTypeName() + " "
				+ pjp.getSignature().getName() + " argument: " + intValue);
		return retVal;
	}*/
}
