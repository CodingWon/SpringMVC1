package kr.narp.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO memberDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	@RequestMapping("/memberList.do")
	public String home(Model model) {
		List<MemberVO> list = memberDAO.memberList();
		model.addAttribute("list",list);
		
		return "memberList";
	}
	
}
