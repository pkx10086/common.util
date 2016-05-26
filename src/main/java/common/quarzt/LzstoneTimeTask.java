package common.quarzt;



import java.util.Date;
import java.util.logging.Logger;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
* 类说明：定时任务
* @author pankx
* @date 2016年5月25日 上午11:27:20
*/
public class LzstoneTimeTask implements Job {
	Logger logger = Logger.getLogger("LzstoneTimeTask");
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("date:"+new Date()+"execute method will do someThing");
	}
	
}
