package cashbook.dto.senseki;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.BaseDto;
import cashbook.util.CommonUtil;

public class SensekiListDto extends BaseDto {

	/** 個人ID */
	private String sensekiId;

	/** 個人名 */
	private String sensekiNm;

	/** 個人名カナ */
	private String sensekiNmkana;

	/** 性別区分（キー） */
	private String seibetsuKbnKey;

	/** 性別区分（ＭＡＰ） */
	private Map<String, String> seibetsuKbn;

	/** 続柄（キー） */
	private String zokugaraKey;

	/** 続柄（ＭＡＰ） */
	private Map<String, String> zokugara;

	/** 世帯主フラグ */
	private String setaiNusiFlg;

	/** 個人マスタ一覧 */
	private List<SensekiRegistDto> list01;
	
	private List<SensekiListDto> list;

	
	private String playerId;
	/** 失点*/
	private String sittenNm;
	/** 自責点*/
	private String jisekitenNm;
	/** 相手*/
	private String eTeam;
	/** 試合日*/
	private String matchDate;
	private String datsusanshin;
	private String hianda;
	private String yoshikyu;
	private String inning;
	private String tamakazu;
	private String matchId;
	
	private String playerNm;
	
	

	public String getSensekiId() {
		return sensekiId;
	}

	public void setSensekiId(String sensekiId) {
		this.sensekiId = sensekiId;
	}

	public String getSensekiNm() {
		return sensekiNm;
	}

	public void setSensekiNm(String sensekiNm) {
		this.sensekiNm = sensekiNm;
	}

	public String getSensekiNmkana() {
		return sensekiNmkana;
	}

	public void setSensekiNmkana(String sensekiNmkana) {
		this.sensekiNmkana = sensekiNmkana;
	}

	public String getSeibetsuKbnKey() {
		return seibetsuKbnKey;
	}

	public void setSeibetsuKbnKey(String seibetsuKbnKey) {
		this.seibetsuKbnKey = seibetsuKbnKey;
	}

	public Map<String, String> getSeibetsuKbn() {
		return seibetsuKbn;
	}

	public void setSeibetsuKbn(Map<String, String> seibetsuKbn) {
		this.seibetsuKbn = seibetsuKbn;
	}

	public String getZokugaraKey() {
		return zokugaraKey;
	}

	public void setZokugaraKey(String zokugaraKey) {
		this.zokugaraKey = zokugaraKey;
	}


	public Map<String, String> getzokugara() {
		return zokugara;
	}
	public void setzokugara(Map<String, String> zokugara) {
		this.zokugara = zokugara;
	}

	public String getSetaiNusiFlg() {
		return setaiNusiFlg;
	}

	public void setSetaiNusiFlg(String setaiNusiFlg) {
		this.setaiNusiFlg = setaiNusiFlg;
	}

	public List<SensekiRegistDto> getList01() {
		return list01;
	}
	public void setList01(List<SensekiRegistDto> sensekiList01) {
		this.list01 = sensekiList01;
	}

	public String getSittenNm() {
		return sittenNm;
	}

	public void setSittenNm(String sittenNm) {
		this.sittenNm = sittenNm;
	}

	public String getJisekitenNm() {
		return jisekitenNm;
	}

	public void setJisekitenNm(String jisekitenNm) {
		this.jisekitenNm = jisekitenNm;
	}

	public String geteTeam() {
		return eTeam;
	}

	public void seteTeam(String eTeam) {
		this.eTeam = eTeam;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}



	public String getHianda() {
		return hianda;
	}

	public void setHianda(String hianda) {
		this.hianda = hianda;
	}

	public String getYoshikyu() {
		return yoshikyu;
	}

	public void setYoshikyu(String yoshikyu) {
		this.yoshikyu = yoshikyu;
	}

	public String getInning() {
		return inning;
	}

	public void setInning(String inning) {
		this.inning = inning;
	}

	public String getTamakazu() {
		return tamakazu;
	}

	public void setTamakazu(String tamakazu) {
		this.tamakazu = tamakazu;
	}

	public List<SensekiListDto> getList() {
		return list;
	}

	public void setList(List<SensekiListDto> list) {
		this.list = list;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getDatsusanshin() {
		return datsusanshin;
	}

	public void setDatsusanshin(String datsusanshin) {
		this.datsusanshin = datsusanshin;
	}

	
	
	
	public String getPlayerNm() {
		return playerNm;
	}

	public void setPlayerNm(String playerNm) {
		this.playerNm = playerNm;
	}
	
	public String getPlayerNmFormat() {
	    return CommonUtil.formatComma(playerNm);
	}












}
