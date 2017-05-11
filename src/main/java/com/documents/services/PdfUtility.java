package com.documents.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class PdfUtility {

    public static String FILE = "C:\\Users\\Ecaterina\\Desktop\\FirstPdf.pdf";
    public static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    public static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    public static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    public static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);


    /**
     * Return the string that we need to make Json Object
     *
     * @param br
     *
     * @return string
     *
     * @throws IOException
     */
    public static String initiliazeJson(BufferedReader br) throws IOException {
        String jsonString;

        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            jsonString = sb.toString();
        } finally {
            br.close();
        }

        return jsonString;

    }

    /**
     * Insert into the document object the title
     *
     * @param document the object where we insert the title
     * @param title    the string that we need to insert into the document
     *
     * @throws DocumentException
     */
    public static void addTitle(Document document, String title) throws DocumentException {
        Paragraph paragraph = new Paragraph(title, catFont);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

    }

    /**
     * Concatenate a list of strings
     *
     * @param strings all the strings
     *
     * @return string
     */
    public static String concatenateString(String... strings) {
        String concatenatedString = new String();

        for (String string : strings) {
            concatenatedString = concatenatedString.concat(string);
        }

        return concatenatedString;
    }

    /**
     * Insert into the document object the footer
     *
     * @param document the object where we insert the footer
     * @param footer   the string that we need to insert into the document
     *
     * @throws DocumentException
     */
    public static void addFooter(Document document, String footer) throws DocumentException {
        Paragraph paragraph = new Paragraph(footer, smallBold);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph);

    }


    /**
     * Add empty lines to the document(between paragraphs)
     **/
    public static Paragraph addEmptyLine(int number) {

        Paragraph emptyLines = new Paragraph();

        for (int i = 0; i < number; i++) {
            emptyLines.add(new Paragraph(" "));

        }
        return emptyLines;
    }


    /**
     * Make a new instance of Document object and prepare it for inserting the further content
     *
     * @return Document object
     *
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    public static Document initializeDocument() throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(FILE));
        document.open();
        return document;
    }

    /**
     * Close the document object that we just create
     *
     * @param document
     */
    public static void finalizeDocument(Document document) {
        document.close();
    }

}
