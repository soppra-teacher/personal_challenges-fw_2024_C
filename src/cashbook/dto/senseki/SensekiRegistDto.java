package cashbook.dto.senseki;

import java.util.Map;

import cashbook.dto.common.BaseDto;

/**
 * 戦績マスタ登録画面用DTO
 * @author soppra
 */
public class SensekiRegistDto extends BaseDto {
	
	/**試合ID */
	private String matchId;
	/**選手名 */
	private String senshuNm;
	/** イニング */
	private String ining;
	/** 球数 */
	private String tamakazu;
	/** 被安打 */
	private String hianda;
	/** 与四死球 */
	private String yoshishikyu;
	/** 奪三振 */
	private String datsusanshin;
	/** 失点 */
	private String sitten;
	/** 自責点 */
	private String jisekiten;
	/** 対戦相手 */
	private String taisenNm;
	/** 試合日 */
	private String shiaibi;

	/** 戦績ＣＤ */
	private String sensekiCd;
	/** 戦績名 */
	private String sensekiNm;
	/** 戦績区分（キー） */
	private String sensekiKbnKey;
	/** 戦績区分 （Ｍａｐ）*/
	private Map<String, String> sensekiKbn;
	/** 戦績区分名称 */
	private String sensekiKbnNm;
	
	/** 続柄（ＭＡＰ） */
	private Map<String, String> zokugara;

	/** 続柄（キー） */
	private String zokugaraKey;
	
	private String zokugaraNm;

	/**
	 * 戦績ＣＤを取得します。
	 * @return 戦績ＣＤ
	 */
	public String getSensekiCd() {
	    return sensekiCd;
	}
	/**
	 * 戦績ＣＤを設定します。
	 * @param sensekiCd 戦績ＣＤ
	 */
	public void setSensekiCd(String sensekiCd) {
	    this.sensekiCd = sensekiCd;
	}
	/**
	 * 戦績名を取得します。
	 * @return 戦績名
	 */
	public String getSensekiNm() {
	    return sensekiNm;
	}
	/**
	 * 戦績名を設定します。
	 * @param sensekiNm 戦績名
	 */
	public void setSensekiNm(String sensekiNm) {
	    this.sensekiNm = sensekiNm;
	}
	/**
	 * 戦績区分（キー）を取得します。
	 * @return 戦績区分（キー）
	 */
	public String getSensekiKbnKey() {
	    return sensekiKbnKey;
	}
	/**
	 * 戦績区分（キー）を設定します。
	 * @param sensekiKbnKey 戦績区分（キー）
	 */
	public void setSensekiKbnKey(String sensekiKbnKey) {
	    this.sensekiKbnKey = sensekiKbnKey;
	}
	/**
	 * 戦績区分 （Ｍａｐ）を取得します。
	 * @return 戦績区分 （Ｍａｐ）
	 */
	public Map<String,String> getSensekiKbn() {
	    return sensekiKbn;
	}
	/**
	 * 戦績区分 （Ｍａｐ）を設定します。
	 * @param sensekiKbn 戦績区分 （Ｍａｐ）
	 */
	public void setSensekiKbn(Map<String,String> sensekiKbn) {
	    this.sensekiKbn = sensekiKbn;
	}
	/**
	 * 戦績区分名称を取得します。
	 * @return 戦績区分名称
	 */
	public String getSensekiKbnNm() {
	    return sensekiKbnNm;
	}
	/**
	 * 戦績区分名称を設定します。
	 * @param sensekiKbnNm 戦績区分名称
	 */
	public void setSensekiKbnNm(String sensekiKbnNm) {
	    this.sensekiKbnNm = sensekiKbnNm;
	}
	/**
	 * 選手名を取得します。
	 * @return 選手名
	 */
	public String getSenshuNm() {
		return senshuNm;
	}
	/**
	 * 選手名を設定します。
	 * @param senshuNm 選手名
	 */
	public void setSenshuNm(String senshuNm) {
		this.senshuNm = senshuNm;
	}
	
	/**
	 * イニングを取得します。
	 * @return イニング
	 */
	public String getIning() {
		return ining;
	}
	/**
	 * イニングを設定します。
	 * @param ining イニング
	 */
	public void setIning(String ining) {
		this.ining = ining;
	}
	
	/**
	 * 球数を取得します。
	 * @return 球数
	 */
	public String getTamakazu() {
		return tamakazu;
	}
	/**
	 * 球数を設定します。
	 * @param tamakazu 球数
	 */
	public void setTamakazu(String tamakazu) {
		this.tamakazu = tamakazu;
	}
	
	/**
	 * 被安打を取得します。
	 * @return 被安打
	 */
	public String getHianda() {
		return hianda;
	}
	/**
	 * 被安打を設定します。
	 * @param Hianda 被安打
	 */
	public void setHianda(String hianda) {
		this.hianda = hianda;
	}
	
	/**
	 * 与四死球を取得します。
	 * @return 与四死球
	 */
	public String getYoshishikyu() {
		return yoshishikyu;
	}
	/**
	 * 与四死球を設定します。
	 * @param yoshishikyu 与四死球
	 */
	public void setYoshishikyu(String yoshishikyu) {
		this.yoshishikyu = yoshishikyu;
	}
	
	/**
	 * 奪三振を取得します。
	 * @return 奪三振
	 */
	public String getDatsusanshin() {
		return datsusanshin;
	}
	/**
	 * 奪三振を設定します。
	 * @param datsusanshin 奪三振
	 */
	public void setDatsusanshin(String datsusanshin) {
		this.datsusanshin = datsusanshin;
	}
	
	/**
	 * 失点を取得します。
	 * @return 失点
	 */
	public String getSitten() {
		return sitten;
	}
	/**
	 * 失点を設定します。
	 * @param sitten 失点
	 */
	public void setSitten(String sitten) {
		this.sitten = sitten;
	}
	
	/**
	 * 自責点を取得します。
	 * @return 自責点
	 */
	public String getJisekiten() {
		return jisekiten;
	}
	/**
	 * 自責点を設定します。
	 * @param jisekiten 自責点
	 */
	public void setJisekiten(String jisekiten) {
		this.jisekiten = jisekiten;
	}
	
	/**
	 * 対戦相手を取得します。
	 * @return 対戦相手
	 */
	public String getTaisenNm() {
		return taisenNm;
	}
	/**
	 * 対戦相手を設定します。
	 * @param taisenNm 対戦相手
	 */
	public void setTaisenNm(String taisenNm) {
		this.taisenNm = taisenNm;
	}
	
	/**
	 * 試合日を取得します。
	 * @return 試合日
	 */
	public String getShiaibi() {
		return shiaibi;
	}
	/**
	 *試合日を設定します。
	 * @param shiaibi 試合日
	 */
	public void setShiaibi(String shiaibi) {
		this.shiaibi = shiaibi;
	}
	/**
	 * 試合IDを取得します。
	 * @return 試合ID
	 */
	public String getMatchId() {
		return matchId;
	}
	/**
	 * 試合IDを設定します。
	 * @param matchId 試合ID
	 */
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	
	
	
	public Map<String, String> getzokugara() {
		return zokugara;
	}
	public void setzokugara(Map<String, String> zokugara) {
		this.zokugara = zokugara;
	}
	public String getZokugaraKey() {
		return zokugaraKey;
	}
	public void setZokugaraKey(String zokugaraKey) {
		this.zokugaraKey = zokugaraKey;
	}
	public String getZokugaraNm() {
		return zokugaraNm;
	}
	public void setZokugaraNm(String zokugaraNm) {
		this.zokugaraNm = zokugaraNm;
	}
	
}
