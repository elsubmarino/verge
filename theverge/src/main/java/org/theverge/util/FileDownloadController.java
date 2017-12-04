package org.theverge.util;

import java.io.File;

import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownloadController implements ApplicationContextAware {
	private WebApplicationContext context = null;

	@RequestMapping("/board/download")
	public ModelAndView download(@RequestParam("filename") String fileName) {

		String path="a:\\";
		String fullPath = path + "\\" + fileName;

		File file = new File(fullPath);

		return new ModelAndView("downloadView", "downloadFile", file);

	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) {
		this.context = (WebApplicationContext) arg0;
	}

}
