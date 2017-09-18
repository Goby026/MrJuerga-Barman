/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Grover
 */
public class LeerExcel {

    File fileName;

    public LeerExcel(File fileName) {
        this.fileName = fileName;
//        List cellData = new ArrayList<>();
//        try {
//
//            FileInputStream finput = new FileInputStream(fileName);
//
//            XSSFWorkbook workBook = new XSSFWorkbook(finput);
//
//            XSSFSheet hSheet = workBook.getSheetAt(0);
//
//            Iterator rowIterator = hSheet.rowIterator();
//
//            while (rowIterator.hasNext()) {
//                XSSFRow hssfRow = (XSSFRow) rowIterator.next();
//
//                Iterator iterator = hssfRow.cellIterator();
//                List celTemp = new ArrayList();
//
//                while (iterator.hasNext()) {
//                    XSSFCell hssfCell = (XSSFCell) iterator.next();
//
//                    celTemp.add(hssfCell);
//
//                }
//                cellData.add(celTemp);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        obtener(cellData);
    }

//    private void obtener(List cellDataList) {
//        try {
//            for (int i = 0; i < cellDataList.size(); i++) {
//                List cellTempList = (List) cellDataList.get(i);
//                for (int j = 0; j < cellTempList.size(); j++) {
//                    XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
//
//                    String stringCellValue = hssfCell.toString();
//                    System.out.println(stringCellValue + " ");
//                }
//                System.out.println("");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    public static void leer() {
        try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\MARCEL\\Desktop\\JAVA.xlsx"));

            XSSFWorkbook workBook = new XSSFWorkbook(file);
            XSSFSheet hSheet = workBook.getSheetAt(0);

            int numFilas = hSheet.getLastRowNum();

            for (int i = 0; i <= numFilas; i++) {
                Row fila = hSheet.getRow(i);
                int numCols = fila.getLastCellNum();

                for (int j = 0; j < numCols; j++) {
                    Cell celda = fila.getCell(j);

                    switch (celda.getCellTypeEnum().toString()) {
                        case "NUMERIC":
                            System.out.print(celda.getNumericCellValue() + " ");
                            break;
                        case "STRING":
                            System.out.print(celda.getStringCellValue() + " ");
                            break;
                        case "FORMULA":
                            System.out.print(celda.getCellFormula() + " ");
                            break;
                    }
                }
                System.out.println("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

        leer();
//        File file = new File("C:\\Users\\MARCEL\\Desktop\\JAVA.xlsx");
//
//        if (file.exists()) {
//            LeerExcel leer = new LeerExcel(file);
//        }
    }

}
