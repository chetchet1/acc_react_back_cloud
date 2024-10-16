package kr.co.seoulit.account.sys.common.controller;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class EmailController extends AbstractController {
	
	private JavaMailSender mailSender;
	
	public void setMailSender(JavaMailSender mailSender) {
			this.mailSender = mailSender;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub

        String subject = request.getParameter("subject");
        String content = request.getParameter("message");
        String from = "seouit50@gmail.com";
        String to = request.getParameter("receiveMail");
        
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
            // true는 멀티파트 메세지를 사용하겠다는 의미
            
            /*
             * 단순한 텍스트 메세지만 사용시엔 아래의 코드도 사용 가능 
             * MimeMessageHelper mailHelper = new MimeMessageHelper(mail,"UTF-8");
             */
            
            mailHelper.setFrom(from);
            // 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
            // 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
            //mailHelper.setFrom("보내는이 이름 <보내는이 아이디@도메인주소>");
            mailHelper.setTo(to);
            mailHelper.setSubject(subject); // 제목
            mailHelper.setText(content, true); // 내용
            // true는 html을 사용하겠다는 의미입니다.
            
            /*
             * 단순한 텍스트만 사용하신다면 다음의 코드를 사용하셔도 됩니다. mailHelper.setText(content);
             */
            
            mailSender.send(mail);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    	return null;
	}
    }


	
			
	