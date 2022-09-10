package com.leon;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LaunchMain {
	
	@Autowired
	List<Object> allBeans;

	@EventListener
	public void runDemo(final ContextRefreshedEvent event) {
		System.out.println(allBeans.size());
		for (Object obj : allBeans) {
			if (obj.getClass().getSimpleName().contains("Demo")) {
				Method[] methods = obj.getClass().getMethods();
				for (int i = 0; i < methods.length; i++) {
					if (methods[i].getName().matches(".*[Dd]emo")) {
						try {
							Object invoke = methods[i].invoke(obj);
							if (invoke == null) {
								System.out.println(obj.getClass().getSimpleName()+"."+methods[i].getName()+"的执行结果，"+invoke);
							}else {
								System.out.println(obj.getClass().getSimpleName()+"."+methods[i].getName()+"的执行结果，"+invoke.getClass().getSimpleName()+"："+invoke);
							}
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}
