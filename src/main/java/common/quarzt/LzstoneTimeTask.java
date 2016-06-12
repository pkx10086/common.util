package common.quarzt;



import java.util.Date;
import java.util.logging.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import common.util.PropertiesUtil;


/**
 * 功能描述：
 * @author pankx
 * @date 2016年6月7日
 */
public class LzstoneTimeTask implements Job {
	Logger logger = Logger.getLogger("LzstoneTimeTask");
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		PropertiesUtil p=PropertiesUtil.getProperties();
		System.out.println(p.readValueBykey("quarzt.test.name"));
		logger.info("date:"+new Date()+"execute method will do someThing");
	}
	
}
