package cashbook.service.senseki;

import static cashbook.util.Const.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cashbook.dao.common.CommonDao;
import cashbook.dao.senseki.SensekiDao;
import cashbook.dto.common.LoginDto;
import cashbook.dto.senseki.SensekiListDto;
import cashbook.dto.senseki.SensekiRegistDto;
import cashbook.exception.CommonValidateException;
import cashbook.util.CommonUtil;

/**
 * 個人マスタサービス
 * @author soppra
 */
public class SensekiServiceImpl implements SensekiService {

	/** 個人マスタDao */
	private SensekiDao sensekiDao;
	/** 共通Dao */
	private CommonDao commonDao;

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
	public SensekiListDto listSearch(Map<String, Object> formMap,LoginDto loginDto) {
		
		SensekiListDto result = new SensekiListDto();

		result.setPlayerNm(sensekiDao.getPlayerName(formMap));

		//------------------------------------------
		// 一覧
		//------------------------------------------
		List<SensekiListDto> SensekiList = new ArrayList<SensekiListDto>();
		// 検索処理
		List<Map<String, String>> list = sensekiDao.searchSenseki(formMap,loginDto);
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
	 * <p><b>
	 * 戦績画面
	 * <br>初期表示処理
	 * </b></p>
	 * @return SensekiListDto 戦績DTO
	 */
	public SensekiRegistDto listInit(LoginDto loginDto) {
		SensekiRegistDto result = new SensekiRegistDto();
		// 選手名コンボボックスの設定
		result.setSenshuNm(sensekiDao.searchSelectboxSenshuNm(loginDto));
		//イニング詳細コンボボックス
		result.setIningMini(commonDao.getCode(CD_BUNRUI_006));
		return result;
	}

	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>検索処理
	 * </b></p>
	 * @param  formMap       画面項目
	 * @return SensekiListDto 戦績DTO
	 */
	public SensekiRegistDto registInit(Map<String, Object> formMap,LoginDto loginDto) {

		SensekiRegistDto result = new SensekiRegistDto();

		// 選手名コンボボックスの設定
		result.setSenshuNm(sensekiDao.searchSelectboxSenshuNm(loginDto));
		//イニング詳細コンボボックス
		result.setIningMini(commonDao.getCode(CD_BUNRUI_001));

		return result;
	}

	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>登録・更新処理
	 * </b></p>
	 * @param formMap  画面項目
	 * @param loginDto ログイン情報DTO
	 * @throws CommonValidateException
	 */
	public void registInsUpd(Map<String, Object> formMap, LoginDto loginDto) throws CommonValidateException {
			// 登録処理
			sensekiDao.registSenseki(formMap, loginDto);
	}
	
	/**
	 * DAOのsetter
	 * @param sensekiDao
	 */
	public void setSensekiDao(SensekiDao sensekiDao) {
		this.sensekiDao = sensekiDao;
	}

	/**
	 * DAOのsetter
	 * @param commonDao
	 */
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}
	

}