package algorithms;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestAnswer {

    /**
     * ①　文字列から指定した文字列を返却する
     * "abcde"→"bc"
     */
    static void test1() {
        String testStr = "abcde";
        testStr = testStr.substring(1, 3);
        System.out.println(testStr);
    }

    /**
     * ②　"abcde" 中に"bc"の存在チェック、"abcde" 中に"cc"の存在チェック 
     */
    static void test2() {
        String testStr = "abcde";
        System.out.println(testStr.contains("bc"));
        System.out.println(testStr.contains("cc"));
    }

    /**
     * ③　「+、-、*、／」メソッド作成 
     */
    static double test3(float a, char symbol, float b) {
        double x, y, result;
        x = (double) a;
        y = (double) b;
        switch (symbol) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '／':
            case '/':
                if (y == 0)
                    throw new RuntimeException("Dividend can't be 0.");
                result = x / y;
                break;
            default:
                throw new RuntimeException("error symbol");
        }
        return result;
    }

    /**
     * ④　ソート int [2,4,8,1]昇順 
     */
    static void test4(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * ⑤　九九表
     */
    static void test5() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

    /**
     * ⑥　楊輝三角
     */
    static void test6(int row) {
        int[][] triangle = new int[row][];
        for (int i = 0; i < row; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
                System.out.print(triangle[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * ⑦　文字列にある「半角スペース」「全角スペース」を置き換えて返却する
     * 例："a b　cde "→"abcde"
     */
    static String test7(String str) {
        if (str == null) return null;
        return str.replaceAll(" ", "").replaceAll("　", "");
    }

    /**
     * ⑧　ArrayListクラスをインスタンス作成し、5つの要素を追加する。また、3番目の要素を別の値に再設定する。
     * 例："日本"、"ブラジル"、"イングランド"、"ポルトガル"、"フランス"
     * -->"日本"、"ブラジル"、"England"、"ポルトガル"、"フランス"
     */
    @SuppressWarnings("unchecked")
    static void test8() {
        ArrayList<String> list = new ArrayList(Arrays.asList("日本", "ブラジル", "イングランド", "ポルトガル", "フランス"));
        for (String str : list) System.out.print(str + " ");
        list.remove(2);
        list.add(2, "England");
        System.out.println();
        for (String str : list) System.out.print(str + " ");
    }

    /**
     * ⑨　TXTファイルを読み込んで、正常データをExcelファイル（システム日付 + "_" + 自分の名前）「
     * 例：20170725_liyf.xlsx」に出力される。
     * チェック仕様
     * ①項目数が4つであること
     * ②年齢（3つ目）が数字であること
     *
     * @param inputPath  text path with file name
     * @param outputPath excel path without file name
     */
    static void test9(String inputPath, String outputPath) {
        File txtFile = new File(inputPath);
        if (!txtFile.exists()) throw new RuntimeException("can not find file");
        try {
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(txtFile));
            BufferedReader br = new BufferedReader(reader);
            int error = 0;
            ArrayList<String[]> datas = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                String[] items = line.split(",");
                if (items.length != 4 || !items[2].matches("\\d+")) {
                    error++;
                } else {
                    datas.add(items);
                }
                line = br.readLine();
            }
            exportExcel(datas, error, outputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exportExcel(List<String[]> datas, int error, String outputPath) {
        Workbook wb;
        OutputStream out = null;
        try {
            wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("test");
            Row r = sheet.createRow(0);
            r.createCell(0).setCellValue("ID");
            r.createCell(1).setCellValue("氏名");
            r.createCell(2).setCellValue("年齢");
            r.createCell(3).setCellValue("住所");
            int lineNo = 1;
            for (String[] data : datas) {
                r = sheet.createRow(lineNo);
                r.createCell(0).setCellValue(data[0]);
                r.createCell(1).setCellValue(data[1]);
                r.createCell(2).setCellValue(Integer.valueOf(data[2]));
                r.createCell(3).setCellValue(data[3]);
                lineNo++;
            }
            r = sheet.createRow(lineNo + 1);
            String result = String.format("正常：%d件　異常：%d件　合計：%d件", datas.size(), error, error + datas.size());
            r.createCell(0).setCellValue(result);
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            out = new FileOutputStream(outputPath + sdf.format(now) + "_xtq.xlsx");
            wb.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        //test1();

        //test2();

        //System.out.println("1+2="+test3(1,'+',2));

        //int[] arr = new int[]{2,4,8,1};
        //test4(arr);
        //for (int i:arr) System.out.println(i);

        //test5();

        //test6(7);

        //System.out.println(test7("a b　cde "));

        //test8();

        test9("./test9.txt", "./");
    }
}
