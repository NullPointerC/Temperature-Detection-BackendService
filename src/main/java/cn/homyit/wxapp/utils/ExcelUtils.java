package cn.homyit.wxapp.utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * @author Ziqiang CAO
 * @email 1213409187@qq.com
 */
public class ExcelUtils {
    private static FormulaEvaluator evaluator;
    /**
     * 获取单元格各类型值，返回字符串类型
     */
    public static String getCellValueByCell(Cell cell) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        //判断是否为null或空串
        if (cell==null || cell.toString().trim().equals("")) {
            return "";
        }
        String cellValue = "";
        int cellType=cell.getCellType();
        if(cellType==Cell.CELL_TYPE_FORMULA){ //表达式类型
            cellType=evaluator.evaluate(cell).getCellType();
        }

        switch (cellType) {
            case Cell.CELL_TYPE_STRING: //字符串类型
                cellValue= cell.getStringCellValue().trim();
                cellValue= StringUtils.isEmpty(cellValue) ? "" : cellValue;
                break;
            case Cell.CELL_TYPE_BOOLEAN:  //布尔类型
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC: //数值类型
                if (HSSFDateUtil.isCellDateFormatted(cell)) {  //判断日期类型
                    cellValue = sdf.format(cell.getDateCellValue()).toString();
                } else {  //否
                    cellValue = new DecimalFormat("#.######").format(cell.getNumericCellValue());
                }
                break;
            default: //其它类型，取空串吧
                cellValue = "";
                break;
        }
        return cellValue;
    }
}
