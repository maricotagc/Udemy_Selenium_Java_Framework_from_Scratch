In order to use Excel

1. Download dependency (Apache POI ooxml)
2. Create reference for workbook in the method you are creating
XSSFWorkbook workbook = new XSSFWorkbook(/resources/listOfNames.xlsx) -- FOR XLSX
HSSFWorkbook workbook = new HSSFWorkbook(/resources/listOfNames.xls) -- FOR XLS
3. Create reference for worksheet in the class
XSSFSheet sheet = workbook.getSheet("Sheet1")
4. Function to count rows
sheet.getPhysicalNumberOfRows();
5. Function to get data from a cell
sheet.getRow(position).getCell(0).getStringCellValue();
sheet.getRow(position).getCell(1).getNumericCellValue();

-------------------

TestNG dependency
    <!-- https://mvnrepository.com/artifact/org.testng/testng -->
    <dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>7.0.0</version>
      <scope>test</scope>
    </dependency>
    
-------------------

TestNG Listeners are interfaces in TestNG library which keep track of test execution.

https://testng.org/doc/documentation-main.html

How to use listeners:
1. Create new package and new class
2. Implement ITest interface
3. Add unimplemented methods of ITest interface (in Java 8 the methods are already implemented in interface)
4. Create a demo (java class) using @Listener(packageName.ClassName)

-------------------
How to set priorities for tests in TestNG:  @Test(priority = 1)

-------------------
How to group tests (it can also be applied on class level):

1. Annotation in each test: @Test (groups = {"Sanity", "Smoke"})
2. Set up of xml
3. Execute xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="GroupingTest">
    <test name="UNO">
        <groups>
            <define name="Regression">
                <include name="Regression"></include>
                <include name="Smoke"></include>
                <include name = "Sanity"></include>
            </define>
            <define name="Sanity">
                <include name="Sanity"></include>
                <include name="Smoke"></include>
            </define>
            <run>
                <include name = "Regression"></include>
            </run>
        </groups>
        <classes>
            <class name="grouping.Grouping"/>
        </classes>
    </test>
</suite>

-------------------
Waits in Selenium

They should be used separately.

* Implicit: defines period until web driver throws "No Such Element" option. By default it is set to 0. It is applicable for the entire session browser.
    Syntax: driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
* Explicit: can be set for specific element, specific condition (e.g.: wait until element is clickable).
    Syntax: 
    WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));
* Fluent: defines period of waiting and frequency of checking (polling) of a condition.
-------------------
Headless Browsers

ChromeOptions options = new ChromeOptions();
options.addArguments("--headless");
WebDriver driver = new ChromeDriver(options);
-------------------

Automation of Non UI

https://www.youtube.com/watch?v=3nPFjfpDwGU&list=PLhW3qG5bs-L8oRay6qeS70vJYZ3SBQnFa&index=35


