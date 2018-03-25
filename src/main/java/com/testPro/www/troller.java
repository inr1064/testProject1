/*package com.testPro.www;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.fontbox.ttf.TrueTypeCollection;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class troller {
	
	@Autowired
	ServletContext context; 
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/dfvdv", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home";
	}
	
	@RequestMapping(value = "/dfvdv", method = RequestMethod.GET)
	public void pdf(HttpServletResponse response) throws Exception {
		
		final int pageCount = 2;
		final String webroot = this.context.getRealPath("/");
		
		// 臾몄꽌 留뚮뱾湲�
		final PDDocument doc = new PDDocument();
		
		// 諛곌꼍�씠誘몄� 濡쒕뱶
	    PDImageXObject pdImage = PDImageXObject.createFromFile(webroot + "resources/back.jpg", doc);
		
	    // �룿�듃 �깮�꽦
	    // ttf �뙆�씪 �궗�슜�븯湲�
	    //InputStream fontStream = new FileInputStream("C:/fonts/gulim.ttf");
	    //PDType0Font fontGulim = PDType0Font.load(doc, fontStream);
	    
	    // ttc �뙆�씪 �궗�슜�븯湲�
	    File fontFile = new File("C:/Windows/fonts/gulim.ttc");
	    PDType0Font fontGulim = PDType0Font.load(doc, new TrueTypeCollection(fontFile).getFontByName("Gulim"), true);
		
	    // �몢 媛쒖쓽 �럹�씠吏�瑜� 留뚮뱺�떎.
		for(int i = 0; i < pageCount; i++) {
			// �럹�씠吏� 異붽�
			PDPage blankPage = new PDPage(PDRectangle.A4);
	        doc.addPage(blankPage);
	        
	        // �쁽�옱 �럹�씠吏� �꽕�젙
	        PDPage page = doc.getPage(i);
	        
	        // 而⑦뀗痢� �뒪�듃由� �뿴湲�
	        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
	        
            // 諛곌꼍 �씠誘몄�  洹몃━湲�
	        contentStream.drawImage(pdImage, 0, 0, 595, 842);
	        
	        // 湲��뵪 �벐湲�
	        drawText("PDFBox �씪�씠釉뚮윭由щ�� �궗�슜�븯�뿬", fontGulim, 18, 100, 600, contentStream);
	        drawText("PDF�뙆�씪 留뚮뱾湲�", fontGulim, 18, 100, 560, contentStream);
	        
	        // �뀒�씠釉� 洹몃━湲�
	        String[][] contents = {
                {"Apple",    "Banana",    "1"},
                {"Chestnut", "Persimmon", "2"},
                {"Eggplang", "Potato",    "3"},
                {"Guava",    "Radish",    "4"},
                {"Lemon",    "Lime",      "5"}
            };

            drawTable(page, contentStream, 500, 100, contents);
	        
	        // 而⑦뀗痢� �뒪�듃由� �떕湲�
	        contentStream.close();
		}

		// �뙆�씪 �떎�슫濡쒕뱶 �꽕�젙
		response.setContentType("application/pdf");
		String fileName = URLEncoder.encode("�깦�뵆PDF", "UTF-8");
		response.setHeader("Content-Disposition", "inline; filename=" + fileName + ".pdf");
		
		// PDF �뙆�씪 異쒕젰
		doc.save(response.getOutputStream());
		doc.close();
		
	}
	
	*//**
	 * 湲��뵪瑜� �벖�떎.
	 * @param text
	 * @param font
	 * @param fontSize
	 * @param left
	 * @param bottom
	 * @param contentStream
	 * @throws Exception
	 *//*
	private void drawText(String text, PDFont font, int fontSize, float left, float bottom, PDPageContentStream contentStream) throws Exception {
        contentStream.beginText(); 
        contentStream.setFont(font, fontSize);
        contentStream.newLineAtOffset(left, bottom);
        contentStream.showText(text);
        contentStream.endText();
	}
	
	*//**
	 * �씪�씤�쓣 洹몃┛�떎.
	 * @param contentStream
	 * @param xStart
	 * @param yStart
	 * @param xEnd
	 * @param yEnd
	 * @throws IOException
	 *//*
	private void drawLine(PDPageContentStream contentStream, float xStart, float yStart, float xEnd, float yEnd) throws IOException {
		contentStream.moveTo(xStart,yStart);
		contentStream.lineTo(xEnd,yEnd);
		contentStream.stroke();
	}
	
	*//**
	 * �뀒�씠釉붿쓣 洹몃┛�떎.
	 * @param page
	 * @param contentStream
	 * @param y
	 * @param margin
	 * @param content
	 * @throws Exception
	 *//*
	public void drawTable(PDPage page, PDPageContentStream contentStream, float y, float margin, String[][] content) throws Exception {
        final int rows = content.length;
        final int cols = content[0].length;
        
        final float rowHeight = 20f;
        final float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        final float tableHeight = rowHeight * rows;
        
        final float colWidth = tableWidth / (float)cols;
        final float cellMargin = 5f;

        // �뻾�쓣 洹몃┛�떎.
        float nexty = y ;
        for(int i = 0; i <= rows; i++) {
            drawLine(contentStream, margin, nexty, margin + tableWidth, nexty);
            nexty -= rowHeight;
        }

        // �뿴�쓣 洹몃┛�떎.
        float nextx = margin;
        for(int i = 0; i <= cols; i++) {
            drawLine(contentStream, nextx, y, nextx, y - tableHeight);
            nextx += colWidth;
        }

        float textx = margin + cellMargin;
        float texty = y - 15;
        for(int i = 0; i < content.length; i++) {
            for(int j = 0 ; j < content[i].length; j++) {
                String text = content[i][j];
                drawText(text, PDType1Font.HELVETICA_BOLD, 12, textx, texty, contentStream);
                textx += colWidth;
            }
            texty -= rowHeight;
            textx = margin + cellMargin;
        }
    }

}
*/