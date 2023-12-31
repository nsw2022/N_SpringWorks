package di_p;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor.BeforeInit 실행:" + beanName + "=> " + bean);
		
		if (bean.getClass().getName().equals("di_p.Umbrella")) {
			System.out.println( bean +"어떤 우산인가?");
			
			Umbrella uu = (Umbrella) bean;
			
			if (uu.getPrice() > 4000) {
				uu.setType("비싸");
			}
		}
		
		
		
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor.AfterInit 실행: " + beanName + "=>  " + bean);
		
		//Umbrella uu = (Umbrella) bean;
		//uu.setPrice(1000);
		
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	
}
