package com.sample.scheduler.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerComponent {
	private static final Logger log = LoggerFactory.getLogger(SchedulerComponent.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	/***
	 * This class holds all the kinds of schedulers present by default under Spring boot properties.
	 * All scheduled methods should not return anything that's why return type should be void
	 * Scheduled methods should not have any parameters inside.
	 */
	
	/***
	 * fixedDelay: it takes time in milliseconds and run the method after every millisecond mentioned.
	 * This delay is in between the last executed task and the new task.
	 */
	@Scheduled(fixedDelay = 4000)
	public void schedulerFixedDelay() {
		log.info("Under fixed delay: Current time is "+dateFormat.format(new Date()));
	}
	
	/***
	 * fixedRate: this is similar to fixedDelay
	 * The only difference is it doesn't wait for last task to complete.
	 * Fixed rate is the time after which the method will run again without waiting for the last execution 
	 * to be completed successfully.
	 * @throws InterruptedException 
	 */
	@Scheduled(fixedRate = 4000)
	public void schedulerFixedRate() throws InterruptedException {
		log.info("Under fixed rate: Current time is "+dateFormat.format(new Date()));
		Thread.sleep(2000);
		log.info("Method's end here: Current time is "+dateFormat.format(new Date()));
	}
	
	/***
	 * Most used kind of scheduler
	 * There are 6 fields under cron each representing: seconds, minutes, hours, day, month, weekday
	 * Some examples: 
	 * 0 * * * * * : Every start of minute
	 * 0 2 * * * * : Every start of two minutes
	 * *`/10 * * * * * : Every 10 seconds(remove ` sign)
	 * 0 0 8-10 * * *: 8, 9, 10 o'clock every day
	 * 0 0 6,19 * * *: 6AM, 7PM everyday
	 * 0 0 9-17 * * MON-FRI: 9 to 5 weekdays
	 */
	@Scheduled(cron = "*/10 * * * * *")
	public void schedulerCron() {
		log.info("Under Cron method: Current time is "+dateFormat.format(new Date()));
	}
}
