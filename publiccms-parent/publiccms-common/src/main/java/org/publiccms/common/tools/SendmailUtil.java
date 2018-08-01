package org.publiccms.common.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class SendmailUtil {

	// 设置服务器
	private static String KEY_SMTP = "mail.smtp.host";
	private static String VALUE_SMTP = "smtp.qq.com";
	// 服务器验证
	private static String KEY_PROPS = "mail.smtp.auth";
	// private static boolean VALUE_PROPS = true;
	// 发件人用户名、密码
	private String SEND_USER = "343048470@qq.com";
	private String SEND_UNAME = "343048470@qq.com";
	private String SEND_PWD = "smwqyuvhmcedbhgd";
	// 建立会话
	private MimeMessage message;
	private Session s;

	/*
	 * 初始化方法
	 */
	public SendmailUtil(String currentPath) {
		// Properties props = System.getProperties();
		// props.setProperty(KEY_SMTP, VALUE_SMTP);
		// props.put(KEY_PROPS, "true");
		// Security.addProvider(new Provider());
		// props.setProperty("mail.smtp.socketFactory.class",
		// "javax.net.ssl.SSLSocketFactory");
		// props.setProperty("mail.smtp.port", "465");
		// props.setProperty("mail.smtp.socketFactory.port", "465");

		final Properties props = loadProperties(currentPath);

		s = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("SEND_UNAME"), props.getProperty("SEND_UNAME"));
			}
		});
		s.setDebug(true);
		message = new MimeMessage(s);
	}

	// 加载配置文件
	public static Properties loadProperties(String currentPath) {
		String PROPERTIES_PATH = currentPath+"WEB-INF/classes/mailConfig.properties";
		File file = new File(PROPERTIES_PATH);
		Properties properties = new Properties();
		System.out.println(properties);
		Reader reader;
		try {
			reader = new InputStreamReader(new FileInputStream(file));
			properties.load(reader);
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	/**
	 * 发送邮件
	 * 
	 * @param headName
	 *            邮件头文件名
	 * @param sendHtml
	 *            邮件内容
	 * @param receiveUser
	 *            收件人地址
	 * @throws IOException
	 */
	public void doSendHtmlEmail(String headName, String sendHtml, String[] receiveUser, String files) {
		try {
			// 发件人
			InternetAddress from = new InternetAddress(SEND_USER);
			message.setFrom(from);
			// 收件人
			InternetAddress[] to = new InternetAddress[receiveUser.length];
			for (int i = 0; i < receiveUser.length; i++) {
				to[i] = new InternetAddress(receiveUser[i]);
			}

			message.setRecipients(Message.RecipientType.TO, to);

			// 邮件标题
			message.setSubject(headName);
			String content = sendHtml.toString();
			// 邮件内容,也可以使纯文本"text/plain"

			MimeBodyPart text = new MimeBodyPart();
			text.setContent(content, "text/html;charset=UTF-8");
			// 描述数据关系
			MimeMultipart mm = new MimeMultipart();
			mm.setSubType("related");
			mm.addBodyPart(text);
			// 添加邮件附件
				MimeBodyPart attachPart = new MimeBodyPart();
				attachPart.attachFile(files);
				String fileName = files.substring(files.lastIndexOf("\\")+1, files.length());
				//设置附件名称编码
				attachPart.setFileName(MimeUtility.encodeWord(fileName));;
				System.out.println("文件路径为："+files+"附件名称为："+fileName);
				mm.addBodyPart(attachPart);
			message.setContent(mm,"charset=UTF-8");

			message.saveChanges();

			Transport transport = s.getTransport("smtp");

			// smtp验证，就是你用来发邮件的邮箱用户名密码
			transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);
			// 发送
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("send success!");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		/*SendmailUtil se = new SendmailUtil();
		// receptAddress 可以是多人
		String[] receptAddress = { "348235142@qq.com" };
		String[] files = { "D:\\CloudMusic\\cloudmusic.dll" };
		
		se.doSendHtmlEmail("邮件标题", "邮件内容", receptAddress, files);*/

	}

}