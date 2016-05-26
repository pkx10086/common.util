package common.quarzt;



import java.util.Date;
import java.util.logging.Logger;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
* ��˵������ʱ����
* @author pankx
* @date 2016��5��25�� ����11:27:20
*/
public class LzstoneTimeTask implements Job {
	Logger logger = Logger.getLogger("LzstoneTimeTask");
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("date:"+new Date()+"execute method will do someThing");
	}
	
}
