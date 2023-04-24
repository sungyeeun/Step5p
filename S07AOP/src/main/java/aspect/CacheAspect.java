package aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//@Order(2)
public class CacheAspect {

	private Map<Long, Object> cache = new HashMap<>();

	@Pointcut("execution(public * chap07..*(long))")	
	public void cacheTarget() {
	}
	
	@Around("cacheTarget()")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[CacheAspect] excute 1");
		
		Long num = (Long) joinPoint.getArgs()[0];
		if (cache.containsKey(num)) {
			System.out.printf("CacheAspect: Cache에서 구함[%d]\n", num);
			return cache.get(num);
		}

		System.out.println("[CacheAspect] excute 2");
		Object result = joinPoint.proceed();              // ExeTimeAspect
		System.out.println("[CacheAspect] excute 3");
		cache.put(num, result);
		System.out.printf("CacheAspect: Cache에 추가[%d]\n", num);
		return result;
	}

}
