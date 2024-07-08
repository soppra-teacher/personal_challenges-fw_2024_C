package cashbook.dto.senseki;

import java.util.List;

public class SensekiListDto {
	
	/** 個人戦績マスタ一覧 */
	private List<SensekiListDto> list;

	/** 選手ID*/
	private String playerId;
	/** 失点*/
	private String sittenNm;
	/** 自責点*/
	private String jisekitenNm;
	/** 対戦相手*/
	private String eTeam;
	/** 試合日*/
	private String matchDate;
	/** 奪三振*/
	private String datsusanshin;
	/** 被安打*/
	private String hianda;
	/** 与四死球*/
	private String yoshikyu;
	/** イニング*/
	private String inning;
	/** 球数*/
	private String tamakazu;
	/** 試合ID*/
	private String matchId;
	/** 選手名*/
	private String playerNm;
	
	

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
	    return null;
	}


}
