package aop_p_ex.adv;

import org.aspectj.lang.ProceedingJoinPoint;

public class FigureAdvice {
	
	Object arFiTest(ProceedingJoinPoint joinPoint) {
		
		Object res = null;
		
		String[] setArr = (String[]) (joinPoint.getArgs()[0]);
		
		
		
		try {
			res = joinPoint.proceed();
			if (setArr.length==0) {
				System.out.println("잘못 입력하셧거나 입력을 안하셨습니다.");
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
}
