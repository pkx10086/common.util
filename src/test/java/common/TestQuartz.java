package common;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Logger;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import common.quarzt.LzstoneTimeTask;

/**
* 类说明：
* @author pankx
* @date 2016年5月25日 下午1:27:38
*/
public class TestQuartz {
	
	private  static Logger logger = Logger.getLogger("TestQuartz");
	public static void main(String args[]){
		//JobDetailBean jobDetailBean = new JobDetailBean();
		//创建jobDetail
	   JobDetailImpl jobDetailImpl = new JobDetailImpl();	
	   jobDetailImpl.setJobClass(LzstoneTimeTask.class);
	   jobDetailImpl.setName("job_1");
	   jobDetailImpl.setGroup("job_group_1");
	   //创建Trigger
	/*   SimpleTriggerImpl st = new SimpleTriggerImpl();
	   st.setName("trgger_1");
	   st.setGroup("trgger_group_1");
	   st.setStartTime(new Date());
	   //重复停止时间
	   java.util.Calendar c = java.util.Calendar.getInstance(); 
       c.setTimeInMillis(System.currentTimeMillis() + 1000 * 1L); 
	   st.setEndTime(c.getTime());
	   st.setFireInstanceId("trgger_first_1");
	   st.setRepeatInterval(1L*1);
	   //设置重复执行次数 
       st.setRepeatCount(1);*/
       
       CronTriggerImpl cronTrigger= new CronTriggerImpl();
       try {
    	   cronTrigger.setName("cronTrgger_1");
    	   cronTrigger.setGroup("crontrgger_1");
    	   cronTrigger.setCronExpression("0/20 * * * * ?");
    	   cronTrigger.setStartTime(new Date());
    	   cronTrigger.setDescription("定时执行某个方法");
    	   cronTrigger.setFireInstanceId("_0000");
		
       } catch (ParseException e1) {
	
		e1.printStackTrace();
	}
       
      //3、创建Scheduler对象，并配置JobDetail和Trigger对象 
       SchedulerFactory sf = new StdSchedulerFactory();
       Scheduler scheduler = null; 
       try { 
               scheduler = sf.getScheduler(); 
              Date date= scheduler.scheduleJob(jobDetailImpl, cronTrigger); 
              logger.info("date::"+date);
               //4、并执行启动、关闭等操作 
               scheduler.start();
       } catch (SchedulerException e) { 
               e.printStackTrace(); 
       } 
//       try { 
//               //关闭调度器 
//               scheduler.shutdown(true); 
//       } catch (SchedulerException e) { 
//               e.printStackTrace(); 
//       } 
} 

}
