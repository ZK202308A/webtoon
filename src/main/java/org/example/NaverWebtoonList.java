package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaverWebtoonList {

    public static void main(String[] args) throws Exception {

        String path = "https://comic.naver.com/webtoon";


        WebDriver driver = new ChromeDriver();

        driver.get(path);

        Thread.sleep(3000);

        java.util.List<WebElement> elements = driver.findElements(By.cssSelector(".WeekdayMainView__daily_all_wrap--UvRFc ul"));

        for (WebElement ul : elements) {
            WebElement li = ul.findElement(By.cssSelector("li img"));
            System.out.println(li.getAttribute("alt"));
            System.out.println(li.getAttribute("src"));
            System.out.println("-------------------------");
        }


        Thread.sleep(1000);
        driver.close();
    }
}
