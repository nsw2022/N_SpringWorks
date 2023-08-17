package aop_p.adv;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdevice {
	Object arTest(ProceedingJoinPoint joinPoint) {
		Object res = null;
		
		System.out.println(" >> arTest 진입" + joinPoint.toString());
		System.out.println(" >> toShortString 진입" + joinPoint.toShortString());
		System.out.println(" >> getSignature 진입" + joinPoint.getSignature());
		System.out.println(" >> getName 진입" + joinPoint.getSignature().getName());
		System.out.println(" >> Signature().toShortString():"+joinPoint.getSignature().toShortString());
		System.out.println(" >> getArgs:"+ Arrays.toString( joinPoint.getArgs()) );
		System.out.println(" >> getArgs:"+joinPoint.getThis());
		/*
		 >> arTest 진입execution(String aop_p.webToon.JoSuk.wife())
		 >> toShortString 진입execution(JoSuk.wife())
		 >> getSignature 진입String aop_p.webToon.JoSuk.wife()
		 >> getName 진입wife
		 >> Signature().toShortString():JoSuk.wife()
		 >> getArgs:[]
		 >> getArgs:aop_p.webToon.JoSuk@618c5d94 
		  
		 */
		
		
		try {
			
			if(joinPoint.getArgs().length>=2) {
				joinPoint.getArgs()[1] = "엄마상어";
				
				
			}

			res = joinPoint.proceed();
			
			if (res.equals("애봉")) {
				res = "조준";
			}
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(" >> arTest 완료");
		
		return res;
	}
}
