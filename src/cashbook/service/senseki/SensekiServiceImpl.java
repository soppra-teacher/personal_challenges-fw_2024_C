package cashbook.service.senseki;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cashbook.dao.common.CommonDao;
import cashbook.dao.senseki.SensekiDao;
import cashbook.dao.setai.SetaiDao;
import cashbook.dto.common.LoginDto;
import cashbook.dto.senseki.SensekiListDto;
import cashbook.dto.senseki.SensekiRegistDto;
import cashbook.util.CommonUtil;

/**
 * 個人マスタサービス
 * @author soppra
 */
public class SensekiServiceImpl implements SensekiService {

	/** 個人マスタDao */
	private SensekiDao sensekiDao;

	/** 共通Dao */
	//private CommonDao commonDao;
	
	/** 個人マスタDao */
	//private KojinDao kojinDao;

	/**
	 * 一覧画面初期表示メソッド
	 */
	public SensekiListDto listInit(Map<String, Object> formMap) {
		//SensekiListDto result = new SensekiListDto();
		// 性別コンボボックスの設定
	//	result.setSeibetsuKbn(commonDao.getCode(CD_BUNRUI_002));
		// 続柄区分コンボボックスの設定
	//	result.setzokugara(commonDao.getCode(CD_BUNRUI_003));
		
		//result.setSensekiNm(CommonUtil.getStr(formMap.get(SensekiConst.KEY_SENSEKI_NM)));
		

		
		return null;
	}

	/**
	 * 一覧画面検索メソッド
	 */
	public SensekiListDto listSearch(Map<String, Object> formMap) {
		System.out.println("------一覧画面検索メソッド");

		
		SensekiListDto result = new SensekiListDto();

		//result.setSeibetsuKbn(commonDao.getCode(CD_BUNRUI_002));
		// 続柄区分コンボボックスの設定
		//result.setzokugara(commonDao.getCode(CD_BUNRUI_003));
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
		System.out.println("------SensekiServiceImplのlistDeleteメソッド 削除03 ");
		List<String> list = CommonUtil.convFormMapToList(formMap);
		for (String checkDel : list) {
			sensekiDao.deleteSenseki(checkDel, loginDto);
		}
	}

	/**
	 * 登録画面初期表示メソッド
	 */
	public SensekiRegistDto registInit(Map<String, Object> formMap) {

		//SensekiRegistDto result = new SensekiRegistDto();
//
//		// 続柄区分コンボボックスの設定
//		result.setZokugara(commonDao.getCode(CD_BUNRUI_003));
//		// 世帯名コンボボックスの設定
//		result.setSetaiNm(setaiDao.searchSelectboxSetai());
//
//		// 更新モードの場合は、対象の個人マスタを取得する
//		if (formMap != null && !CommonUtil.isNull(CommonUtil.getStr(formMap.get(SensekiConst.KEY_SENSEKI_ID)))) {
//			Map<String, String> map = sensekiDao.findSenseki(formMap);
//			if (map != null) {
//				result.setSensekiId(map.get("SENSEKI_ID"));
//				result.setSetaiNmKey(map.get("SETAI_ID"));
//				result.setPass(map.get("PASS"));
//				result.setSensekiNm(map.get("SENSEKI_NM"));
//				result.setSensekiNmkana(map.get("SENSEKI_NM_KANA"));
//				result.setSeibetsuKbn(map.get("SEIBETSU_KBN"));
//				result.setZokugaraKey(map.get("ZOKUGARA"));
//				if (SETAINUSHI_ON.equals(map.get("SETAINUSHI_FLG"))) {
//					result.setSetaiNusiFlg(SETAINUSHI_FLG_ON);
//				}
//				result.setRevision(map.get("REVISION"));
//			}
//		} else {
//			result.setSeibetsuKbn(SEIBETSU_KBN_MAN); // 初期値："1"(男)
//		}
		return null;
	}

	/**
	 * 登録画面登録・更新メソッド
	 * @throws CommonValidateException
	 */
	//public void registInsUpd(Map<String, Object> formMap, LoginDto loginDto) throws Exception {

//		// 世帯主フラグ="1" 且つ 世帯主チェック
//		if (SETAINUSHI_ON.equals(formMap.get(SensekiConst.KEY_SETAINUSI_FLG_VALUE))
//				&& formMap.get(SensekiConst.KEY_SETAINUSI_FLG_VALUE) != null &&
//				sensekiDao.checkSetainushiFlg(formMap)) {
//			throw new CommonValidateException(MSG_KOJIN_CONSIS_1);
//		}
//
//		// 性別、続柄の整合性チェック
//		if (check2(formMap)) {
//			throw new CommonValidateException(MSG_KOJIN_CONSIS_2);
//		}
//
//		// 登録の場合
//		if (CommonUtil.isNull(CommonUtil.getStr(formMap.get(Const.ITEM_REVISION)))) {
//			// 存在チェック
//			if (!sensekiDao.checkOverlapSenseki(formMap)) {
//				throw new CommonValidateException(MSG_ERRORS_PRIMARY_KEY);
//			}
//			// 登録処理
//			//sensekiDao.registSenseki(formMap, loginDto);
//			// 更新の場合
//		} else {
//			// 排他処理
//			if (!sensekiDao.lockSenseki(formMap)) {
//				throw new CommonValidateException(MSG_ERRORS_DATA_LOCK);
//			}
//			// 更新処理
//			sensekiDao.updateSenseki(formMap, loginDto);
//		}
	//}

	/**
	 * 登録画面登録・更新メソッド
	 * @param  formMap 画面入力項目
	 * @return True:NG, False:OK
	 */
//	private boolean check2(Map<String, Object> formMap) {
//		boolean bRet = false;
//		String seibetsuKbn = CommonUtil.getStr(formMap.get(SensekiConst.KEY_SEIBETSU_KBN));
//		String zokugaraKbn = CommonUtil.getStr(formMap.get(SensekiConst.KEY_ZOKUGARA));
//
//		// 性別・続柄の相関チェック
//		// 続柄がブランクの場合は、チェックを行わない
//		if (!CommonUtil.isNull(zokugaraKbn)) {
//			if (SEIBETSU_KBN_MAN.equals(seibetsuKbn)) {
//				if (!(ZOKUGARA_FATHER.equals(zokugaraKbn)
//						|| ZOKUGARA_ELDEST_SON.equals(zokugaraKbn)
//						|| ZOKUGARA_SECOND_SON.equals(zokugaraKbn)
//						|| ZOKUGARA_THIRD_SON.equals(zokugaraKbn))) {
//					bRet = true;
//				}
//			} else if (SEIBETSU_KBN_WOMAN.equals(seibetsuKbn)) {
//				if (!(ZOKUGARA_MOTHER.equals(zokugaraKbn)
//						|| ZOKUGARA_ELDEST_DAUGHTER.equals(zokugaraKbn)
//						|| ZOKUGARA_SECOND_DAUGHTER.equals(zokugaraKbn)
//						|| ZOKUGARA_THIRD_DAUGHTER.equals(zokugaraKbn))) {
//					bRet = true;
//				}
//			}
//		}
//
//		return bRet;
//	}

	/**
	 * DAOのsetter
	 * @param sensekiDao
	 */
	public void setSensekiDao(SensekiDao sensekiDao) {
		this.sensekiDao = sensekiDao;
	}

	/**
	 * DAOのsetter
	 * @param setaiDao
	 */
	public void setSetaiDao(SetaiDao setaiDao) {
	}

	/**
	 * DAOのsetter
	 * @param commonDao
	 */
	public void setCommonDao(CommonDao commonDao) {
		//this.commonDao = commonDao;
	}



}