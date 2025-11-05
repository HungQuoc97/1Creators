package pageUIs.chub;

public class BasePageUI {

	public static final String BUTTON_BY_TYPE = "//button[@type='%s']";
	public static final String TEXTBOX_BY_ID = "//input[@name='%s']";
	public static final String TEXT_VALUE = "//div[text()='%s']";
	public static final String TEXT_VALUE_1 = "//div[text()='%s']";
	public static final String BUTTON_BY_TEXT = "//button[text()='%s']";
	public static final String TEXTBOX_BY_TYPE = "//input[@type='%s']";
	public static final String TEXT_VERIFY = "//p[text()='%s']";
	public static final String TEXBOX_TITLE = "//*[contains(@class, 'title')]//p";
	public static final String BUTTON_BY_TEXT_SPAN = "//span[text()='%s']//parent::button";
	public static final String VERIFY_BODY_TABLE = "//td[contains(@class, 'MuiTableCell')]/span[text()='%s']//parent::td/parent::tr//parent::tbody/preceding::thead//th[text()='%s']";
	public static final String BACK_BUTTON = "//div[@class='flex gap-[20px]']//button/img";
	public static final String TEXTBOX_SEARCH = "//span[text()='검색어']/parent::div//input[@placeholder='검색어를 입력해 주세요.']";
	public static final String UPLOAD_FILE = "//span[text()='Thay đổi ảnh profile của bạn']/ancestor::div[contains(@class,'MuiStack-root')]//input[@class= 'uppy-Dashboard-input']";
	public static final String BUTTON_MENU_BAR = "//div[@class='menuMain']//li[@role='menuitem']//div[text()='%s']/following-sibling::a";
	public static final String TABLE_HEADER_BY_NAME = "//table[contains(@class,'%s')]//th[string()='%s']/preceding-sibling::th";
	public static final String TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX = "//table[contains(@class,'%s')]//tbody[contains(@class, 'MuiTableBody-root')]//tr[%s]//td[%s]//div" ;
	public static final String TABLE_ROW = "//table[contains(@class,'%s')]//tbody[contains(@class, 'MuiTableBody-root')]//tr//td[contains(@class,'truncate')][1]" ;
	public static final String NUMBER_OF_ARTICLE ="//div[contains(@class,'MuiTabs-scroller')]//button//span[text()='%s']//following-sibling::span";
	public static final String ROW_AND_COLUM_TABLE = "//div[@class='table-select']//div[@class='row'][%s]//div[@class=' box'][%s]";
	public static final String BUTTON_BY_TEXT_TABLE = "//div[text()='%s']//parent::div//parent::button";
	public static final String ROW_TABLE = "//div[@class='ck ck-editor__main']//table//tr";
	public static final String COLUMN_TABLE = "//div[@class='ck ck-editor__main']//table//tr[1]//td";
	public static final String USER_NAME =  "//div[contains(@class,'MuiAvatar-root MuiAvatar')]/parent::div/following-sibling::h6" ;
	public static final String TEXBOX_BY_LABLE =  "//p[text() = '%s']/parent::div/following-sibling::div//input" ;
	public static final String TEXT_AREA_BY_LABLE =  "//p[text() = 'Giới thiệu ngắn về nhà sáng tạo']/parent::div/following-sibling::div//div[@role='textbox']" ;
	public static final String BUTTON_BY_LABLE =  "//p[text()='%s']/parent::div/following-sibling::div//button[@type='submit' ]" ;
	public static final String TOAST_MESSAGE_VERIFY = "//section[@aria-label='Notifications Alt+T']//p";
	public static final String X_ICON = "//section[@aria-label=\"Notifications Alt+T\"]//button";
    public static final String DROPDOWN_OPTIONS = "//ul[@role='listbox']//li[normalize-space()='%s']";
	public static final String INPUT_UPLOAD_FILE = "//div[@class='MuiAvatar-root MuiAvatar-circular css-1x4wjoz']/following-sibling::button";
	public static final String SAVE_IMAGE = "//button[text()='Lưu']";
	public static final String PROGRESSBAR_ICON = "//span[contains(@class,'MuiCircularProgress-root')]";
	public static final String ICON_BOTTOM = "//aside//button[@type='button']";
	public static final String MENU_ICON_BOTTOM = "//div[@role='presentation']//span[text()='%s']";
	public static final String DISCRIPTION_SUPPORT_REQUEST = "//p[text() = '%s']/parent::div/following-sibling::div//textarea[@name='description']";
	public static final String SOCIAL_ICON = "//p[normalize-space()='%s']/ancestor::div[contains(@class,'cursor-pointer')]\r\n"
			+ "";
	
	
	//p[text() = 'Mô tả chi tiết']/parent::div/following-sibling::div//textarea[@name='description']
	
	
	
	//div[contains(@class,'MuiTabs-scroller')]//button//span[text()='작성중']//following-sibling::span
	//table[contains(@class,'MuiTable-root MuiTable')]//tbody[contains(@class, 'MuiTableBody-root')]//tr[2]//td[5]//div
	//table[contains(@class,'MuiTable-root MuiTable')]//tbody[contains(@class, 'MuiTableBody-root')]//tr[2]//td[5]
	
	//div[@class='table-select']//div[@class='row'][5]//div[@class=' box'][5]

}