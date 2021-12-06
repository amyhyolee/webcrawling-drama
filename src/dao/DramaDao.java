package dao;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DramaDao {

	// 해당 페이지에 있는 드라마 제목을 모두 출력하기
	public void getData(WebDriver driver) {
		
		WebElement get1 = driver.findElement(By.cssSelector("div[class='box_card_image_list _list'"));
//		List<WebElement> get2 = get1.findElements(By.className("_text")); // *
		List<WebElement> get2 = get1.findElements(By.cssSelector("strong[class='title _ellipsis'")); // **

		for (int j = 0; j < get2.size(); j++) {
			String print = get2.get(j).getText();
//			if (!print.equals("구독") && !print.equals("")) {   // *
//				System.out.println("- " + print);
//			}
			if (!print.equals("")) {  // **
			System.out.println("- " + print);
		}
			
		}
	}
}
