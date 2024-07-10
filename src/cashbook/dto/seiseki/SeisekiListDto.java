package cashbook.dto.seiseki;

import java.util.List;

public class SeisekiListDto {

	/** 成績一覧 */
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
