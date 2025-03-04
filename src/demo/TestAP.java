package demo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.kingdee.bos.webapi.sdk.K3CloudApi;
import org.junit.Test;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class TestAP {

    /**
     * 获取应付单数据
     */
    @Test
    public void testGetAPPayable() throws Exception {
        K3CloudApi client = new K3CloudApi();

        // 使用 Gson 构建 JSON 对象
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("FormId", "AP_Payable");
        jsonObject.addProperty("FieldKeys", "FBillNo,FSUPPLIERID,FENDDATE_H,FDATE,FEntryTaxRate,FMATERIALID,FMaterialDesc,FModel,FPRICEUNITID,FPriceQty,FTaxPrice,FALLAMOUNTFOR_D");
        jsonObject.addProperty("FilterString", "");
        jsonObject.addProperty("OrderString", "");
        jsonObject.addProperty("TopRowCount", 0);
        jsonObject.addProperty("StartRow", 0);
        jsonObject.addProperty("Limit", 10);
        jsonObject.addProperty("SubSystemId", "");


        // 将 JsonObject 转换为 JSON 字符串
        String jsonData = gson.toJson(jsonObject);
        try {
            // 调用接口
            ArrayList<Appayable> appayables = new ArrayList<>();
            List<List<Object>> result = client.executeBillQuery(jsonData);
            for (List<Object> obj : result) {
                Appayable appayable = new Appayable();
                // FBillNo,FSUPPLIERID,FENDDATE_H,FDATE,FEntryTaxRate,FMATERIALID,FMaterialDesc,FModel,FPRICEUNITID,FPriceQty,FTaxPrice,FALLAMOUNTFOR_D
                appayable.setFBillNo((String) obj.get(0));
                appayable.setFSUPPLIERID(((Integer) obj.get(1)).longValue());
                appayable.setFENDDATE_H((String) obj.get(2));
                appayable.setFDATE((String) obj.get(3));
                appayable.setFEntryTaxRate((Double) obj.get(4));
                appayable.setFMATERIALID(((Integer) obj.get(5)).longValue());
                appayable.setFMaterialDesc((String) obj.get(6));
                appayable.setFModel((String) obj.get(7));
                appayable.setFPRICEUNITID(((Integer) obj.get(8)).longValue());
                appayable.setFPriceQty((Double) obj.get(9));
                appayable.setFTaxPrice((Double) obj.get(10));
                appayable.setFALLAMOUNTFOR_D((Double) obj.get(11));
                appayables.add(appayable);
            }

            for (Appayable appayable : appayables) {
                System.out.println(appayable);
            }

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /*
    获取所有的应付单数据
     */
    @Test
    public void testAllGetAPPayable() throws Exception {
        K3CloudApi client = new K3CloudApi();
        Gson gson = new Gson();
        ArrayList<Appayable> appayables = new ArrayList<>();

        // 定义每页获取的数据条数，这里可根据接口最大允许值设置（例如10000）
        int limit = 10000;
        // 从第0条数据开始读取
        int startRow = 0;

        while (true) {
            // 构建请求的 JSON 对象
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("FormId", "AP_Payable");
            jsonObject.addProperty("FieldKeys", "FBillNo,FSUPPLIERID,FENDDATE_H,FDATE,FEntryTaxRate,FMATERIALID,FMaterialDesc,FModel,FPRICEUNITID,FPriceQty,FTaxPrice,FALLAMOUNTFOR_D");
            jsonObject.addProperty("FilterString", "");
            jsonObject.addProperty("OrderString", "");
            jsonObject.addProperty("TopRowCount", 0);
            jsonObject.addProperty("StartRow", startRow);
            jsonObject.addProperty("Limit", limit);
            jsonObject.addProperty("SubSystemId", "");

            String jsonData = gson.toJson(jsonObject);

            // 调用接口获取一页数据
            List<List<Object>> result = client.executeBillQuery(jsonData);
            if (result == null || result.isEmpty()) {
                // 当返回结果为空时，说明所有数据已经读取完毕，退出循环
                break;
            }

            // 处理当前页数据
            for (List<Object> obj : result) {
                Appayable appayable = new Appayable();
                // 注意：此处的类型转换需要与实际返回的数据类型相符
                appayable.setFBillNo((String) obj.get(0));
                appayable.setFSUPPLIERID(((Integer) obj.get(1)).longValue());
                appayable.setFENDDATE_H((String) obj.get(2));
                appayable.setFDATE((String) obj.get(3));
                appayable.setFEntryTaxRate((Double) obj.get(4));
                appayable.setFMATERIALID(((Integer) obj.get(5)).longValue());
                appayable.setFMaterialDesc((String) obj.get(6));
                appayable.setFModel((String) obj.get(7));
                appayable.setFPRICEUNITID(((Integer) obj.get(8)).longValue());
                appayable.setFPriceQty((Double) obj.get(9));
                appayable.setFTaxPrice((Double) obj.get(10));
                appayable.setFALLAMOUNTFOR_D((Double) obj.get(11));
                appayables.add(appayable);
            }

            // 累加已读取的行数，准备读取下一页
            startRow += result.size();
        }

        // 输出所有获取的数据
        for (Appayable appayable : appayables) {
            System.out.println(appayable);
        }
    }


    /*
    获取供应商名称
     */
    @Test
    public void testGetSupplier() {
        K3CloudApi client = new K3CloudApi();
        // 使用 Gson 构建 JSON 对象
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("FormId", "BD_Supplier");
        jsonObject.addProperty("FieldKeys", "FName");
        jsonObject.addProperty("FilterString", "");
        jsonObject.addProperty("OrderString", "");
        jsonObject.addProperty("TopRowCount", 0);
        jsonObject.addProperty("StartRow", 0);
        jsonObject.addProperty("Limit", 2000);
        jsonObject.addProperty("SubSystemId", "");

        // 将 JsonObject 转换为 JSON 字符串
        String jsonData = gson.toJson(jsonObject);
        try {
            //调用接口
            String resultJson = String.valueOf(client.executeBillQuery(jsonData));
            System.out.println("接口返回结果: " + resultJson);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
