package common.util;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Logger;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import common.quarzt.LzstoneTimeTask;

/**
* ��˵����
* @author pankx
* @date 2016��5��25�� ����1:27:38
*/
public class TestQuartz {
	
	private  static Logger logger = Logger.getLogger("TestQuartz");
	public static void main(String args[]){
		//JobDetailBean jobDetailBean = new JobDetailBean();
		//����jobDetail
	   JobDetailImpl jobDetailImpl = new JobDetailImpl();	
	   jobDetailImpl.setJobClass(LzstoneTimeTask.class);
	   jobDetailImpl.setName("job_1");
	   jobDetailImpl.setGroup("job_group_1");
	   //����Trigger
	/*   SimpleTriggerImpl st = new SimpleTriggerImpl();
	   st.setName("trgger_1");
	   st.setGroup("trgger_group_1");
	   st.setStartTime(new Date());
	   //�ظ�ֹͣʱ��
	   java.util.Calendar c = java.util.Calendar.getInstance(); 
       c.setTimeInMillis(System.currentTimeMillis() + 1000 * 1L); 
	   st.setEndTime(c.getTime());
	   st.setFireInstanceId("trgger_first_1");
	   st.setRepeatInterval(1L*1);
	   //�����ظ�ִ�д��� 
       st.setRepeatCount(1);*/
       
       CronTriggerImpl cronTrigger= new CronTriggerImpl();
       try {
    	   cronTrigger.setName("cronTrgger_1");
    	   cronTrigger.setGroup("crontrgger_1");
    	   cronTrigger.setCronExpression("0/20 * * * * ?");
    	   cronTrigger.setStartTime(new Date());
    	   cronTrigger.setDescription("描述信息");
    	   cronTrigger.setFireInstanceId("_0000");
		
       } catch (ParseException e1) {
	
		e1.printStackTrace();
	}
       
      //3������Scheduler���󣬲�����JobDetail��Trigger���� 
       SchedulerFactory sf = new StdSchedulerFactory();
       Scheduler scheduler = null; 
       try { 
              scheduler = sf.getScheduler(); 
              Date date= scheduler.scheduleJob(jobDetailImpl, cronTrigger); 
              logger.info("date::"+date);
               //4����ִ���������رյȲ��� 
               scheduler.start();
       } catch (SchedulerException e) { 
               e.printStackTrace(); 
           	throw new RuntimeException("系统异常,查看logger日志");
       } 
//       try { 
//               //�رյ����� 
//               scheduler.shutdown(true); 
//       } catch (SchedulerException e) { 
//               e.printStackTrace(); 
//       } 
} 

}
