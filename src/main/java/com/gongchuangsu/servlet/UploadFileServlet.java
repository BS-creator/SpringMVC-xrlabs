
package com.gongchuangsu.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/UploadFileServlet")
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
	@Override
	public void init() throws ServletException{
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		if(fileName == null || fileName.equals("")){
			throw new ServletException("File Name can't be null or empty");
		}
		File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileName);
		if(!file.exists()){
			throw new ServletException("File doesn't exists on server.");
		}
		System.out.println("File location on server::"+file.getAbsolutePath());
		ServletContext ctx = getServletContext();
		InputStream fis = new FileInputStream(file);
		String mimeType = ctx.getMimeType(file.getAbsolutePath());
		response.setContentType(mimeType != null? mimeType:"application/octet-stream");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		
		ServletOutputStream os = response.getOutputStream();
		byte[] bufferData = new byte[1024];
		int read=0;
		while((read = fis.read(bufferData))!= -1){
			os.write(bufferData, 0, read);
		}
		os.flush();
		os.close();
		fis.close();
		System.out.println("File downloaded at client successfully");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)){
			throw new ServletException("Content type is not multipart/form-data");
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><head></head><body>");
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while(fileItemsIterator.hasNext()){
				FileItem fileItem = fileItemsIterator.next();
				System.out.println("FieldName="+fileItem.getFieldName());
				System.out.println("FileName="+fileItem.getName());
				System.out.println("ContentType="+fileItem.getContentType());
				System.out.println("Size in bytes="+fileItem.getSize());
				
				File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileItem.getName());
				System.out.println("Absolute Path at server="+file.getAbsolutePath());
				fileItem.write(file);
				
				Connection conn = null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2VHSGDS\\PROGRAMMER;databaseName=again", "mine", "world");
					conn.setAutoCommit(false);
					
					String csvFilePath = file.getAbsolutePath();
					int batchSize = 20;
					
		            String sql = "INSERT INTO trainee (id, name, employee_email) VALUES (CONVERT (int, ?),?,?)";
		            PreparedStatement statement = conn.prepareStatement(sql);
		 
		            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
		            String lineText = null;
		 
		            int count = 0;
		 
		            lineReader.readLine(); // skip header line
		 
		            while ((lineText = lineReader.readLine()) != null) {
		            	String[] data = lineText.split(",");
		                String id = (String) data[0].replace("\"", "");
		                String employee_name = data[1].replace("\"", "");
		                String employee_email = data[2].replace("\"", "");

						System.out.println(id);
						System.out.println(employee_name);
						System.out.println(employee_email);
						
		                statement.setString(1, id);
		                statement.setString(2, employee_name);
		                statement.setString(3, employee_email);
		 
		                statement.addBatch();
		 
		                if (count % batchSize == 0) {
		                    statement.executeBatch();
		                }
		            }
		 
		            lineReader.close();
		 
		            // execute the remaining queries
		            statement.executeBatch();
		 
		            conn.commit();
		            conn.close();
		 
		            response.sendRedirect(request.getContextPath() + "/trainee");

				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
		} catch (FileUploadException e) {
			out.write(e + "Exception in uploading file. fileupload");
		} catch (Exception e) {
			out.write(e + "Exception in uploading file. just exception");
		}
	}
	
	public String renderTrainees() {
		System.out.println("I am called but can't go to the page");
		return "redirect:trainee";
	}

}
