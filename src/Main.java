import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    public static void main(String[] args) {
        //Java Selenium klasörünü ve içerisindeki lib klasörünü java class olarak projeye Module Settings üzerinden import ediniz.
        System.setProperty("webdriver.chrome.driver","C:/Users/baran/Selenium/ChromeDriver/chromedriver.exe");
        //Yukarıdaki dosya dizin adresine kullanılacak driverın indirildiği klasör path'ını veriniz.
        WebDriver driver=new ChromeDriver();
        driver.get("https://amazon.com.tr/");
        driver.manage().window().maximize();
        driver.findElement(By.id("sp-cc-accept")).click();
        try {
            driver.findElement(By.id("nav-tools")).click();
        }
        catch (Exception e){

        }
        try {
            // e-mail yada telefon numarası giriniz.
            driver.findElement(By.id("ap_email")).sendKeys("EMAİL");
            driver.findElement(By.id("continue")).click();
            //Amazon şifrenizi giriniz.
            driver.findElement(By.id("ap_password")).sendKeys("SİFRE");
            driver.findElement(By.id("signInSubmit")).click();
        }
        catch (Exception e){
            System.out.println("Giriş işlemi Başarısız.");
        }
        try {
            driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]/option[11]")).click();
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
            String attributeSiyaset =driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[2]/ul/li[25]/span/a")).getAttribute("href");
            driver.get(attributeSiyaset);
            String attributeSosyal =driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[2]/ul/li[6]/span/a")).getAttribute("href");
            driver.get(attributeSosyal);

            String attributeSosyoloji =driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[2]/ul/li[16]/span/a")).getAttribute("href");
            driver.get(attributeSosyoloji);


        }
        catch (Exception e){
            System.out.println("Kitap Kategori seçimi Başarısız.");
        }
        try {
            String attributeKitap =driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div[6]/div/div/div[2]/div[1]/h2/a")).getAttribute("href");
            System.out.println("ESG - Ezbere Yaşayanlar Kitap url:"+attributeKitap);
            driver.get(attributeKitap);
            driver.findElement(By.id("buy-now-button")).click();
        }
        catch (Exception e){
            System.out.println("ESG Kitap Seçimi Başarısız.");
        }
        try {
            driver.findElement(By.xpath("//*[@id=\"orderSummaryPrimaryActionBtn\"]")).click();
        }
        catch (Exception e){
            System.out.println("Kayıtlı Ödeme Aracı seçimi Başarısız.");
        }
        try {
            // Kitabı satın alma işlemini kontrol etmek için aşağıdaki kodu yorum satırından kaldırınız.

            //driver.findElement(By.xpath("//*[@id=\"submitOrderButtonId\"]")).click();
            System.out.println("ESG- Ezbere Yaşayanlar Kitabı satın alındı.");
        }
        catch (Exception e){
            System.out.println("Satın alma Başarısız.");
        }














    }
}