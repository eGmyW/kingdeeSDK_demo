package demo;

public class Appayable {
    String FBillNo;          // 账单编号
    Long FSUPPLIERID;         // 供应商ID
    String FENDDATE_H;       // 结束日期
    String FDATE;            // 开始日期
    double FEntryTaxRate;    // 项目税率
    Long FMATERIALID;         // 材料ID
    String FMaterialDesc;    // 材料描述
    String FModel;           // 型号
    Long FPRICEUNITID;        // 价格单位ID
    double FPriceQty;        // 价格数量
    double FTaxPrice;        // 含税价格
    double FALLAMOUNTFOR_D;  // 总金额

    public Long getFSUPPLIERID() {
        return FSUPPLIERID;
    }

    public void setFSUPPLIERID(Long FSUPPLIERID) {
        this.FSUPPLIERID = FSUPPLIERID;
    }

    public String getFBillNo() {
        return FBillNo;
    }

    public void setFBillNo(String FBillNo) {
        this.FBillNo = FBillNo;
    }

    public String getFENDDATE_H() {
        return FENDDATE_H;
    }

    public void setFENDDATE_H(String FENDDATE_H) {
        this.FENDDATE_H = FENDDATE_H;
    }

    public String getFDATE() {
        return FDATE;
    }

    public void setFDATE(String FDATE) {
        this.FDATE = FDATE;
    }

    public double getFEntryTaxRate() {
        return FEntryTaxRate;
    }

    public void setFEntryTaxRate(double FEntryTaxRate) {
        this.FEntryTaxRate = FEntryTaxRate;
    }

    public String getFMaterialDesc() {
        return FMaterialDesc;
    }

    public void setFMaterialDesc(String FMaterialDesc) {
        this.FMaterialDesc = FMaterialDesc;
    }

    public Long getFMATERIALID() {
        return FMATERIALID;
    }

    public void setFMATERIALID(Long FMATERIALID) {
        this.FMATERIALID = FMATERIALID;
    }

    public String getFModel() {
        return FModel;
    }

    public void setFModel(String FModel) {
        this.FModel = FModel;
    }

    public Long getFPRICEUNITID() {
        return FPRICEUNITID;
    }

    @Override
    public String toString() {
        return "Appayable{" +
                "FBillNo='" + FBillNo + '\'' +
                ", FSUPPLIERID=" + FSUPPLIERID +
                ", FENDDATE_H='" + FENDDATE_H + '\'' +
                ", FDATE='" + FDATE + '\'' +
                ", FEntryTaxRate=" + FEntryTaxRate +
                ", FMATERIALID=" + FMATERIALID +
                ", FMaterialDesc='" + FMaterialDesc + '\'' +
                ", FModel='" + FModel + '\'' +
                ", FPRICEUNITID=" + FPRICEUNITID +
                ", FPriceQty=" + FPriceQty +
                ", FTaxPrice=" + FTaxPrice +
                ", FALLAMOUNTFOR_D=" + FALLAMOUNTFOR_D +
                '}';
    }

    public void setFPRICEUNITID(Long FPRICEUNITID) {
        this.FPRICEUNITID = FPRICEUNITID;
    }

    public double getFPriceQty() {
        return FPriceQty;
    }

    public void setFPriceQty(double FPriceQty) {
        this.FPriceQty = FPriceQty;
    }

    public double getFTaxPrice() {
        return FTaxPrice;
    }

    public void setFTaxPrice(double FTaxPrice) {
        this.FTaxPrice = FTaxPrice;
    }

    public double getFALLAMOUNTFOR_D() {
        return FALLAMOUNTFOR_D;
    }

    public void setFALLAMOUNTFOR_D(double FALLAMOUNTFOR_D) {
        this.FALLAMOUNTFOR_D = FALLAMOUNTFOR_D;
    }
}
