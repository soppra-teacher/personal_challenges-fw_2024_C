package cashbook.dto.seiseki;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.BaseDto;

public class SeisekiListDto extends BaseDto {

	/** 成績ID */
	private String seisekiId;

	/** 成績名 */
	private String seisekiNm;

	/** 成績名カナ */
	private String seisekiNmkana;

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

	/** 成績マスタ一覧 */
	private List<SeisekiListDto> list;
	
	
	
	
	
	/** 新規選手登録 */
	private String newSenshuNm;
	
	
	/** 選手ID */
	private String senshuId;
	
	/** 選手名 */
	private String senshuNm;
	
	/** 総イニング */
	private String souInning;
	
	/** 総失点 */
	private String souShitten;
	
	/** 総自責点 */
	private String souJisekiten;
	
	/** 防御率 */
	private String bougyoRitsu;
	
	
	
	
	
	
	

	
	

	public String getSeisekiId() {
		return seisekiId;
	}

	public void setSeisekiId(String seisekiId) {
		this.seisekiId = seisekiId;
	}

	public String getSeisekiNm() {
		return seisekiNm;
	}

	public void setSeisekiNm(String seisekiNm) {
		this.seisekiNm = seisekiNm;
	}

	public String getSeisekiNmkana() {
		return seisekiNmkana;
	}

	public void setSeisekiNmkana(String seisekiNmkana) {
		this.seisekiNmkana = seisekiNmkana;
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

	public List<SeisekiListDto> getList() {
		return list;
	}
	public void setList(List<SeisekiListDto> list) {
		this.list = list;
	}
	
	
	
	
	
	
	public String getSenshuId() {
		return senshuId;
	}

	public void setSenshuId(String senshuId) {
		this.senshuId = senshuId;
	}
	
	public String getnewSenshuNm() {
		return newSenshuNm;
	}

	public void setnewSenshuNm(String newSenshuNm) {
		this.newSenshuNm = newSenshuNm;
	}
	
	public String getSenshuNm() {
		return senshuNm;
	}

	public void setSenshuNm(String senshuNm) {
		this.senshuNm = senshuNm;
	}
	
	public String getSouInning() {
		return souInning;
	}

	public void setSouInning(String souInning) {
		this.souInning = souInning;
	}
	
	public String getSouShitten() {
		return souShitten;
	}

	public void setSouShitten(String souShitten) {
		this.souShitten = souShitten;
	}
	
	public String getSouJisekiten() {
		return souJisekiten;
	}

	public void setSouJisekiten(String souJisekiten) {
		this.souJisekiten = souJisekiten;
	}
	
	public String getBougyoRitsu() {
		return bougyoRitsu;
	}

	public void setBougyoRitsu(String bougyoRitsu) {
		this.bougyoRitsu = bougyoRitsu;
	}


}
