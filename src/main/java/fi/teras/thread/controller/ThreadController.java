package fi.teras.thread.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.teras.threads.ThreadHandler;
import fi.teras.threads.ThreadProvider;
import fi.teras.threads.ThreadTask;
import fi.thread.task.implementation.CoffeeTask;

@Controller
@RequestMapping("/")
public class ThreadController {
	
	private ThreadProvider provider;
	
	public ThreadController() {
		this.provider = new ThreadHandler();
		this.provider.addTask(new CoffeeTask());
	}
	
	@RequestMapping(value="/findThread", method = RequestMethod.GET)
	public ThreadTask getThreadTask(@PathVariable String id, ModelMap model) {
		return this.provider.getTask(id);
	}
	
	@RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
    public @ResponseBody
    String ajaxtest() {
		return "12345";
	}
	
	@RequestMapping(value = "/getThreadTasks", method = RequestMethod.POST)
	public @ResponseBody String getThreadTasks(ModelMap model) {
		ObjectMapper converter = new ObjectMapper();
		try {
			return converter.writeValueAsString(provider.getTasks());
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public void addNewThreadTask(@ModelAttribute ThreadTask task, Model model) {
		provider.addTask(task);
	}
}
