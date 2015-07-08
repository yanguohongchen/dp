package com.sea.framework;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mangofactory.swagger.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class SpringFoxController {

   private final static Log logger = LogFactory.getLog(SpringFoxController.class);
   private final static String COLON = ":";
   private final static String API_DOC = "/api-docs";

   @RequestMapping("/api")
   @ResponseBody
   public String api(HttpServletRequest request, HttpServletResponse response) throws IOException {
       //获取url地址
       String reqUrl = request.getRequestURL().toString();
       logger.info("api页面请求：" + reqUrl);
       reqUrl = reqUrl.replace("api", "apidocs") + "/index.html";
       

		BasicCookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		HttpGet httpget = new HttpGet(reqUrl);
		CloseableHttpResponse response1 = httpclient.execute(httpget);

		HttpEntity entity = response1.getEntity();
		String html = EntityUtils.toString(entity, "utf-8");
       
       //api url
       String apiUrl = request.getServerName() + COLON + request.getServerPort()+"/" +SpringfoxConfig.PROJECT_NAME+"/" + API_DOC;
       
       String htmUrl = "http://"+request.getServerName() + COLON + request.getServerPort()+"/" +SpringfoxConfig.PROJECT_NAME;

       //处理html页面内容,使其可以访问静态资源
       String body = html.replace("petstore.swagger.io/v2/swagger.json", apiUrl)
               .replace("css/", htmUrl+"/apidocs/css/")
               .replace("lib/", htmUrl+"/apidocs/lib/")
               .replace("swagger-ui.js", htmUrl+"/apidocs/swagger-ui.js");
       return body;
   }
}

