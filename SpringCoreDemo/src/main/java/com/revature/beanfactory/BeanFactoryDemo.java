package com.revature.beanfactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.revature.beanfactory.service.Greeter;

public class BeanFactoryDemo {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
		// At this point, our BeanFactory is ready to go
		
		Greeter myEnglishGreeter = (Greeter) beanFactory.getBean("englishGreeter");
		myEnglishGreeter.greet("William");
		
		Greeter mySpanishGreeter = (Greeter) beanFactory.getBean("spanishGreeter");
		mySpanishGreeter.greet("William");
		
		Greeter npeGreeter = (Greeter) beanFactory.getBean("npeGreeter");
		npeGreeter.greet("William");
	}
}
