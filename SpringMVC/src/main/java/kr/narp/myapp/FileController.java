package kr.narp.myapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {

	@RequestMapping("/upload.do")
	public String upload(MultipartHttpServletRequest multipartRequest, 
			HttpServletRequest request, Model model)
	    throws Exception{
		
		String UPLOAD_DIR="repo";                                   // \\, /
		String uploadPath=request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		
		// id , name
		Map map =new HashMap(); // key ,value
		Enumeration<String> e = multipartRequest.getParameterNames(); //id ,name
		while(e.hasMoreElements()) {
			String id = e.nextElement();
			String name = multipartRequest.getParameter(id);
			System.out.println(id + " : " + name);
			map.put(id, name);
		}
		
		//파일을 담고 있는 파라미터 읽어오기
		Iterator<String> it = multipartRequest.getFileNames();
		List<String> filelist = new ArrayList<String>();
		while(it.hasNext()) {
			String key = it.next();
			MultipartFile mFile = multipartRequest.getFile(key);
			String oName = mFile.getOriginalFilename();
			System.out.println(key + " : " + oName);
			filelist.add(oName);
			//파일을 업로드 할 경로를 확인
			File file = new File(uploadPath+"\\"+key);
			
			if(mFile.getSize() != 0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(uploadPath+"\\"+oName));
			}
		}
		
		map.put("fileList", filelist);
		model.addAttribute("map",map);
	
		
		
		return "result";
	}
}
