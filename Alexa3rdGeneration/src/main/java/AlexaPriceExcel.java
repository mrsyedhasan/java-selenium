import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class AlexaPriceExcel {


public void excell() throws IOException {
        File src = new File("C:\\Users\\Syed\\Desktop\\AlexaPrice.xlsx");

        FileInputStream fis = new FileInputStream(src);

        HSSFWorkbook wb = new HSSFWorkbook(fis);

        HSSFSheet sheet1 = wb.getSheetAt(0);

        String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();

        System.out.println(data0);



        }
}