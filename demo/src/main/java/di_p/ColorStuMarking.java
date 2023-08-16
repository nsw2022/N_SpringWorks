package di_p;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ColorStuMarking implements BeanPostProcessor{
	
	
	
	/*
	 학생 bean을 구현하세요
           
   bean 이름이         98765
   red로 시작되는  객체의 평균 점수를 이용하여 수우미양가
   blue로 시작되는 객체의 평균 점수를 이용하여 A BC DF
   Yello로 시작되는객체의 평균 점수를 이용하여 12 34 5 
   
				로 등급을 처리하세요
	 
	 
	 * */
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		
		if (bean.getClass().getName().equals("di_p.ColorStu")) {
			
			
			
			ColorStu stu = (ColorStu) bean;
			
			
			int avg = stu.getAvg();
			// ABCD F
			// 60까지 F 
			// 70 D 
			// 80 C 
			// 90 B 
			// 100 A 
			// red로 시작되는  객체의 평균 점수를 이용하여 수우미양가
	        // blue로 시작되는 객체의 평균 점수를 이용하여 A BC DF
	        // Yello로 시작되는객체의 평균 점수를 이용하여 12 34 5 로 등급을 처리하세요
			
	        
			if (beanName.startsWith("red")) {
				String gradeEng = "가가가가가가양미우수수".charAt(avg/10)+"";
				
				stu.setMarking(gradeEng+"");				
			}else if (beanName.substring(0,1).equals("b")) {
				String gradeEng = "FFFFFFDCBAA".charAt(avg/10)+"";
				
				stu.setMarking(gradeEng+"");	
			}else if (beanName.equals("yellow") ) {
				String gradeEng = "55555543211".charAt(avg/10)+"";
				
				stu.setMarking(gradeEng+"");
			}
			
			System.out.println(bean);
			
		}
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	
}
