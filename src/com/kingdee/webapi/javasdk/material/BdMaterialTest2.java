package com.kingdee.webapi.javasdk.material;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.kingdee.bos.webapi.entity.IdentifyInfo;
import com.kingdee.bos.webapi.entity.RepoRet;
import com.kingdee.bos.webapi.sdk.K3CloudApi;
import com.kingdee.webapi.javasdk.common.SeqHelper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import static org.junit.Assert.fail;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BdMaterialTest2 {
    static String FNumber = SeqHelper.genNumber("WL");
    static String FName = "auwl_" + UUID.randomUUID().toString();

//    static K3CloudApi api = new K3CloudApi();

    /*本接口用于实现物料 (BD_Material) 的批量保存功能*/
    @Test
    public void stestBatchSaveCustomer() throws Exception {
        K3CloudApi api = new K3CloudApi();

        String data = "{\n" +
                "\t\"IsautoSubmitAndAudit\": true,\n" +
                "\t\"creator\": 0,\n" +
                "\t\"model\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"FMATERIALID\": 0,\n" +
                "\t\t\t\"fBaseUnitId\": {\n" +
                "\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"fCreateOrgId\": {\n" +
                "\t\t\t\t\"FNumber\": \"100\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"fMaterialGroup\": {\n" +
                "\t\t\t\t\"FNumber\": \"C.A\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"fName\": \"测试物料\",\n" +
                "\t\t\t\"fNumber\": \"C.A.111222\",\n" +
                "\t\t\t\"fSubHeadEntity\": {\n" +
                "\t\t\t\t\"fRetailUnitID\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "\t\t\t\"fUseOrgId\": {\n" +
                "\t\t\t\t\"FNumber\": \"100\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"subHeadEntity\": {\n" +
                "\t\t\t\t\"fBaseUnitId\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"fCategoryID\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"CHLB01_SYS\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"fErpClsID\": \"1\",\n" +
                "\t\t\t\t\"fFeatureItem\": \"1\",\n" +
                "\t\t\t\t\"fIsAsset\": false,\n" +
                "\t\t\t\t\"fIsInventory\": true,\n" +
                "\t\t\t\t\"fIsProduce\": false,\n" +
                "\t\t\t\t\"fIsPurchase\": true,\n" +
                "\t\t\t\t\"fIsSale\": true,\n" +
                "\t\t\t\t\"fIsSubContract\": false,\n" +
                "\t\t\t\t\"fVOLUMEUNITID\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"fWEIGHTUNITID\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "\t\t\t\"subHeadEntity1\": {\n" +
                "\t\t\t\t\"fExpPeriod\": 90,\n" +
                "\t\t\t\t\"fExpUnit\": \"D\",\n" +
                "\t\t\t\t\"fIsBatchManage\": true,\n" +
                "\t\t\t\t\"fIsKFPeriod\": true,\n" +
                "\t\t\t\t\"fStoreUnitID\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "\t\t\t\"subHeadEntity2\": {\n" +
                "\t\t\t\t\"fSalePriceUnitId\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"fSaleUnitId\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "\t\t\t\"subHeadEntity3\": {\n" +
                "\t\t\t\t\"fPurchasePriceUnitId\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"fPurchaseUnitId\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "\t\t\t\"subHeadEntity4\": {},\n" +
                "\t\t\t\"subHeadEntity5\": {\n" +
                "\t\t\t\t\"fBOMUnitId\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"fFinishReceiptOverRate\": 0.0,\n" +
                "\t\t\t\t\"fFinishReceiptShortRate\": 0.0,\n" +
                "\t\t\t\t\"fIsMainPrd\": false,\n" +
                "\t\t\t\t\"fMinIssueUnitId\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"fProduceUnitId\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"f_RPNY_MAH\": 1,\n" +
                "\t\t\t\t\"f_RPNY_QTYBATTERIES\": 1,\n" +
                "\t\t\t\t\"f_RPNY_TOTALENERGY\": 3.16,\n" +
                "\t\t\t\t\"f_RPNY_VOLTAGE\": 3.16\n" +
                "\t\t\t},\n" +
                "\t\t\t\"subHeadEntity6\": {\n" +
                "\t\t\t\t\"FCheckIncoming\": false,\n" +
                "\t\t\t\t\"FCheckStock\": false\n" +
                "\t\t\t},\n" +
                "\t\t\t\"subHeadEntity7\": {\n" +
                "\t\t\t\t\"fSubconPriceUnitId\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"fSubconUnitId\": {\n" +
                "\t\t\t\t\t\"FNumber\": \"kg\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"needReturnFields\": [\n" +
                "\t\t\"FMATERIALID\"\n" +
                "\t],\n" +
                "\t\"needUpDateFields\": [\n" +
                "\t\t\"FExpUnit\",\n" +
                "\t\t\"FExpPeriod\",\n" +
                "\t\t\"FMATERIALID\",\n" +
                "\t\t\"FErpClsID\",\n" +
                "\t\t\"FName\",\n" +
                "\t\t\"FNumber\",\n" +
                "\t\t\"FSpecification\",\n" +
                "\t\t\"FUseOrgId\",\n" +
                "\t\t\"FCategoryID\",\n" +
                "\t\t\"FMaterialGroup\",\n" +
                "\t\t\"FRetailUnitID\",\n" +
                "\t\t\"FWEIGHTUNITID\",\n" +
                "\t\t\"FVOLUMEUNITID\",\n" +
                "\t\t\"FIsPurchase\",\n" +
                "\t\t\"FIsInventory\",\n" +
                "\t\t\"FIsSubContract\",\n" +
                "\t\t\"FIsSale\",\n" +
                "\t\t\"FIsAsset\",\n" +
                "\t\t\"FIsProduce\",\n" +
                "\t\t\"FIsBatchManage\",\n" +
                "\t\t\"F_RPNY_MAH\",\n" +
                "\t\t\"F_RPNY_VOLTAGE\",\n" +
                "\t\t\"F_RPNY_QTYBATTERIES\",\n" +
                "\t\t\"F_RPNY_TOTALENERGY\",\n" +
                "\t\t\"SubHeadEntity1\",\n" +
                "\t\t\"SubHeadEntity2\",\n" +
                "\t\t\"SubHeadEntity3\",\n" +
                "\t\t\"SubHeadEntity4\",\n" +
                "\t\t\"SubHeadEntity5\",\n" +
                "\t\t\"SubHeadEntity6\",\n" +
                "\t\t\"SubHeadEntity7\",\n" +
                "\t\t\"SubHeadEntity\",\n" +
                "\t\t\"FSubHeadEntity\"\n" +
                "\t]\n" +
                "}";
        // 批量保存物料信息
        String sRet = api.batchSave("BD_Material", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(sRet, RepoRet.class);
        System.out.println(String.format("批量保持物料:%s", gson.toJson(repoRet.getResult())));

    }



}




