package org.apache.pinot.core.periodictask;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PeriodicTaskCronJob implements Job {
  private static final Logger LOGGER = LoggerFactory.getLogger(PeriodicTaskCronJob.class);
  public static final String PERIODIC_TASK_KEY = "PeriodicTask";

  public PeriodicTaskCronJob() {}

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    PeriodicTask periodicTask = (PeriodicTask) jobExecutionContext.getJobDetail().getJobDataMap().get(PERIODIC_TASK_KEY);

    if (periodicTask != null) {
      try {
        periodicTask.run();
      } catch (Throwable t) {
        LOGGER.warn("Caught exception while running Task: {}", periodicTask.getTaskName(), t);
      }
    }
  }
}
