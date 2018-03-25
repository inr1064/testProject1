package com.testPro.www;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PDFContoller {
	
	@RequestMapping(value="/PDFpage", method= RequestMethod.GET)
	public String PDFpage(Model model)
	{
			

		
		
		
		return "PDFpage";
		
	}
	
	
	

}
