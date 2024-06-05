package cashbook.dto.yuza;

import java.util.Map;

import cashbook.dto.common.BaseDto;

public class YuzaRegistDto extends BaseDto {

	/** ユーザーID */
	private String yuzaId;

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

	/** ユーザー名 */
	private String yuzaNm;

	/** ユーザー名カナ */
	private String yuzaNmkana;

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

	public String getYuzaId() {
		return yuzaId;
	}

	public void setYuzaId(String yuzaId) {
		this.yuzaId = yuzaId;
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

}
