package utils;

public class ExcelDataProvider {

    public void testData(String filePath) {
        ExcelUtils excel = new ExcelUtils(filePath);
        int rows = excel.namesCount();
        int cols = excel.colCount("Male");

        for (int i=1; i<rows ; i++) {
            for (int j=0; j< cols; j++) {

            }
        }
    }
}
