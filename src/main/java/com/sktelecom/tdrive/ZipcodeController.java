package com.sktelecom.tdrive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

@Controller
public class ZipcodeController {
 
    public static final String ZIPCODE_API_KEY = "61152f63218347fb51458536836779";
    public static final String ZIPCODE_API_URL = "http://biz.epost.go.kr/KpostPortal/openapi"; // 요청 URL
     
    /**
     * 우편번호 화면
     * @return String
     * @throws Exception
     */
    @RequestMapping(value = "/zipcode")
    public String zipcode() throws Exception {
         
        return "zipcode/zipcode";
    }
     
    /**
     * 우편번호 검색 결과
     * @param searchTO
     * @return String
     * @throws Exception
     */
    @RequestMapping(value = "/zipcode/list", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
    public @ResponseBody String list(@ModelAttribute ZipcodeSearchTO searchTO) throws Exception {
         
        Map<String, Object> paramMap = new HashMap<String, Object>();
         
        // 요청 URL 생성
        StringBuilder queryUrl = new StringBuilder();
        queryUrl.append(ZIPCODE_API_URL);
        queryUrl.append("?regkey=");
        queryUrl.append(ZIPCODE_API_KEY);
        queryUrl.append("&target=");
        queryUrl.append(searchTO.getTarget());  // 서비스 종류 (지번/도로명, 새우편번호 지번/도로명)
        queryUrl.append("&query=");
        // ex) 세종로 17 로 입력하면 세종로와 17사이의 빈칸 때문에 에러가 발생하기 때문에 빈칸을 없앤다.
        queryUrl.append(searchTO.getQuery().replaceAll(" ", ""));       // 검색어
//        queryUrl.append("&countPerPage=");
//        queryUrl.append(50);
//        queryUrl.append("&currentPage=");
//        queryUrl.append(1);
//        System.out.println("queryUrl.toString() >>> " +queryUrl.toString());
        ////////////////////////////////////////////////////////////////////
        URL url = new URL(ZIPCODE_API_URL + "?regkey=" + ZIPCODE_API_KEY + "&target=" + "postNew"
				+ "&query=" + URLEncoder.encode("서둔동", "EUC-KR") + "&countPerPage=" + "15" + "&currentPage=" + "1");
        System.out.println(url);
        // URL 연결
 		URLConnection conn = url.openConnection();

 		// 언어설정 :: 이부분 중요합니다. (이부분을 설정하지 않으면 한글 데이터가 들어오질 않습니다!!)
 		conn.setRequestProperty("accept-language", "ko");
 		System.out.println(">>>>>>>>>>>>>>>>>>>" + conn.getInputStream());
 		
 		BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
 		String singleLine = input.readLine();
 		while(singleLine != null)
 		{
 		    System.out.println("singleLine >>>>>>>>>>>>>> " +singleLine);
 		    singleLine = input.readLine();
 		}
 		
 		// XML 자료 가져오기
 		SAXBuilder builder = new SAXBuilder();
 		Document doc = builder.build(conn.getInputStream());
        
 		Element itemlist = doc.getRootElement().getChild("itemlist");
 		
 		System.out.println("doc.getRootElement() >>>>>>>>>>>>>>>>>" + doc.getRootElement().getName());
 		
 		if (!(doc.getRootElement().getName().equals("error"))){
 			List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
 			ZipcodeVO zipcodeVO = null;
 			
 			List listChd = itemlist.getChildren();
 	 		
 	 		for (int i = 0; i < listChd.size(); i++) {
 	 			zipcodeVO = new ZipcodeVO();
 	 			
 				Element item = (Element) listChd.get(i);
 				String address = item.getChildText("address");
 				String postcd = item.getChildText("postcd");
 				zipcodeVO.setZipcode(postcd);
 				zipcodeVO.setAddress(address);
 				list.add(zipcodeVO);
 			}
 	 		paramMap.put("list", list);
 	 		
 	 		System.out.println("currentpage >>>>> " + doc.getRootElement().getChild("pageinfo"));
 	 		System.out.println("currentpage >>>>> " + doc.getRootElement().getChild("pageinfo").getChildren());
 	 		System.out.println("currentpage >>>>> " + doc.getRootElement().getChild("pageinfo").getChildText("currentPage"));
 		} else {
 			System.out.println("error >>>>>>>>>" + doc.getRootElement().getChildText("error_code"));
 			System.out.println("error >>>>>>>>>" + doc.getRootElement().getChildText("message"));

         paramMap.put("errorCode", doc.getRootElement().getChildText("error_code"));
         paramMap.put("errorMessage", doc.getRootElement().getChildText("message"));
 		}
 		return (new Gson()).toJson(paramMap);
        ////////////////////////////////////////////////////////////////////
//        Document document = Jsoup.connect(queryUrl.toString()).get();
         
//        String errorCode = document.select("error_code").text();
////        System.out.println("document >>> " +document);
//        // 요청 결과가 정상일 경우 내용을 파싱하여 List 에 담는다.
//        if (null == errorCode || "".equals(errorCode)) {
//            Elements elements = document.select("item");
//            
//            List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
//            ZipcodeVO zipcodeVO = null;
//             
//            for (Element element : elements) {
//                zipcodeVO = new ZipcodeVO();
//                zipcodeVO.setZipcode(element.select("postcd").text());
//                 
//                // 도로명 검색일 경우
//                if (searchTO.getTarget().indexOf("Road") > -1) {
//                    zipcodeVO.setAddress(element.select("rnaddress").text());
//                    zipcodeVO.setLnmAddress(element.select("lnmaddress").text());
//                     
//                    // 지번 검색일 경우
//                } else {
//                    zipcodeVO.setAddress(element.select("address").text());
//                }
//                 
//                list.add(zipcodeVO);
//            }
//             
//            paramMap.put("list", list);
//             
//            // 요청 결과가 정상이 아닐 경우 에러 내용을 담는다.
//        } else {
//            String errorMessage = document.select("message").text();
//             
//            paramMap.put("errorCode", errorCode);
//            paramMap.put("errorMessage", errorMessage);
//        }
//        System.out.println(paramMap.get("errorCode"));
//        System.out.println(paramMap.get("errorMessage"));
       
    }
}
 
