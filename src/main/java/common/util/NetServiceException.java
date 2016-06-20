package common.util;

/**
* 类说明：
* @author pankx
* @date 2016年6月17日 下午2:42:42
*/
public class NetServiceException extends RuntimeException  {
	
	public  NetServiceException(){
		super();
	}
	public NetServiceException(String message) {
		super(message);
	}

	public NetServiceException(Throwable cause) {
		super(cause);
	}

	public NetServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**   
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)    
	*/
	private static final long serialVersionUID = 1L;

}
