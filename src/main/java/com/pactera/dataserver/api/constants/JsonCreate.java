package com.pactera.dataserver.api.constants;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * xlsx只有一个sheet
 *
 * @author cht
 */
public class JsonCreate {
    public static void main(String[] args) {
        String readerPath = "C:\\Users\\Administrator\\Desktop\\test.xlsx";
        try (InputStream fileObject = Files.newInputStream(Paths.get(readerPath));
             Workbook workbook = WorkbookFactory.create(fileObject)) {
            boolean titleGroup = false;
            Sheet sheet = workbook.getSheetAt(0);
            List<String> listJson = new ArrayList<>();
            // 从第三行开始读取数据
            for (int i = 2; i <= sheet.getLastRowNum(); i++) {
                String tab = "{\n" +
                        "  \"groupName\": \"%s\",\n" +
                        "  \"title\": \"%s\",\n" +
                        "  \"subTitle\": \"%s\",\n" +
                        "  \"titleGroup\": \"%s\"\n" +
                        "}";
                Row r = sheet.getRow(i);
                // 空行结束循环
                if (r == null) {
                    break;
                }
                // グループ(第四列)
                Cell groupNameCell = r.getCell(3);
                String groupNameCellStr = getCellValue(sheet, groupNameCell);
                if (!StringUtils.isEmpty(groupNameCellStr)) {
                    titleGroup = !titleGroup;
                }
                // title(第五列)
                Cell titleCell = r.getCell(4);
                String titleCellStr = getCellValue(sheet, titleCell);
                // subTitle(第六列)
                Cell subTitleCell = r.getCell(5);
                String subTitleCellStr = getCellValue(sheet, subTitleCell);
                if (titleGroup) {
                    listJson.add(String.format(tab, groupNameCellStr, titleCellStr, subTitleCellStr, 0));
                } else {
                    listJson.add(String.format(tab, groupNameCellStr, titleCellStr, subTitleCellStr, 1));
                }
            }
            String print = "[" + String.join(", ", listJson) + "]";
            System.out.println(print);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getCellValue(Sheet sheet, Cell cell) {
        if (isMergedRegion(sheet, cell.getRowIndex(), cell.getColumnIndex())) {
            return getMergedRegionValue(sheet, cell.getRowIndex(), cell.getColumnIndex());
        } else {
            if (CellType.NUMERIC.equals(cell.getCellType())) {
                return String.valueOf((int) cell.getNumericCellValue());
            } else {
                return cell.getStringCellValue();
            }
        }
    }

    /**
     * 判断指定的单元格是否是合并单元格
     */
    private static boolean isMergedRegion(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取合并单元格的值
     */
    public static String getMergedRegionValue(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();

        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell);
                }
            }
        }

        return null;
    }

    /**
     * 获取单元格的值
     */
    public static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        return cell.toString();
    }
}
