package cashbook.service.sensekireg;

import static cashbook.util.Const.*;

import java.util.Map;

import cashbook.dao.common.CommonDao;
import cashbook.dao.sensekireg.SensekiRegDao;
import cashbook.dto.common.LoginDto;
import cashbook.dto.senseki.SensekiRegistDto;
import cashbook.exception.CommonValidateException;

/**
 * 戦績登録
 * @author soppra
 */
public class SensekiRegServiceImpl implements SensekiRegService {

	/** 戦績登録Dao */
	private SensekiRegDao sensekiRegDao;
	/** 共通Dao */
	private CommonDao commonDao;

	/**
	 * 戦績Daoを設定します。
	 * @param sensekiRegDao
	 */
	public void setSensekiRegDao(SensekiRegDao sensekiRegDao) {
		this.sensekiRegDao = sensekiRegDao;
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
	 * @param loginDto ログイン情報DTO
	 * @return SensekiRegistDto 戦績登録DTO
	 */
	public SensekiRegistDto listInit(LoginDto loginDto) {

		SensekiRegistDto result = new SensekiRegistDto();
		// 選手名コンボボックスの設定
		result.setSenshuNm(sensekiRegDao.searchSelectboxSenshuNm(loginDto));
		//イニング詳細コンボボックス
		result.setIningMini(commonDao.getCode(CD_BUNRUI_001));
		return result;
	}

	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>検索処理
	 * </b></p>
	 * @param formMap  画面項目
	 * @param loginDto ログイン情報DTO
	 * @return SensekiRegistDto 
	 */
	public SensekiRegistDto registInit(Map<String, Object> formMap,LoginDto loginDto) {

		SensekiRegistDto result = new SensekiRegistDto();

		// 選手名コンボボックスの設定
		result.setSenshuNm(sensekiRegDao.searchSelectboxSenshuNm(loginDto));
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
		sensekiRegDao.registSenseki(formMap, loginDto);

		}
}
