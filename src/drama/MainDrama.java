package drama;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import dao.DramaDao;

public class MainDrama {

	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
	public static final String WEB_DRIVER_PATH = "/Users/hyojinlee/busanAI/eclipse/lib/chromedriver"; // 드라이버 경로

	public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
		// 드라이버 설정
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 크롬 설정을 담은 객체 생성
		ChromeOptions options = new ChromeOptions();

		// 브라우저가 눈에 보이지 않고 실행한다.
		// 설정하지 않으면 크롬 창이 생성되고, 어떻게 진행되는지 확인할 수 있다.
		options.addArguments("headless");

		// 위에서 설정한 옵션은 담은 드라이버 객체 생성
		// 옵션을 설정하지 않았을 때에는 생략 가능하다.
		// WebDriver객체가 곧 하나의 브라우저 창이라 생각한다.
		WebDriver driver = new ChromeDriver(options);

		// 이동을 원하는 url
		// 가끔 드라마 대신 인플루언서가 나오는 경우도 있음.
		String str = "드라마"; // 방영종료드라마, 방영예정드라마
		String text = URLEncoder.encode(str, "UTF-8");
		String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=" + text;

		// WebDriver을 해당 url로 이동한다.
		driver.get(url);

		// 브라우저 이동시 생기는 로드시간을 기다린다.
		// HTTP응답속도보다 자바의 컴파일 속도가 더 빠르기 때문에 임의적으로 1초를 대기한다.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		// 페이지 수 출력
		String page = driver.findElement(By.className("_total")).getText();
		int pageNum = Integer.parseInt(page);
//		System.out.println(pageNum);

		DramaDao dao = new DramaDao();
		for (int i = 0; i < pageNum; i++) {
			dao.getData(driver); // 드라마 제목 출력
			driver.findElement(By.xpath("//*[@id=\"main_pack\"]/div[2]/div[2]/div/div/div[3]/div/a[2]")).click(); // 다음 페이지 클릭

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
	}
}
