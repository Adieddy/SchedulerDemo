# SchedulerDemo
Spring boot scheduler example

This project holds Spring boot's scheduler examples.

All scheduled methods should not return anything that's why return type should be void.
Scheduled methods should not have any parameters inside.

***************************************************************************************************************
There are three kinds of schedulers which can be used.

1. fixedDelay
  It takes time in milliseconds and run the method after every millisecond mentioned. This delay is in between the last executed task and the new task.

2. fixedRate
  This is similar to fixedDelay. The only difference is it doesn't wait for last task to complete. Fixed rate is the time after which the method will run again without waiting for the last execution to be completed successfully.
  
3. cron
  There are 6 fields under cron each representing: seconds, minutes, hours, day, month, weekday
  Some examples: 
	* 0 * * * * * : Every start of minute
	* 0 2 * * * * : Every start of two minutes
	* */10 * * * * * : Every 10 seconds
	* 0 0 8-10 * * *: 8, 9, 10 o'clock every day
	* 0 0 6,19 * * *: 6AM, 7PM everyday
	* 0 0 9-17 * * MON-FRI: 9 to 5 weekdays
