package com.pactera.dataserver.api.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pactera.dataserver.core.sbcf.UtilDoc;
import lombok.Data;

/**
 * @author Pactera WangShuai
 * @date 2019/12/23 16:07
 */
@Data
public class AcomReq extends UtilDoc {
    private String form_id;
    private String loan;
    /**
     * 勤務パラメータ名
     **/
    @JsonProperty("kinmu-birthYear")
    private String kinmu_birthYear;
    @JsonProperty("kinmu-birthMonth")
    private String kinmu_birthMonth;
    @JsonProperty("kinmu-birthDay")
    private String kinmu_birthDay;
    @JsonProperty("kinmu-nameSei")
    private String kinmu_nameSei;
    @JsonProperty("kinmu-nameMei")
    private String kinmu_nameMei;
    @JsonProperty("kinmu-nameSeiKana")
    private String kinmu_nameSeiKana;
    @JsonProperty("kinmu-nameMeiKana")
    private String kinmu_nameMeiKana;
    @JsonProperty("kinmu-kyuseiCheck")
    private String kinmu_kyuseiCheck;
    @JsonProperty("kinmu-kyuseiNamaeSei")
    private String kinmu_kyuseiNamaeSei;
    @JsonProperty("kinmu-kyuseiNamaeSeiKana")
    private String kinmu_kyuseiNamaeSeiKana;
    @JsonProperty("kinmu-sex")
    private String kinmu_sex;
    @JsonProperty("kinmu-married")
    private String kinmu_married;
    private String kinmu_jitakuJushoPost;
    private String kinmu_jitakuJushoTodofuken;
    private String kinmu_jitakuJushoShikuchoson;
    @JsonProperty("kinmu-jitakuJushoBanchi")
    private String kinmu_jitakuJushoBanchi;
    @JsonProperty("kinmu-jitakuTelCheck")
    private String kinmu_jitakuTelCheck;
    @JsonProperty("kinmu-jitakuTel")
    private String kinmu_jitakuTel;
    @JsonProperty("kinmu-jitakuTelKeiyaku")
    private String kinmu_jitakuTelKeiyaku;
    @JsonProperty("kinmu-keitaiTelCheck")
    private String kinmu_keitaiTelCheck;
    @JsonProperty("kinmu-keitaiTel")
    private String kinmu_keitaiTel;
    @JsonProperty("kinmu-keitaiTelKeiyaku")
    private String kinmu_keitaiTelKeiyaku;
    @JsonProperty("kinmu-jitakuShurui")
    private String kinmu_jitakuShurui;
    @JsonProperty("kinmu-jitakuMochiie")
    private String kinmu_jitakuMochiie;
    @JsonProperty("kinmu-jitakuChintai")
    private String kinmu_jitakuChintai;
    @JsonProperty("kinmu-jitakuShataku")
    private String kinmu_jitakuShataku;
    @JsonProperty("kinmu-jitakuNyukyoYear")
    private String kinmu_jitakuNyukyoYear;
    @JsonProperty("kinmu-jitakuNyukyoMonth")
    private String kinmu_jitakuNyukyoMonth;
    @JsonProperty("kinmu-jitakuLoanCheck")
    private String kinmu_jitakuLoanCheck;
    @JsonProperty("kinmu-jitakuLoanMonthly")
    private String kinmu_jitakuLoanMonthly;
    @JsonProperty("kinmu-jitakuLoanBonus")
    private String kinmu_jitakuLoanBonus;
    @JsonProperty("kinmu-jitakuNinzu")
    private String kinmu_jitakuNinzu;
    @JsonProperty("kinmu-jitakuKodomo")
    private String kinmu_jitakuKodomo;
    @JsonProperty("kinmu-kinmusakiShukkoKeitai")
    private String kinmu_kinmusakiShukkoKeitai;
    @JsonProperty("kinmu-kinmusakiName")
    private String kinmu_kinmusakiName;
    @JsonProperty("kinmu-kinmusakiNameKana")
    private String kinmu_kinmusakiNameKana;
    private String kinmu_kinmusakiPost;
    private String kinmu_kinmusakiTodofuken;
    private String kinmu_kinmusakiShikuchoson;
    @JsonProperty("kinmu-kinmusakiBanchi")
    private String kinmu_kinmusakiBanchi;
    @JsonProperty("kinmu-kinmusakiTel")
    private String kinmu_kinmusakiTel;
    @JsonProperty("kinmu-kinmusakiNyushaYear")
    private String kinmu_kinmusakiNyushaYear;
    @JsonProperty("kinmu-kinmusakiNyushaMonth")
    private String kinmu_kinmusakiNyushaMonth;
    @JsonProperty("kinmu-kinmusakiGyoshu")
    private String kinmu_kinmusakiGyoshu;
    @JsonProperty("kinmu-kinmusakiShokushu")
    private String kinmu_kinmusakiShokushu;
    @JsonProperty("kinmu-kinmusakiShozoku")
    private String kinmu_kinmusakiShozoku;
    @JsonProperty("kinmu-kinmusakiShainsu")
    private String kinmu_kinmusakiShainsu;
    @JsonProperty("kinmu-hoken")
    private String kinmu_hoken;
    @JsonProperty("kinmu-kinmusakiNenshu")
    private String kinmu_kinmusakiNenshu;
    @JsonProperty("kinmu-kinmusakiShukkoShunyu")
    private String kinmu_kinmusakiShukkoShunyu;
    @JsonProperty("kinmu-kinmusakiShukko")
    private String kinmu_kinmusakiShukko;
    @JsonProperty("kinmu-kinmusakiShukkoName")
    private String kinmu_kinmusakiShukkoName;
    @JsonProperty("kinmu-kinmusakiShukkoNameKana")
    private String kinmu_kinmusakiShukkoNameKana;
    private String kinmu_kinmusakiShukkoPost;
    private String kinmu_kinmusakiShukkoTodofuken;
    private String kinmu_kinmusakiShukkoShikuchoson;
    @JsonProperty("kinmu-kinmusakiShukkoBanchi")
    private String kinmu_kinmusakiShukkoBanchi;
    @JsonProperty("kinmu-kinmusakiShukkoTel")
    private String kinmu_kinmusakiShukkoTel;
    @JsonProperty("kinmu-kariireCheck")
    private String kinmu_kariireCheck;
    @JsonProperty("kinmu-kariireGinkoYen")
    private String kinmu_kariireGinkoYen;
    @JsonProperty("kinmu-kariireGinkoKen")
    private String kinmu_kariireGinkoKen;
    @JsonProperty("kinmu-kariireLoanYen")
    private String kinmu_kariireLoanYen;
    @JsonProperty("kinmu-kariireLoanKen")
    private String kinmu_kariireLoanKen;
    @JsonProperty("kinmu-kariireCardYen")
    private String kinmu_kariireCardYen;
    @JsonProperty("kinmu-kariireCardKen")
    private String kinmu_kariireCardKen;
    @JsonProperty("kinmu-kariireShohishakinyuYen")
    private String kinmu_kariireShohishakinyuYen;
    @JsonProperty("kinmu-kariireShohishakinyuKen")
    private String kinmu_kariireShohishakinyuKen;
    @JsonProperty("kinmu-hensaiCheck")
    private String kinmu_hensaiCheck;
    @JsonProperty("kinmu-hensaiMaitsukishitei")
    private String kinmu_hensaiMaitsukishitei;
    @JsonProperty("kinmu-questionnaire01")
    private String kinmu_questionnaire01;
    @JsonProperty("kinmu-questionnaire02")
    private String kinmu_questionnaire02;
    @JsonProperty("kinmu-questionnaire03")
    private String kinmu_questionnaire03;
    @JsonProperty("kinmu-questionnaire04")
    private String kinmu_questionnaire04;
    @JsonProperty("kinmu-questionnaire10")
    private String kinmu_questionnaire10;
    @JsonProperty("kinmu-kozaCheck")
    private String kinmu_kozaCheck;
    @JsonProperty("kinmu-mail")
    private String kinmu_mail;
    @JsonProperty("kinmu-password")
    private String kinmu_password;
    @JsonProperty("kinmu-passwordKakunin")
    private String kinmu_passwordKakunin;
    @JsonProperty("kinmu-order_datetime")
    private String kinmu_order_datetime;
    @JsonProperty("kinmu-agreement_datetime_1")
    private String kinmu_agreement_datetime_1;
    @JsonProperty("kinmu-ipaddress")
    private String kinmu_ipaddress;
    @JsonProperty("kinmu-useragent")
    private String kinmu_useragent;

    /**
     * 主婦パラメータ名
     **/
    @JsonProperty("shufu-birthYear")
    private String shufu_birthYear;
    @JsonProperty("shufu-birthMonth")
    private String shufu_birthMonth;
    @JsonProperty("shufu-birthDay")
    private String shufu_birthDay;
    @JsonProperty("shufu-nameSei")
    private String shufu_nameSei;
    @JsonProperty("shufu-nameMei")
    private String shufu_nameMei;
    @JsonProperty("shufu-nameSeiKana")
    private String shufu_nameSeiKana;
    @JsonProperty("shufu-nameMeiKana")
    private String shufu_nameMeiKana;
    @JsonProperty("shufu-kyuseiCheck")
    private String shufu_kyuseiCheck;
    @JsonProperty("shufu-kyuseiNamaeSei")
    private String shufu_kyuseiNamaeSei;
    @JsonProperty("shufu-kyuseiNamaeSeiKana")
    private String shufu_kyuseiNamaeSeiKana;
    @JsonProperty("shufu-sex")
    private String shufu_sex;
    @JsonProperty("shufu-married")
    private String shufu_married;
    private String shufu_jitakuJushoPost;
    private String shufu_jitakuJushoTodofuken;
    private String shufu_jitakuJushoShikuchoson;
    @JsonProperty("shufu-jitakuJushoBanchi")
    private String shufu_jitakuJushoBanchi;
    @JsonProperty("shufu-jitakuTelCheck")
    private String shufu_jitakuTelCheck;
    @JsonProperty("shufu-jitakuTel")
    private String shufu_jitakuTel;
    @JsonProperty("shufu-jitakuTelKeiyaku")
    private String shufu_jitakuTelKeiyaku;
    @JsonProperty("shufu-keitaiTelCheck")
    private String shufu_keitaiTelCheck;
    @JsonProperty("shufu-keitaiTel")
    private String shufu_keitaiTel;
    @JsonProperty("shufu-keitaiTelKeiyaku")
    private String shufu_keitaiTelKeiyaku;
    @JsonProperty("shufu-jitakuShurui")
    private String shufu_jitakuShurui;
    @JsonProperty("shufu-jitakuMochiie")
    private String shufu_jitakuMochiie;
    @JsonProperty("shufu-jitakuChintai")
    private String shufu_jitakuChintai;
    @JsonProperty("shufu-jitakuShataku")
    private String shufu_jitakuShataku;
    @JsonProperty("shufu-jitakuNyukyoYear")
    private String shufu_jitakuNyukyoYear;
    @JsonProperty("shufu-jitakuNyukyoMonth")
    private String shufu_jitakuNyukyoMonth;
    @JsonProperty("shufu-jitakuLoanCheck")
    private String shufu_jitakuLoanCheck;
    @JsonProperty("shufu-jitakuLoanMonthly")
    private String shufu_jitakuLoanMonthly;
    @JsonProperty("shufu-jitakuLoanBonus")
    private String shufu_jitakuLoanBonus;
    @JsonProperty("shufu-jitakuNinzu")
    private String shufu_jitakuNinzu;
    @JsonProperty("shufu-jitakuKodomo")
    private String shufu_jitakuKodomo;
    @JsonProperty("shufu-hoken")
    private String shufu_hoken;
    @JsonProperty("shufu-nenshu")
    private String shufu_nenshu;
    @JsonProperty("shufu-kariireCheck")
    private String shufu_kariireCheck;
    @JsonProperty("shufu-kariireGinkoYen")
    private String shufu_kariireGinkoYen;
    @JsonProperty("shufu-kariireGinkoKen")
    private String shufu_kariireGinkoKen;
    @JsonProperty("shufu-kariireLoanYen")
    private String shufu_kariireLoanYen;
    @JsonProperty("shufu-kariireLoanKen")
    private String shufu_kariireLoanKen;
    @JsonProperty("shufu-kariireCardYen")
    private String shufu_kariireCardYen;
    @JsonProperty("shufu-kariireCardKen")
    private String shufu_kariireCardKen;
    @JsonProperty("shufu-kariireShohishakinyuYen")
    private String shufu_kariireShohishakinyuYen;
    @JsonProperty("shufu-kariireShohishakinyuKen")
    private String shufu_kariireShohishakinyuKen;
    @JsonProperty("shufu-hensaiCheck")
    private String shufu_hensaiCheck;
    @JsonProperty("shufu-hensaiMaitsukishitei")
    private String shufu_hensaiMaitsukishitei;
    @JsonProperty("shufu-questionnaire01")
    private String shufu_questionnaire01;
    @JsonProperty("shufu-questionnaire02")
    private String shufu_questionnaire02;
    @JsonProperty("shufu-questionnaire03")
    private String shufu_questionnaire03;
    @JsonProperty("shufu-questionnaire04")
    private String shufu_questionnaire04;
    @JsonProperty("shufu-questionnaire10")
    private String shufu_questionnaire10;
    @JsonProperty("shufu-KozaCheck")
    private String shufu_KozaCheck;
    @JsonProperty("shufu-mail")
    private String shufu_mail;
    @JsonProperty("shufu-password")
    private String shufu_password;
    @JsonProperty("shufu-passwordKakunin")
    private String shufu_passwordKakunin;
    @JsonProperty("shufu-order_datetime")
    private String shufu_order_datetime;
    @JsonProperty("shufu-agreement_datetime_1")
    private String shufu_agreement_datetime_1;
    @JsonProperty("shufu-ipaddress")
    private String shufu_ipaddress;
    @JsonProperty("shufu-useragent")
    private String shufu_useragent;
}
