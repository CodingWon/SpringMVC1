package kr.narp.myapp;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {

	
	@RequestMapping("/upload.do")
	public String upload(MultipartHttpServletRequest multipartRequest , HttpServletRequest request) {
		
		System.out.println("ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎ");
		// id , name
		Map map =new HashMap(); // key ,value
//		String id = multipartRequest.getParameter("id");
//		String name = multipartRequest.getParameter("name");
		
		Enumeration<String> e = multipartRequest.getParameterNames(); //id ,name
		while(e.hasMoreElements()) {
			String key = e.nextElement();
			String value = multipartRequest.getParameter(key);
			System.out.println(key + " : " + value);
			map.put(key, value);
		}
		
		//파일을 담고 있는 파라미터 읽어오기
		Iterator<String> it = multipartRequest.getFileNames();
		while(it.hasNext()) {
			String key = it.next();
			MultipartFile mFile = multipartRequest.getFile(key);
			String oName = mFile.getOriginalFilename();
			System.out.println(key + " : " + oName);
		}
		
		return null;
	}
}
