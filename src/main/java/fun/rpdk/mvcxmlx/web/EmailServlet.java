package fun.rpdk.mvcxmlx.web;

import fun.rpdk.mvcxmlx.util.Logger;
import fun.rpdk.mvcxmlx.util.Util;
import org.apache.ibatis.io.Resources;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "EmailServlet", value = "/EmailServlet")
public class EmailServlet extends HttpServlet {
    private final Random random = new Random();
    private MimeMessage message;
    private Map<String,Boolean> fsMap;
    @Override
    public void init() throws ServletException {
        super.init();
        Logger.getLogger().debug("email init start");
        fsMap =new HashMap();
        fsMap.put("zc",true);
        fsMap.put("gg",true);
        String from = null;
        String key = null;
        String host = null;
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("email.properties"); //Resources.getResourceAsStream("email.properties");
        } catch (Exception e) {
            Logger.getLogger().error("email init error");
            e.printStackTrace();
        }
        System.out.println("in"+in);
        Properties p = new Properties();
        try {
            p.load(in);
            from = p.getProperty("email.from");
            key = p.getProperty("email.key");
            host = p.getProperty("email.host");
        } catch (IOException e) {
            Logger.getLogger().error("email init error");
            e.printStackTrace();
            return;
        }
        Properties sp = System.getProperties();
        sp.setProperty("mail.smtp.host", host);
        sp.setProperty("mail.smtp.auth", "true");
        String finalFrom = from;
        String finalKey = key;
        Session session = Session.getDefaultInstance(sp, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(finalFrom, finalKey);
            }
        });
        message=new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String to=request.getParameter("to");
        String fs=request.getParameter("fs");
        String opr=request.getParameter("opr");
        PrintWriter out=response.getWriter();
        try {
            if ("yes".equals(opr)&&to!=null&&fsMap.get(fs)){
                message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
                int yzm=random.nextInt(999999);
                message.setText("rpdk.fun你的验证码是:"+yzm);
                HttpSession session=request.getSession();
                session.setAttribute(fs,yzm);
                Transport.send(message);
                out.println("1");
            }
        } catch (Exception e) {
            out.print("0");
        }
    }
}
