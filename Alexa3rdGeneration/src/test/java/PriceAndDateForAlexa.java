import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.Version;
import org.apache.poi.EmptyFileException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Test
public class PriceAndDateForAlexa {

    public void excell() throws IOException {
        File src = new File("C:\\Users\\Syed\\Desktop\\AlexaPrice1.xls");

        FileInputStream fis = new FileInputStream(src);


        HSSFWorkbook wb = new HSSFWorkbook(fis);

        HSSFSheet sheet1 = wb.getSheetAt(0);

        String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
        System.out.println(data0);

        String data1 = sheet1.getRow(0).getCell(1).getStringCellValue();
        System.out.println(data1);

        wb.close();
    }
}
