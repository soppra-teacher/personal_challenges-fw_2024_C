package cashbook.dto.senseki;

import java.util.Map;

import cashbook.dto.common.BaseDto;

public class SensekiRegistDto extends BaseDto {

	/** 個人ID */
	private String sensekiId;

	/** パスワード */
	private String pass;

	/** 世帯ID（キー） */
	private String setaiIdKey;

	/** 世帯ID */
	private String setaiId;

	/** 世帯名 （キー） */
	private String setaiNmKey;

	/** 世帯名 （Ｍａｐ）*/
	private Map<String, String> setaiNm;

	/** 個人名 */
	private String sensekiNm;

	/** 個人名カナ */
	private String sensekiNmkana;

	/** 性別区分 */
	private String seibetsuKbn;

	/** 性別名 */
	private String seibetsuNm;

	/** 続柄（キー） */
	private String zokugaraKey;

	/** 続柄（ＭＡＰ） */
	private Map<String, String> zokugara;

	/** 続柄名 */
	private String zokugaraNm;

	/** 世帯主フラグ */
	private String setaiNusiFlg;

	/** 世帯主名 */
	private String setaiNusiNm;
	
	
	private String playerId;
	/** 失点*/
	private String sittenNm;
	/** 自責点*/
	private String jisekitenNm;
	/** 相手*/
	private String eTeam;
	/** 試合日*/
	private String matchDate;
	
	private String hianda;
	private String yoshikyu;
	private String inning;
	private String tamakazu;
	private String matchId;
	
	
	
	public String getSensekiId() {
		return sensekiId;
	}

	public void setSensekiId(String sensekiId) {
		this.sensekiId = sensekiId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSetaiIdKey() {
		return setaiIdKey;
	}

	public void setSetaiIdKey(String setaiIdKey) {
		this.setaiIdKey = setaiIdKey;
	}

	public String getSetaiId() {
		return setaiId;
	}

	public void setSetaiId(String setaiId) {
		this.setaiId = setaiId;
	}

	public String getSetaiNmKey() {
	    return setaiNmKey;
	}

	public void setSetaiNmKey(String setaiNmKey) {
	    this.setaiNmKey = setaiNmKey;
	}

	public Map<String, String> getSetaiNm() {
	    return setaiNm;
	}

	public void setSetaiNm(Map<String, String> setaiNm) {
	    this.setaiNm = setaiNm;
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

	public String getSeibetsuKbn() {
		return seibetsuKbn;
	}

	public void setSeibetsuKbn(String seibetsuKbn) {
		this.seibetsuKbn = seibetsuKbn;
	}

	public String getSeibetsuNm() {
		return seibetsuNm;
	}

	public void setSeibetsuNm(String seibetsuNm) {
		this.seibetsuNm = seibetsuNm;
	}

	public Map<String, String> getZokugara() {
		return zokugara;
	}

	public void setZokugara(Map<String, String> zokugara) {
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

	public String getSetaiNusiFlg() {
		return setaiNusiFlg;
	}

	public void setSetaiNusiFlg(String setaiNusiFlg) {
		this.setaiNusiFlg = setaiNusiFlg;
	}

	public String getSetaiNusiNm() {
		return setaiNusiNm;
	}

	public void setSetaiNusiNm(String setaiNusiNm) {
		this.setaiNusiNm = setaiNusiNm;
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

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
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

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}







}
