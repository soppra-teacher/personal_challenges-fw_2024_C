package cashbook.dto.yuza;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.BaseDto;

public class YuzaListDto extends BaseDto {

	/** ユーザーID */
	private String yuzaId;

	/** ユーザー名 */
	private String yuzaNm;

	/** ユーザー名カナ */
	private String yuzaNmkana;

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

	/** ユーザーマスタ一覧 */
	private List<YuzaRegistDto> list;

	public String getYuzaId() {
		return yuzaId;
	}

	public void setYuzaId(String yuzaId) {
		this.yuzaId = yuzaId;
	}

	public String getYuzaNm() {
		return yuzaNm;
	}

	public void setYuzaNm(String yuzaNm) {
		this.yuzaNm = yuzaNm;
	}

	public String getYuzaNmkana() {
		return yuzaNmkana;
	}

	public void setYuzaNmkana(String yuzaNmkana) {
		this.yuzaNmkana = yuzaNmkana;
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

	public List<YuzaRegistDto> getList() {
		return list;
	}
	public void setList(List<YuzaRegistDto> list) {
		this.list = list;
	}


}
