package common.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class SingleFactory {
	private static final Object LOCK = new Object();
	protected static final String IMPLEMENT_METHOD = "getInstance";
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Map<String, Object> instances = new HashMap();

	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Class<T> cls) {
		if (!instances.containsKey(cls.getName())) {
			synchronized (LOCK) {
				if (!instances.containsKey(cls.getName())) {
					T instance = genInstance(cls);
					instances.put(cls.getName(), instance);
				}
			}
		}
		return (T) instances.get(cls.getName());
	}

	@SuppressWarnings("unchecked")
	private static <T> T genInstance(Class<T> cls) {
		T instance = null;
		try {
			Method method = cls.getDeclaredMethod("getInstance", new Class[0]);
			instance = (T) method.invoke(cls, new Object[0]);
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
			try {
				instance = cls.newInstance();
			} catch (InstantiationException e1) {
			} catch (IllegalAccessException e1) {
			}
		}
		return instance;
	}
}
