package cashbook.service.yuza;

import static cashbook.util.Const.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cashbook.dao.common.CommonDao;
import cashbook.dao.setai.SetaiDao;
import cashbook.dao.yuza.YuzaDao;
import cashbook.dto.common.LoginDto;
import cashbook.dto.yuza.YuzaListDto;
import cashbook.dto.yuza.YuzaRegistDto;
import cashbook.exception.CommonValidateException;
import cashbook.util.CommonUtil;
import cashbook.util.Const;
import cashbook.util.YuzaConst;

/**
 * ユーザーマスタサービス
 * @author soppra
 */
public class YuzaServiceImpl implements YuzaService {

	/** 世帯マスタDao */
	private SetaiDao setaiDao;

	/** ユーザーマスタDao */
	private YuzaDao yuzaDao;

	/** 共通Dao */
	private CommonDao commonDao;

	/**
	 * 一覧画面初期表示メソッド
	 */
	public YuzaListDto listInit() {
		YuzaListDto result = new YuzaListDto();
		// 性別コンボボックスの設定
		result.setSeibetsuKbn(commonDao.getCode(CD_BUNRUI_002));
		// 続柄区分コンボボックスの設定
		result.setzokugara(commonDao.getCode(CD_BUNRUI_003));
		return result;
	}

	/**
	 * 一覧画面検索メソッド
	 */
	public YuzaListDto listSearch(Map<String, Object> formMap) {
		//------------------------------------------
		// ヘッダ
		//------------------------------------------
		YuzaListDto result = new YuzaListDto();
		// 入力項目を保持
		result.setYuzaNm(CommonUtil.getStr(formMap.get(YuzaConst.KEY_YUZA_NM)));
		result.setYuzaNmkana(CommonUtil.getStr(formMap.get(YuzaConst.KEY_YUZA_NM_KANA)));
		result.setSeibetsuKbnKey(CommonUtil.getStr(formMap.get(YuzaConst.KEY_SEIBETSU_KBN_KEY)));
		result.setZokugaraKey(CommonUtil.getStr(formMap.get(YuzaConst.KEY_ZOKUGARA)));
		result.setSetaiNusiFlg(CommonUtil.getStr(formMap.get(YuzaConst.KEY_SETAINUSI_FLG)));
		// 性別区分コンボボックスの設定
		result.setSeibetsuKbn(commonDao.getCode(CD_BUNRUI_002));
		// 続柄区分コンボボックスの設定
		result.setzokugara(commonDao.getCode(CD_BUNRUI_003));

		//------------------------------------------
		// 一覧
		//------------------------------------------
		List<YuzaRegistDto> YuzaList = new ArrayList<YuzaRegistDto>();
		// 検索処理
		List<Map<String, String>> list = yuzaDao.searchYuza(formMap);
		Iterator<Map<String, String>> it = list.iterator();
		while (it.hasNext()) {
			Map<String, String> map = it.next();
			YuzaRegistDto dto = new YuzaRegistDto();
			dto.setYuzaId(map.get("YUZA_ID"));
			dto.setSetaiId(map.get("SETAI_ID"));
			dto.setYuzaNm(map.get("YUZA_NM"));
			dto.setYuzaNmkana(map.get("YUZA_NM_KANA"));
			dto.setSeibetsuNm(commonDao.getCode(CD_BUNRUI_002).get(map.get("SEIBETSU_KBN")));
			dto.setZokugaraNm(commonDao.getCode(CD_BUNRUI_003).get(map.get("ZOKUGARA")));
			dto.setSetaiNusiFlg(map.get("SETAINUSHI_FLG"));
			if (SETAINUSHI_ON.equals(map.get("SETAINUSHI_FLG"))) {
				dto.setSetaiNusiNm(commonDao.getCodeName(CD_BUNRUI_004, CD_004_1));
			}
			YuzaList.add(dto);
		}
		result.setList(YuzaList);
		return result;
	}

	/**
	 * 一覧画面削除メソッド
	 */
	public void listDelete(Map<String, Object> formMap, LoginDto loginDto) {
		List<String> list = CommonUtil.convFormMapToList(formMap);
		for (String checkDel : list) {
			yuzaDao.deleteYuza(checkDel, loginDto);
		}
	}

	/**
	 * 登録画面初期表示メソッド
	 */
	public YuzaRegistDto registInit(Map<String, Object> formMap) {

		YuzaRegistDto result = new YuzaRegistDto();

		// 続柄区分コンボボックスの設定
		result.setZokugara(commonDao.getCode(CD_BUNRUI_003));
		// 世帯名コンボボックスの設定
		result.setSetaiNm(setaiDao.searchSelectboxSetai());

		// 更新モードの場合は、対象のユーザーマスタを取得する
		if (formMap != null && !CommonUtil.isNull(CommonUtil.getStr(formMap.get(YuzaConst.KEY_YUZA_ID)))) {
			Map<String, String> map = yuzaDao.findYuza(formMap);
			if (map != null) {
				result.setYuzaId(map.get("YUZA_ID"));
				result.setSetaiNmKey(map.get("SETAI_ID"));
				result.setPass(map.get("PASS"));
				result.setYuzaNm(map.get("YUZA_NM"));
				result.setYuzaNmkana(map.get("YUZA_NM_KANA"));
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
		if (SETAINUSHI_ON.equals(formMap.get(YuzaConst.KEY_SETAINUSI_FLG_VALUE))
				&& formMap.get(YuzaConst.KEY_SETAINUSI_FLG_VALUE) != null &&
				yuzaDao.checkSetainushiFlg(formMap)) {
			throw new CommonValidateException(MSG_YUZA_CONSIS_1);
		}

		// 性別、続柄の整合性チェック
		if (check2(formMap)) {
			throw new CommonValidateException(MSG_YUZA_CONSIS_2);
		}

		// 登録の場合
		if (CommonUtil.isNull(CommonUtil.getStr(formMap.get(Const.ITEM_REVISION)))) {
			// 存在チェック
			if (!yuzaDao.checkOverlapYuza(formMap)) {
				throw new CommonValidateException(MSG_ERRORS_PRIMARY_KEY);
			}
			// 登録処理
			yuzaDao.registYuza(formMap, loginDto);
			// 更新の場合
		} else {
			// 排他処理
			if (!yuzaDao.lockYuza(formMap)) {
				throw new CommonValidateException(MSG_ERRORS_DATA_LOCK);
			}
			// 更新処理
			yuzaDao.updateYuza(formMap, loginDto);
		}
	}

	/**
	 * 登録画面登録・更新メソッド
	 * @param  formMap 画面入力項目
	 * @return True:NG, False:OK
	 */
	private boolean check2(Map<String, Object> formMap) {
		boolean bRet = false;
		String seibetsuKbn = CommonUtil.getStr(formMap.get(YuzaConst.KEY_SEIBETSU_KBN));
		String zokugaraKbn = CommonUtil.getStr(formMap.get(YuzaConst.KEY_ZOKUGARA));

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
	 * @param yuzaDao
	 */
	public void setYuzaDao(YuzaDao yuzaDao) {
		this.yuzaDao = yuzaDao;
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