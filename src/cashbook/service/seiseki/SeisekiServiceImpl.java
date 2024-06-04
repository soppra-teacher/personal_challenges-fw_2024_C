package cashbook.service.seiseki;

import static cashbook.util.Const.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cashbook.dao.common.CommonDao;
import cashbook.dao.seiseki.SeisekiDao;
import cashbook.dao.setai.SetaiDao;
import cashbook.dto.common.LoginDto;
import cashbook.dto.seiseki.SeisekiListDto;
import cashbook.dto.seiseki.SeisekiRegistDto;
import cashbook.exception.CommonValidateException;
import cashbook.util.CommonUtil;
import cashbook.util.Const;
import cashbook.util.SeisekiConst;

/**
 * 成績マスタサービス
 * @author soppra
 */
public class SeisekiServiceImpl implements SeisekiService {

	/** 世帯マスタDao */
	private SetaiDao setaiDao;

	/** 成績マスタDao */
	private SeisekiDao seisekiDao;

	/** 共通Dao */
	private CommonDao commonDao;

	/**
	 * 一覧画面初期表示メソッド
	 */
	public SeisekiListDto listInit() {
		SeisekiListDto result = new SeisekiListDto();
		// 性別コンボボックスの設定
		result.setSeibetsuKbn(commonDao.getCode(CD_BUNRUI_002));
		// 続柄区分コンボボックスの設定
		result.setzokugara(commonDao.getCode(CD_BUNRUI_003));
		return result;
	}

	/**
	 * 一覧画面検索メソッド
	 */
	public SeisekiListDto listSearch(Map<String, Object> formMap) {
		//------------------------------------------
		// ヘッダ
		//------------------------------------------
		SeisekiListDto result = new SeisekiListDto();
		// 入力項目を保持
		result.setSeisekiNm(CommonUtil.getStr(formMap.get(SeisekiConst.KEY_SEISEKI_NM)));
		result.setSeisekiNmkana(CommonUtil.getStr(formMap.get(SeisekiConst.KEY_SEISEKI_NM_KANA)));
		result.setSeibetsuKbnKey(CommonUtil.getStr(formMap.get(SeisekiConst.KEY_SEIBETSU_KBN_KEY)));
		result.setZokugaraKey(CommonUtil.getStr(formMap.get(SeisekiConst.KEY_ZOKUGARA)));
		result.setSetaiNusiFlg(CommonUtil.getStr(formMap.get(SeisekiConst.KEY_SETAINUSI_FLG)));
		// 性別区分コンボボックスの設定
		result.setSeibetsuKbn(commonDao.getCode(CD_BUNRUI_002));
		// 続柄区分コンボボックスの設定
		result.setzokugara(commonDao.getCode(CD_BUNRUI_003));

		//------------------------------------------
		// 一覧
		//------------------------------------------
		List<SeisekiRegistDto> SeisekiList = new ArrayList<SeisekiRegistDto>();
		// 検索処理
		List<Map<String, String>> list = seisekiDao.searchSeiseki(formMap);
		Iterator<Map<String, String>> it = list.iterator();
		while (it.hasNext()) {
			Map<String, String> map = it.next();
			SeisekiRegistDto dto = new SeisekiRegistDto();
			dto.setSeisekiId(map.get("SEISEKI_ID"));
			dto.setSetaiId(map.get("SETAI_ID"));
			dto.setSeisekiNm(map.get("SEISEKI_NM"));
			dto.setSeisekiNmkana(map.get("SEISEKI_NM_KANA"));
			dto.setSeibetsuNm(commonDao.getCode(CD_BUNRUI_002).get(map.get("SEIBETSU_KBN")));
			dto.setZokugaraNm(commonDao.getCode(CD_BUNRUI_003).get(map.get("ZOKUGARA")));
			dto.setSetaiNusiFlg(map.get("SETAINUSHI_FLG"));
			if (SETAINUSHI_ON.equals(map.get("SETAINUSHI_FLG"))) {
				dto.setSetaiNusiNm(commonDao.getCodeName(CD_BUNRUI_004, CD_004_1));
			}
			SeisekiList.add(dto);
		}
		result.setList(SeisekiList);
		return result;
	}

	/**
	 * 一覧画面削除メソッド
	 */
	public void listDelete(Map<String, Object> formMap, LoginDto loginDto) {
		List<String> list = CommonUtil.convFormMapToList(formMap);
		for (String checkDel : list) {
			seisekiDao.deleteSeiseki(checkDel, loginDto);
		}
	}

	/**
	 * 登録画面初期表示メソッド
	 */
	public SeisekiRegistDto registInit(Map<String, Object> formMap) {

		SeisekiRegistDto result = new SeisekiRegistDto();

		// 続柄区分コンボボックスの設定
		result.setZokugara(commonDao.getCode(CD_BUNRUI_003));
		// 世帯名コンボボックスの設定
		result.setSetaiNm(setaiDao.searchSelectboxSetai());

		// 更新モードの場合は、対象の成績マスタを取得する
		if (formMap != null && !CommonUtil.isNull(CommonUtil.getStr(formMap.get(SeisekiConst.KEY_SEISEKI_ID)))) {
			Map<String, String> map = seisekiDao.findSeiseki(formMap);
			if (map != null) {
				result.setSeisekiId(map.get("SEISEKI_ID"));
				result.setSetaiNmKey(map.get("SETAI_ID"));
				result.setPass(map.get("PASS"));
				result.setSeisekiNm(map.get("SEISEKI_NM"));
				result.setSeisekiNmkana(map.get("SEISEKI_NM_KANA"));
				result.setSeibetsuKbn(map.get("SEIBETSU_KBN"));
				result.setZokugaraKey(map.get("ZOKUGARA"));
				if (SETAINUSHI_ON.equals(map.get("SETAINUSHI_FLG"))) {
					result.setSetaiNusiFlg(SETAINUSHI_FLG_ON);
				}
				result.setRevision(map.get("REVISION"));
			}
		} else {
			result.setSeibetsuKbn(SEIBETSU_KBN_MAN); // 初期値："1"(男)
		}
		return result;
	}

	/**
	 * 登録画面登録・更新メソッド
	 * @throws CommonValidateException
	 */
	public void registInsUpd(Map<String, Object> formMap, LoginDto loginDto) throws Exception {

		// 世帯主フラグ="1" 且つ 世帯主チェック
		if (SETAINUSHI_ON.equals(formMap.get(SeisekiConst.KEY_SETAINUSI_FLG_VALUE))
				&& formMap.get(SeisekiConst.KEY_SETAINUSI_FLG_VALUE) != null &&
				seisekiDao.checkSetainushiFlg(formMap)) {
			throw new CommonValidateException(MSG_KOJIN_CONSIS_1);
		}

		// 性別、続柄の整合性チェック
		if (check2(formMap)) {
			throw new CommonValidateException(MSG_KOJIN_CONSIS_2);
		}

		// 登録の場合
		if (CommonUtil.isNull(CommonUtil.getStr(formMap.get(Const.ITEM_REVISION)))) {
			// 存在チェック
			if (!seisekiDao.checkOverlapSeiseki(formMap)) {
				throw new CommonValidateException(MSG_ERRORS_PRIMARY_KEY);
			}
			// 登録処理
			seisekiDao.registSeiseki(formMap, loginDto);
			// 更新の場合
		} else {
			// 排他処理
			if (!seisekiDao.lockSeiseki(formMap)) {
				throw new CommonValidateException(MSG_ERRORS_DATA_LOCK);
			}
			// 更新処理
			seisekiDao.updateSeiseki(formMap, loginDto);
		}
	}

	/**
	 * 登録画面登録・更新メソッド
	 * @param  formMap 画面入力項目
	 * @return True:NG, False:OK
	 */
	private boolean check2(Map<String, Object> formMap) {
		boolean bRet = false;
		String seibetsuKbn = CommonUtil.getStr(formMap.get(SeisekiConst.KEY_SEIBETSU_KBN));
		String zokugaraKbn = CommonUtil.getStr(formMap.get(SeisekiConst.KEY_ZOKUGARA));

		// 性別・続柄の相関チェック
		// 続柄がブランクの場合は、チェックを行わない
		if (!CommonUtil.isNull(zokugaraKbn)) {
			if (SEIBETSU_KBN_MAN.equals(seibetsuKbn)) {
				if (!(ZOKUGARA_FATHER.equals(zokugaraKbn)
						|| ZOKUGARA_ELDEST_SON.equals(zokugaraKbn)
						|| ZOKUGARA_SECOND_SON.equals(zokugaraKbn)
						|| ZOKUGARA_THIRD_SON.equals(zokugaraKbn))) {
					bRet = true;
				}
			} else if (SEIBETSU_KBN_WOMAN.equals(seibetsuKbn)) {
				if (!(ZOKUGARA_MOTHER.equals(zokugaraKbn)
						|| ZOKUGARA_ELDEST_DAUGHTER.equals(zokugaraKbn)
						|| ZOKUGARA_SECOND_DAUGHTER.equals(zokugaraKbn)
						|| ZOKUGARA_THIRD_DAUGHTER.equals(zokugaraKbn))) {
					bRet = true;
				}
			}
		}

		return bRet;
	}

	/**
	 * DAOのsetter
	 * @param seisekiDao
	 */
	public void setSeisekiDao(SeisekiDao seisekiDao) {
		this.seisekiDao = seisekiDao;
	}

	/**
	 * DAOのsetter
	 * @param setaiDao
	 */
	public void setSetaiDao(SetaiDao setaiDao) {
		this.setaiDao = setaiDao;
	}

	/**
	 * DAOのsetter
	 * @param commonDao
	 */
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

}