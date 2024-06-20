package cashbook.service.senseki;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cashbook.dao.senseki.SensekiDao;
import cashbook.dto.common.LoginDto;
import cashbook.dto.senseki.SensekiListDto;
import cashbook.util.CommonUtil;

/**
 * 個人マスタサービス
 * @author soppra
 */
public class SensekiServiceImpl implements SensekiService {

	/** 個人マスタDao */
	private SensekiDao sensekiDao;

	/**
	 * 一覧画面初期表示メソッド
	 */
	public SensekiListDto listInit(Map<String, Object> formMap) {
		SensekiListDto result = new SensekiListDto();
		return result;
	}

	/**
	 * 一覧画面検索メソッド
	 */
	public SensekiListDto listSearch(Map<String, Object> formMap) {
		
		SensekiListDto result = new SensekiListDto();

		result.setPlayerNm(sensekiDao.getPlayerName(formMap));

		//------------------------------------------
		// 一覧
		//------------------------------------------
		List<SensekiListDto> SensekiList = new ArrayList<SensekiListDto>();
		// 検索処理
		List<Map<String, String>> list = sensekiDao.searchSenseki(formMap);
		Iterator<Map<String, String>> it = list.iterator();
		
		while (it.hasNext()) {
			Map<String, String> map = it.next();
			SensekiListDto dto = new SensekiListDto();
			
			dto.setMatchId(map.get("MATCH_ID"));
			dto.setPlayerId(map.get("PLAYER_ID"));
			dto.setInning(map.get("INNING"));
			dto.setTamakazu(map.get("TAMAKAZU"));
			dto.setHianda((map.get("HIANDA")));
			dto.setYoshikyu((map.get("YOSHIKYU")));
			dto.setDatsusanshin(map.get("DATSUSANSHIN"));
			dto.setSittenNm(map.get("SITTEN"));
			dto.setJisekitenNm(map.get("JISEKITEN"));
			dto.seteTeam(map.get("E_TEAM"));
			dto.setMatchDate(map.get("MATCH_DATE"));
			
			SensekiList.add(dto);
		}


		result.setList(SensekiList);
		return result;
	}

	/**
	 * 一覧画面削除メソッド
	 */
	public void listDelete(Map<String, Object> formMap, LoginDto loginDto) {
		List<String> list = CommonUtil.convFormMapToList(formMap);
		for (String checkDel : list) {
			sensekiDao.deleteSenseki(checkDel, loginDto);
		}
	}

	/**
	 * DAOのsetter
	 * @param sensekiDao
	 */
	public void setSensekiDao(SensekiDao sensekiDao) {
		this.sensekiDao = sensekiDao;
	}



}