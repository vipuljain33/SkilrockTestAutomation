package objectRepository;


import org.openqa.selenium.By;

public class MiniRoulettePageLocator {
 
   public static By betAmount10=By.xpath("//*[@id='tenCursor']/div/img");
   public static By betAmount20=By.xpath("//*[@id='twentyCursor']/div/img");
   public static By betAmount50=By.xpath("//*[@id='fiftyCursor']/div/img");
   public static By betAmount100=By.xpath("//*[@id='hundredCursor']/div/img");
   public static By betAmount500=By.xpath("//*[@id='FiveHundredCursor']/div/img");
  
   public static By oneToSix=By.xpath("//*[@id='parent_1-6']");
   public static By fourToNine=By.xpath("//*[@id='parent_4-9']");
   public static By sevenToTwelve=By.xpath("//*[@id='parent_7-12']");
   public static By roulette=By.xpath("//*[@id='miniRoulette']/div[1]/div[1]/div[1]/div/div[2]/div[1]/ul/li/div");
   public static By twoToOneBetTypes=By.xpath("//*[contains(@id,'parent_2-1-r')]");
   public static By firstRow=By.xpath(".//*[@id='parent_2-1-r1']");
   public static By secondRow=By.xpath(".//*[@id='parent_2-1-r2']");
   public static By thirdRow=By.xpath(".//*[@id='parent_2-1-r3']");
   public static By allEvenNumbers=By.xpath("//*[@id='parent_even']");
   public static By allOddNumbers=By.xpath("//*[@id='parent_odd']");
   public static By redNumbers=By.xpath("//*[@id='parent_red']");
   public static By blackNumbers=By.xpath("//*[@id='parent_gray']");
   public static By zeroBetType=By.xpath("//*[@id='miniRoulette']/div[1]/div[1]/div[1]/div/div[1]/div");
   public static By buyNowLoctor=By.xpath("//button[@id='buy']");
     
   public static By zero=By.xpath("//*[@id='mr0']");
   public static By one=By.xpath("//*[@id='mr1']");
   public static By two=By.xpath("//*[@id='mr2']");
   public static By three=By.xpath("//*[@id='mr3']");
   public static By four=By.xpath("//*[@id='mr4']");
   public static By five=By.xpath("//*[@id='mr5']");
   public static By six=By.xpath("//*[@id='mr6']");
   public static By seven=By.xpath("//*[@id='mr7']");
   public static By eight=By.xpath("//*[@id='mr8']");
   public static By nine=By.xpath("//*[@id='mr9']");
   public static By ten=By.xpath("//*[@id='mr10']");
   public static By eleven=By.xpath("//*[@id='mr11']");
   public static By twelve=By.xpath("//*[@id='mr12']");
   
   public static By firstQuarter=By.xpath("//*[@id='miniRoulette']/div[1]/div[1]/div[2]/div[1]/div[1]/ul");
   public static By thirdQuarter=By.xpath("//*[@id='miniRoulette']/div[1]/div[1]/div[2]/div[1]/div[2]/ul");
   public static By sixthQuarter=By.xpath("//*[@id='miniRoulette']/div[1]/div[1]/div[2]/div[1]/div[3]/ul");
   public static By secondQuarter=By.xpath("//*[@id='miniRoulette']/div[1]/div[1]/div[2]/div[1]/div[4]/ul");
   public static By fourthQuarter=By.xpath("//*[@id='miniRoulette']/div[1]/div[1]/div[2]/div[1]/div[5]/ul");
   public static By fifthQuarter=By.xpath("//*[@id='miniRoulette']/div[1]/div[1]/div[2]/div[1]/div[6]/ul");
   
   public static By firstColumn=By.xpath("//*[@id='miniRoulette']/div[1]/div[1]/div[2]/div[2]/div[1]/ul");
   public static By secondColumn=By.xpath("//*[@id='miniRoulette']/div[1]/div[1]/div[2]/div[2]/div[2]/ul");
   public static By thirdColumn=By.xpath("//*[@id='miniRoulette']/div[1]/div[1]/div[2]/div[2]/div[3]/ul");
   public static By fourthColumn=By.xpath("//*[@id='miniRoulette']/div[1]/div[1]/div[2]/div[2]/div[4]/ul");
   
   
   public static By advanceDrawButton=By.xpath("//*[@id='advDrawSel']/a");
   public static By advanceDraws=By.xpath("//*[@id='drawInfo']/div/div/input");
   public static By advanceDraw=By.xpath("//div[@class='ad-draw-check-box']//label[1]");
   public static By advanceDrawSubmit=By.xpath("//*[@id='drawSubmit']");
   public static By miniRouletteButton=By.xpath("//*[@id='4~20']");
   
   public static By printedTicketPrice=By.xpath("//*[@class='no-of-tkt']");
   public static By qpTicketPrice=By.xpath("//button[@id='buy']//span[@id='tktPrice']");
   public static By cancelButton=By.xpath("//*[@id='cardCancel']");
   public static By ticketPreview=By.xpath("//div[@id='tktView']");
   public static By enterCradnumberPopupcancel=By.xpath("//*[@id='card-no']//div[@class='button-cancel']");
   public static By enterCradnumberPopup=By.xpath(".//div[@id='card-no']");
   public static By insufficienterrorpopup=By.xpath("//*[@id='error-popup']//div[@class='modal-bodyWrap']//div[@id='error']");
   public static By txtPreviewTicketPrice=By.xpath(".//*[@id='tktGen']//div[@class='tkt-dt-m border-top']//div[@class='tkt-rw tlam']//span[@class='no-of-tkt']");
}
