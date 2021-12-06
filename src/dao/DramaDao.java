package dao;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DramaDao {

	// 다음 페이지로 넘어가기
	// 다음 페이지가 있으면 true 리턴하고 없으면 false 리턴하기
	public boolean isNext(WebDriver driver) {
		WebElement page = driver.findElement(By.xpath("//*[@id=\"main_pack\"]/div[2]/div[2]/div/div/div[3]/div"));
		List<WebElement> nextPage = page.findElements(By.cssSelector("a"));
		for (int i = 1; i < nextPage.size();) { // 이전, 다음 이라 i를 1로 시작하게 함
			if (nextPage.get(i).getText().equals("다음")) {
				nextPage.get(i).click();
				return true;

			} else {
				System.out.println("마지막 페이지");
				return false;
			}

		}
		return false;
	}

	// 해당 페이지에 있는 드라마 제목을 모두 출력하기
	public void getData(WebDriver driver) {
		WebElement el2 = driver.findElement(By.xpath("//*[@id=\"mflick\"]/div/div[1]/ul[1]"));
		List<WebElement> el3 = el2.findElements(By.tagName("strong"));
		int count = 0;
		for (int j = 0; j < el3.size(); j++) {
			String print = el3.get(j).getText();
			if (!print.equals("")) {
				System.out.println(++count + ". " + print);
			}
		}
	}

	/*
	 * a 안에 있는거 찾아주기, 뭐가 나오는지 알수 있어서 도움됨 WebElement page =
	 * driver.findElement(By.xpath(
	 * "//*[@id=\"main_pack\"]/div[2]/div[2]/div/div/div[3]/div")); List<WebElement>
	 * nextPage = page.findElements(By.cssSelector("a")); for (int i = 0; i <
	 * nextPage.size(); i++) { System.out.println(nextPage.get(i).getText()); // 이전,
	 * 다음 }
	 */

}
