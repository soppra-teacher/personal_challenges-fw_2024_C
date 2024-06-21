package cashbook.service.senseki;

import static cashbook.util.Const.*;

import java.util.Map;

import cashbook.dao.common.CommonDao;
import cashbook.dao.senseki.SensekiDao;
import cashbook.dto.common.LoginDto;
import cashbook.dto.senseki.SensekiRegistDto;
import cashbook.exception.CommonValidateException;

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
	public SensekiRegistDto listInit() {
		SensekiRegistDto result = new SensekiRegistDto();
		// 選手名コンボボックスの設定
		result.setSenshuNm(sensekiDao.searchSelectboxSenshuNm());
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
	public SensekiRegistDto registInit(Map<String, Object> formMap) {

		SensekiRegistDto result = new SensekiRegistDto();

		// 選手名コンボボックスの設定
		result.setSenshuNm(sensekiDao.searchSelectboxSenshuNm());
		//イニング詳細コンボボックス
		result.setIningMini(commonDao.getCode(CD_BUNRUI_006));

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
}

