package day07;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test2 {
	public static void main(String[] args) {
		String url="https://comic.naver.com/index";
		//크롤링대상 url지정
		
		try {
			Document doc = Jsoup.connect(url).get();
			//doc를 출력하게되면 해당 url에 해당하는 html파일이 가져오게된다
		
			Elements ele = doc.select("h6.title");
			//만약에 title이 아이디였다면 h6#title이다, 지금은 클래스이기때문에 h6.title
			//ele를 출력하게되면 h6태그에 class가 title인 모든 태그를 가져오게된다
			
			Iterator<Element> itr = ele.select("a > span").iterator();
			//JDBC에서 결과물을 보기위해선 ResultSet객체로 받아왔는데 크롤링에선 Iterator로 받아온다
			// a > span 의미는 a태그 아래 span을 의미한다, 자바스크립트에서 선택자사용했던것
			
			while(itr.hasNext()) {
				System.out.println(itr.next().text());
				//itr을 next()로 받아오면 element를 반환하기때문에 text()사용하여 문자열로 가져온다
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
