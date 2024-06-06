package cashbook.dto.senseki;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.BaseDto;

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
	private List<SensekiRegistDto> list;

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

	public List<SensekiRegistDto> getList() {
		return list;
	}
	public void setList(List<SensekiRegistDto> sensekiList) {
		this.list = sensekiList;
	}
	


}
