package cashbook.dto.seiseki;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.BaseDto;
import cashbook.dto.seiseki.SeisekiRegistDto;

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
	private List<SeisekiRegistDto> list;

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

	public List<SeisekiRegistDto> getList() {
		return list;
	}
	public void setList(List<SeisekiRegistDto> list) {
		this.list = list;
	}


}
