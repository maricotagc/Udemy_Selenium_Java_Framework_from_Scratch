package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private XSSFWorkbook workbook = null;
    private XSSFSheet men = null;
    private XSSFSheet women = null;

    public ExcelUtils(String filePath) {
        try {
            workbook = new XSSFWorkbook(filePath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public int namesCount() {
        men = workbook.getSheet("Men");
        women = workbook.getSheet("Women");
        int menCount = men.getPhysicalNumberOfRows();
        int womenCount = women.getPhysicalNumberOfRows();
        int total = menCount + womenCount;
        System.out.println("We have a list containing " + total + " names.");
        return total;
    }

    public int colCount(String gender) {
        if (gender.equals("Male")) {
            return workbook.getSheet("Men").getRow(1).getPhysicalNumberOfCells();
        } else {
            return workbook.getSheet("Women").getRow(1).getPhysicalNumberOfCells();
        }
    }

    public String getName(int position, String gender) {
        String name = null;
        if (gender.equals("Male")) {
            men = workbook.getSheet("Men");
            name = men.getRow(position).getCell(0).getStringCellValue();
            return name;
        } else {
            men = workbook.getSheet("Women");
            name = men.getRow(position).getCell(0).getStringCellValue();
            return name;
        }
    }

    public void getHowManyPeopleWithName(int position, String gender) {
        if (gender.equals("Male")) {
            men = workbook.getSheet("Men");
            Double total = men.getRow(position).getCell(1).getNumericCellValue();
            String name = getName(position, gender);
            System.out.println("The total number of " + name + "'s in the world is " + total + ".");
        } else {
            men = workbook.getSheet("Women");
            Double total = men.getRow(position).getCell(1).getNumericCellValue();
            String name = getName(position, gender);
            System.out.println("The total number of " + name + "'s in the world is " + total + ".");
        }
    }

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");

        ExcelUtils test = new ExcelUtils(projectPath + "/src/main/resources/listOfNames.xlsx");
        test.namesCount();
        System.out.println("The name is " + test.getName(49, "Female"));
        test.getHowManyPeopleWithName(33, "Male");
        System.out.println(test.colCount("Female"));
    }
}
