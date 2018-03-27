package com.testPro.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PDFController {

	@RequestMapping(value="pdf",method=RequestMethod.GET)
	public String pdf()
	{
		return "PDFpage";
	}
}
