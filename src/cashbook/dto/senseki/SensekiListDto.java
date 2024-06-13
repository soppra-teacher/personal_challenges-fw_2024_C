package cashbook.dto.senseki;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.BaseDto;

/**
 * 費目マスタメンテ画面用DTO
 * @author soppra
 */
public class SensekiListDto extends BaseDto {

	/** 費目名 */
	private String sensekiNm;
	/** 費目区分（キー） */
	private String sensekiKbnKey;
	/** 費目区分（Ｍａｐ） */
	private Map<String, String> sensekiKbn;
	/** 費目マスタ一覧 */
	private List<SensekiRegistDto> list;
	/** 続柄（ＭＡＰ） */
	private Map<String, String> zokugara;

	/**
	 * 費目名を取得します。
	 * @return 費目名
	 */
	public String getSensekiNm() {
	    return sensekiNm;
	}
	/**
	 * 費目名を設定します。
	 * @param sensekiNm 費目名
	 */
	public void setSensekiNm(String sensekiNm) {
	    this.sensekiNm = sensekiNm;
	}
	/**
	 * 費目区分（キー）を取得します。
	 * @return 費目区分（キー）
	 */
	public String getSensekiKbnKey() {
	    return sensekiKbnKey;
	}
	/**
	 * 費目区分（キー）を設定します。
	 * @param sensekiKbnKey 費目区分（キー）
	 */
	public void setSensekiKbnKey(String sensekiKbnKey) {
	    this.sensekiKbnKey = sensekiKbnKey;
	}
	/**
	 * 費目区分（Ｍａｐ）を取得します。
	 * @return 費目区分（Ｍａｐ）
	 */
	public Map<String,String> getSensekiKbn() {
	    return sensekiKbn;
	}
	/**
	 * 費目区分（Ｍａｐ）を設定します。
	 * @param sensekiKbn 費目区分（Ｍａｐ）
	 */
	public void setSensekiKbn(Map<String,String> sensekiKbn) {
	    this.sensekiKbn = sensekiKbn;
	}
	/**
	 * 費目マスタ一覧を取得します。
	 * @return 費目マスタ一覧
	 */
	public List<SensekiRegistDto> getList() {
	    return list;
	}
	/**
	 * 費目マスタ一覧を設定します。
	 * @param list 費目マスタ一覧
	 */
	public void setList(List<SensekiRegistDto> list) {
	    this.list = list;
	}
	
	public Map<String, String> getZokugara() {
		return zokugara;
	}
	public void setZokugara(Map<String, String> zokugara) {
		this.zokugara = zokugara;
	}
	
}
