package pageObjects.chub;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.chub.BasePageUI;

public class ArticleListPO extends BasePage {
	WebDriver driver;

	public ArticleListPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isTextDisplayed(WebDriver driver, String text) {

		waitForAllElementVisible(driver, pageUIs.chub.BasePageUI.TEXT_VERIFY, text);
		// isJQueryAjaxLoadedSuccess(driver);
		return isElementDisplay(driver, pageUIs.chub.BasePageUI.TEXT_VERIFY, text);
	}

	public void enterToTexboxTitle(WebDriver driver, String title) {
		waitForElementVisible(driver, pageUIs.chub.BasePageUI.TEXBOX_TITLE);
		sendkeyToElement(driver, pageUIs.chub.BasePageUI.TEXBOX_TITLE, title);
		//sendkeyToElementByJS(driver, pageUIs.chub.BasePageUI.TEXBOX_TITLE, title);

		// button/span[text()="임시저장"]
		// TODO Auto-generated method stub

	}

	public void clickToButtonBySpanText(WebDriver driver, String text) {
		waitForElementClickable(driver, pageUIs.chub.BasePageUI.BUTTON_BY_TEXT_SPAN, text);
		clickToElementByJS(driver, pageUIs.chub.BasePageUI.BUTTON_BY_TEXT_SPAN, text);

		// button[@type='button']//span[text()='임시저장']

	}

	public void clickToButtonBack(WebDriver driver) {
		waitForElementClickable(driver, pageUIs.chub.BasePageUI.BACK_BUTTON);
		clickToElement(driver, pageUIs.chub.BasePageUI.BACK_BUTTON);

	}

	public boolean isSuccessDisplayText_1(WebDriver driver, String text) {
		waitForElementVisible(driver, pageUIs.chub.BasePageUI.TEXT_VALUE_1, text);
		// isJQueryAjaxLoadedSuccess(driver);
		return isElementDisplay(driver, pageUIs.chub.BasePageUI.TEXT_VALUE_1, text);
	}

	public void enterToTextboxSearch(WebDriver driver, String key_search) {
		waitForElementVisible(driver, pageUIs.chub.BasePageUI.TEXTBOX_SEARCH);
		sendkeyToElement(driver, pageUIs.chub.BasePageUI.TEXTBOX_SEARCH, key_search);

	}

	public void uploadImage(WebDriver driver, String filePath) {
		getElement(driver, pageUIs.chub.BasePageUI.UPLOAD_FILE).sendKeys(filePath);
	}

	public void clickMenubar(WebDriver driver, String menu) {
		//waitForElementClickable(driver, pageUIs.chub.BasePageUI.BUTTON_MENU_BAR, menu);
		clickToElementByJS(driver, pageUIs.chub.BasePageUI.BUTTON_MENU_BAR, menu);
		
	}

	public String isValueDisplayedInTableAtColumnNameAndRowIndex(WebDriver driver, String tableID, String headerName, String rowIndex) { 
		int columnIndex = getElementSize(driver, BasePageUI.TABLE_HEADER_BY_NAME, tableID, headerName) + 1;
		waitForElementVisible(driver, BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
		return getElementText(driver, BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
	}


	public void clickValueTable(WebDriver driver, String tableID, String headerName, String rowIndex) {
		int columnIndex = getElementSize(driver, BasePageUI.TABLE_HEADER_BY_NAME, tableID, headerName) + 1;
		waitForElementClickable(driver, BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
		clickToElement(driver, BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
	}
	
	public void deleteAllValueTable(WebDriver driver, String tableID, String headerName, String rowIndex, String textButton, String comfirmButton) {
		int columnIndex = getElementSize(driver, BasePageUI.TABLE_HEADER_BY_NAME, tableID, headerName) + 1;
		waitForElementVisible(driver, BasePageUI.TABLE_ROW, tableID);
		int rowSize = getElementSize(driver, BasePageUI.TABLE_ROW, tableID);
		for(int i= 1; i <= rowSize; i++)
		{
			waitForElementClickable(driver, BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
			clickToElement(driver, BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
			System.out.println(rowSize);
			clickToButtonByText(driver, textButton);
			clickToButtonBySpanText(driver, comfirmButton);
		}
	}
	
	// cái code nay chi tinh tren 1 trang thoi
	public boolean getRowIndex(WebDriver driver, String tableID, String aticleType) {
		String formattedNumberOfArticleLocator = String.format(BasePageUI.NUMBER_OF_ARTICLE, aticleType);
		waitForElementVisible(driver, formattedNumberOfArticleLocator);
		String numberOfArticleText = getElement(driver, formattedNumberOfArticleLocator).getText();
		int numberOfArticle = Integer.parseInt(numberOfArticleText);
		waitForElementVisible(driver, BasePageUI.TABLE_ROW, tableID);
		int rowSize = getElementSize(driver, BasePageUI.TABLE_ROW, tableID);
		if (numberOfArticle < 50) {
			if(numberOfArticle == rowSize) {
				System.out.println("numberOfArticle: " + numberOfArticle + " rowSize: " + rowSize  );
				return true;
			}
			System.out.println("numberOfArticle: " + numberOfArticle + " rowSize: " + rowSize  );
			return false;
		}
	    else {
	    	System.out.println("numberOfArticle: " + numberOfArticle + " rowSize: " + rowSize  );
			return true;
		}
		
	}
	
	public String getTotalArticleByTitle(WebDriver driver, String aticleStatus) {
		waitForElementVisible(driver, BasePageUI.NUMBER_OF_ARTICLE, aticleStatus);
		String total = getElementText(driver,BasePageUI.NUMBER_OF_ARTICLE , aticleStatus);
		System.out.println(total);
		return total;	
	}
	
	public boolean getNumberOfPage(WebDriver driver, String articleStatus) {
	    String totalItems = getTotalArticleByTitle(driver, articleStatus);
	    int numberOfTotal = Integer.parseInt(totalItems);
	    int itemsPerPage = 50;
	    int totalPages = (int) Math.ceil((double) numberOfTotal / itemsPerPage);
	    System.out.println("Total Pages: " + totalPages + " Total Item:" + articleStatus + ": " + numberOfTotal);
	    int actualTotalItems = 0;

	    try {
	        for (int i = 1; i <= totalPages; i++) {
	            driver.findElement(By.xpath("//nav[@aria-label='pagination navigation']//button[@aria-label='page " + i + "']")).click();

	            sleepInSecond(10);
	            List<WebElement> items = driver.findElements(By.cssSelector(".MuiPaginationItem-root.MuiPaginationItem-page"));
	            actualTotalItems += items.size();

	            if (i == totalPages) {
	                if (items.size() != (numberOfTotal - (itemsPerPage * (totalPages - 1)))) {
	                    return false;
	                }
	            } else {
	                if (items.size() != itemsPerPage) {
	                    return false;
	                }
	            }
	        }
	        return actualTotalItems == numberOfTotal;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public void selectColumnAndRow(WebDriver driver, String column, String row) {
		waitForElementClickable(driver, pageUIs.chub.BasePageUI.ROW_AND_COLUM_TABLE, column, row);
		clickToElement(driver, pageUIs.chub.BasePageUI.ROW_AND_COLUM_TABLE, column, row);
		
	}
	
	public String[] getRowColumTable(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.ROW_TABLE);
		int row = getElementSize(driver,BasePageUI.ROW_TABLE);
		waitForElementVisible(driver, BasePageUI.COLUMN_TABLE);
		int column = getElementSize(driver,BasePageUI.COLUMN_TABLE);
		String stringRow = Integer.toString(row);
		String stringColumn = Integer.toString(column);
		System.out.printf("Row: " + stringRow, "Column: " + stringColumn );
		return new String[]{stringColumn, stringRow};
	} 
	
	

}