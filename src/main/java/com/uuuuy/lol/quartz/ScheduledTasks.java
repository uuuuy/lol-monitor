package com.uuuuy.lol.quartz;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.uuuuy.lol.crawler.impl.CrawlerGameList;
import com.uuuuy.lol.domain.Gameuser;
import com.uuuuy.lol.tast.Task;

@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {
	
	
	
	@Scheduled(fixedRate = 1000 * 30)
	public void notifyGame(){
		Task task = new Task(Gameuser.HUODA);
		task.task();
	}

}
