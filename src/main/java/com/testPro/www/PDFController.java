package com.testPro.www;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PDFController {
	
	@RequestMapping(value="/pdf",method=RequestMethod.GET)
	public String PDFpage(Model model) throws Exception
	{
		
		File file = new File("C:/java/java/Spring/testProject1/src/main/webapp/resources/sample.pdf");
		PDDocument doc = PDDocument.load(file);
		
		PDFRenderer renderer = new PDFRenderer(doc);
		
		BufferedImage image = renderer.renderImage(0);
		
		ImageIO.write(image, "JPEG", new File("C:/java/java/Spring/testProject1/src/main/webapp/resources/images/myimage.jpg"));
		
		doc.close();
		
		return "PDFpage";
	}

}
