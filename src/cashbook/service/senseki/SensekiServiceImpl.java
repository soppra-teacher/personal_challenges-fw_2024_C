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
import cashbook.util.Const;
import cashbook.util.SensekiConst;

/**
 * 戦績サービス
 * @author soppra
 */
public class SensekiServiceImpl implements SensekiService {

	/** 戦績Dao */
	private SensekiDao sensekiDao;
	/** 共通Dao */
	private CommonDao commonDao;

	/**
	 * 戦績Daoを設定します。
	 * @param sensekiDao 戦績Dao
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

	/**
	 * <p><b>
	 * 戦績画面
	 * <br>初期表示処理
	 * </b></p>
	 * @return SensekiListDto 戦績DTO
	 */
	public SensekiListDto listInit() {
		SensekiListDto result = new SensekiListDto();
		// 戦績区分コンボボックスの設定
		result.setSensekiKbn(commonDao.getCode(CD_BUNRUI_001));
		// イニング詳細コンボボックスの設定
		result.setZokugara(commonDao.getCode(CD_BUNRUI_006));
		return result;
	}

	/**
	 * <p><b>
	 * 戦績画面
	 * <br>検索処理
	 * </b></p>
	 * @param  formMap       画面項目
	 * @return SensekiListDto 戦績DTO
	 */
	public SensekiListDto listSearch(Map<String, Object> formMap) {

		//------------------------------------------
		// ヘッダ
		//------------------------------------------
		SensekiListDto result = new SensekiListDto();

		// 入力項目を保持
		result.setSensekiNm(CommonUtil.getStr(formMap.get(SensekiConst.KEY_SENSEKI_NM)));
		result.setSensekiKbnKey(CommonUtil.getStr(formMap.get(SensekiConst.KEY_SENSEKI_KBN_KEY)));
		// 戦績区分コンボボックスの設定
		result.setSensekiKbn(commonDao.getCode(CD_BUNRUI_001));
		// イニング詳細コンボボックスの設定
				result.setZokugara(commonDao.getCode(CD_BUNRUI_006));

		//------------------------------------------
		// 一覧
		//------------------------------------------
		List<SensekiRegistDto> sensekiList = new ArrayList<SensekiRegistDto>();

		// 検索処理
		List<Map<String, String>> list = sensekiDao.searchSensekiList(formMap);
		Iterator<Map<String, String>> it = list.iterator();

		while (it.hasNext()) {
			Map<String, String> map = it.next();
			SensekiRegistDto dto = new SensekiRegistDto();
			dto.setSensekiCd(map.get("SENSEKI_CD"));
			dto.setSensekiNm(map.get("SENSEKI_NM"));
			dto.setSensekiKbnNm(commonDao.getCode(CD_BUNRUI_001).get(map.get("SENSEKI_KBN")));
			sensekiList.add(dto);
		}
		result.setList(sensekiList);

		return result;
	}

	/**
	 * <p><b>
	 * 戦績画面
	 * <br>削除処理
	 * </b></p>
	 * @param formMap  画面項目
	 * @param loginDto ログイン情報DTO
	 */
	public void listDelete(Map<String, Object> formMap, LoginDto loginDto) {

		List<String> list = CommonUtil.convFormMapToList(formMap);
		for (String checkDel : list) {
			sensekiDao.deleteSenseki(checkDel, loginDto);
		}
	}

	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>検索処理
	 * </b></p>
	 * @param  formMap       画面項目
	 * @return SensekiListDto 戦績DTO
	 */
	public SensekiRegistDto registInit(Map<String, Object> formMap) {

		SensekiRegistDto result = new SensekiRegistDto();
		// 戦績区分コンボボックスの設定
		//result.setSensekiKbn(commonDao.getCode(CD_BUNRUI_001));
		
		//result.setSensekiKbn(commonDao.getCode(CD_BUNRUI_001));
		
		// 世帯名コンボボックスの設定
		result.setSensekiKbn(sensekiDao.searchSelectboxSenshuNm());
		
		result.setzokugara(commonDao.getCode(CD_BUNRUI_006));
		
		

		// 更新モードの場合は、対象の戦績を取得する
		if (formMap != null && !CommonUtil.isNull(CommonUtil.getStr(formMap.get(SensekiConst.KEY_SENSEKI_CD)))) {
			Map<String, String> map = sensekiDao.findSenseki(formMap);
			if (map != null) {
				result.setSensekiCd(map.get("SENSEKI_CD"));
				result.setSensekiNm(map.get("SENSEKI_NM"));
				result.setSensekiKbnKey(map.get("SENSEKI_KBN"));
				result.setRevision(map.get("REVISION"));
			}
		}

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
System.out.println("----------サービスImpl.registInsUpd---------------");
		if (CommonUtil.isNull(CommonUtil.getStr(formMap.get(Const.ITEM_REVISION)))) {
			// 登録の場合
			// 存在チェック
//			if (!sensekiDao.checkOverlapSenseki(formMap)) {
//				// キー重複エラー
//				throw new CommonValidateException(Const.MSG_ERRORS_PRIMARY_KEY);
//			}
			// 登録処理
			sensekiDao.registSenseki(formMap, loginDto);

		} else {
			// 更新の場合
			// 排他処理
			if (!sensekiDao.lockSenseki(formMap)) {
				// 排他エラー
				throw new CommonValidateException(Const.MSG_ERRORS_DATA_LOCK);
			}
			// 更新処理
			sensekiDao.updateSenseki(formMap, loginDto);

		}
	}
}