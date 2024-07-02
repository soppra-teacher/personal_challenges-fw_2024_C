package cashbook.dto.sensekireg;

import java.util.Map;

import cashbook.dto.common.BaseDto;

/**
 * 戦績マスタ登録画面用DTO
 * @author soppra
 */
public class SensekiRegistDto extends BaseDto {
	
	/**試合ID */
	private String matchId;
	/** 選手名（キー） */
	private String senshuNmKey;
	/** 選手名 （Ｍａｐ）*/
	private Map<String, String> senshuNm;
	/** イニング */
	private String ining;
	/** イニング詳細（ＭＡＰ） */
	private Map<String, String> iningMini;
	/** イニング詳細（キー） */
	private String iningMiniKey;
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
	
	/**
	 * 選手名区分（キー）を取得します。
	 * @return 戦績区分（キー）
	 */
	public String getSenshuNmKey() {
	    return senshuNmKey;
	}
	/**
	 * 選手名区分（キー）を設定します。
	 * @param senshuNmKey 戦績区分（キー）
	 */
	public void setSenshuNmKey(String senshuNmKey) {
	    this.senshuNmKey = senshuNmKey;
	}
	
	/**
	 * 選手名区分 （Ｍａｐ）を取得します。
	 * @return 戦績区分 （Ｍａｐ）
	 */
	public Map<String,String> getSenshuNm() {
	    return senshuNm;
	}
	/**
	 * 選手名区分 （Ｍａｐ）を設定します。
	 * @param senshuNm 戦績区分 （Ｍａｐ）
	 */
	public void setSenshuNm(Map<String,String> senshuNm) {
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
	 * イニング詳細 （Ｍａｐ）を取得します。
	 * @return イニング詳細 （Ｍａｐ）
	 */
	public Map<String, String> getIningMini() {
		return iningMini;
	}
	/**
	 * イニング詳細 （Ｍａｐ）を設定します。
	 * @param iningMini イニング詳細 （Ｍａｐ）
	 */
	public void setIningMini(Map<String, String> iningMini) {
		this.iningMini = iningMini;
	}
	
	/**
	 * イニング詳細（キー）を取得します。
	 * @return イニング詳細（キー）
	 */
	public String getIningMiniKey() {
		return iningMiniKey;
	}
	/**
	 * イニング詳細（キー）を設定します。
	 * @param iningMiniKey イニング詳細（キー）
	 */
	public void setIningMiniKey(String iningMiniKey) {
		this.iningMiniKey = iningMiniKey;
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

}