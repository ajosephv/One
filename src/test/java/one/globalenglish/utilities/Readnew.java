package one.globalenglish.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readnew {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File f= new File("./src/test/java/one/globalenglish/testData/LoginData.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w;
		
		w= new XSSFWorkbook(fis);
		Sheet s=w.getSheet("Sheet2");
		int rows=s.getLastRowNum();
		System.out.println(rows);

	}

}
