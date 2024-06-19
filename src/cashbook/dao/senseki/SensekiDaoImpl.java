package cashbook.dao.senseki;

import static cashbook.util.Const.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.CannotAcquireLockException;

import cashbook.dao.common.BaseDaoImpl;
import cashbook.dto.common.LoginDto;
import cashbook.util.CommonUtil;
import cashbook.util.SeisekiConst;
import cashbook.util.SensekiConst;
import cashbook.util.SetaiConst;

/**
 * 個人DAOクラス
 * @author soppra
 */
public class SensekiDaoImpl extends BaseDaoImpl implements SensekiDao {

	/**
	 * 個人マスタ一覧を検索する
	 * @return 個人マスタ一覧
	 */
	public List<Map<String, String>> searchSenseki(Map<String, Object> formMap) {

		List<Map<String, String>> result;
		StringBuffer sql = new StringBuffer();


		sql.append("SELECT  M1.MATCH_ID");
		sql.append("       ,M1.PLAYER_ID");
		sql.append("       ,TRUNC((M1.INNING/3),0)||'.'||MOD((M1.INNING),3) AS INNING");
		sql.append("       ,M1.TAMAKAZU");
		sql.append("       ,M1.HIANDA");
		sql.append("       ,M1.YOSHIKYU");
		sql.append("       ,M1.DATSUSANSHIN");
		sql.append("       ,M1.SITTEN");
		sql.append("       ,M1.JISEKITEN");
		sql.append("       ,M1.E_TEAM");
		sql.append("       ,TO_CHAR(M1.MATCH_DATE,'yyyy/mm/dd') AS MATCH_DATE  ");
		sql.append("       ,M1.INS_USER");
		//sql.append("       ,M1.INS_DATE");
		sql.append("  FROM SENSEKI_TBL M1");
		//sql.append(" WHERE M1.DEL_FLG = '0' ");
		// 個人名
		if (!CommonUtil.isNull(CommonUtil.getStr(formMap.get(SeisekiConst.KEY_SENSHU_ID)))) {
			sql.append(" WHERE M1.PLAYER_ID = '").append(formMap.get(SeisekiConst.KEY_SENSHU_ID)).append("' ");
		}
//		// 個人名ｶﾅ
//		if (!CommonUtil.isNull(CommonUtil.getStr(formMap.get(SensekiConst.KEY_SENSEKI_NM_KANA)))) {
//			sql.append(" AND M1.SITTEN '%").append(formMap.get(SensekiConst.KEY_SENSEKI_NM_KANA)).append("%' ");
//		}
//		// 性別
//		if (!CommonUtil.isNull(CommonUtil.getStr(formMap.get(SensekiConst.KEY_SEIBETSU_KBN_KEY)))) {
//			sql.append(" AND M1.E_TEAM = '").append(formMap.get(SensekiConst.KEY_SEIBETSU_KBN_KEY)).append("' ");
//		}
//		// 続柄
//		if (!CommonUtil.isNull(CommonUtil.getStr(formMap.get(SensekiConst.KEY_ZOKUGARA)))) {
//			sql.append(" AND M1.E_TEAM = '").append(formMap.get(SensekiConst.KEY_ZOKUGARA)).append("' ");
//		}
//		// 世帯主フラグ
//		if (!CommonUtil.isNull(CommonUtil.getStr(formMap.get(SensekiConst.KEY_SETAINUSI_FLG_VALUE)))) {
//			if (SETAINUSHI_ON.equals(formMap.get(SensekiConst.KEY_SETAINUSI_FLG_VALUE))) {
//				sql.append(" AND M1.MATCH_ID = '").append(formMap.get(SensekiConst.KEY_SETAINUSI_FLG_VALUE))
//						.append("' ");
//			}
//		}
//		//sql.append(" ORDER BY M1.MATCH_ID");
		result = super.search(sql.toString());

		return result;
	}
	
	public Map<String, String> getP_Nm(String p_Nm) {

		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		Map<String, String> result = new LinkedHashMap<String, String>();
		StringBuffer sql = new StringBuffer();


		sql.append("SELECT  M1.MATCH_ID");
		sql.append("       ,M1.PLAYER_ID");
		sql.append("       ,TRUNC((M1.INNING/3),0)||'.'||MOD((M1.INNING),3) AS INNING");
		sql.append("       ,M1.TAMAKAZU");
		sql.append("       ,M1.HIANDA");
		sql.append("       ,M1.YOSHIKYU");
		sql.append("       ,M1.DATSUSANSHIN");
		sql.append("       ,M1.SITTEN");
		sql.append("       ,M1.JISEKITEN");
		sql.append("       ,M1.E_TEAM");
		sql.append("       ,TO_CHAR(M1.MATCH_DATE,'yyyy/mm/dd') AS MATCH_DATE  ");
		sql.append("       ,M1.INS_USER");
		
		sql.append("  FROM SENSEKI_TBL M1");
		

		//result = super.search(sql.toString());

		return result;
		
		
	}
	

	/**
	 * 個人マスタを削除する
	 */
//	public void deleteSenseki(String sensekiId, LoginDto loginDto) {
//
//		StringBuffer sql = new StringBuffer();
//		sql.append("UPDATE MST_SENSEKI M1 ");
//		sql.append("   SET M1.DEL_FLG = '1' ");
//		sql.append("     , M1.UPD_USER = '").append(loginDto.getKojinId()).append("' ");
//		sql.append("     , M1.UPD_DATE = SYSDATE ");
//		sql.append("     , M1.REVISION = M1.REVISION + 1 ");
//		sql.append(" WHERE M1.SENSEKI_ID = '").append(sensekiId).append("' ");
//
//		super.update(sql.toString());
//	}
	
	/**
	 * 個人戦績を削除する
	 */
	public void deleteSenseki(String matchId, LoginDto loginDto) {
		System.out.println("------SensekiDaoImplのdeleteSenseki 削除04------");
		System.out.println("削除04 matchId:"+matchId);
		System.out.println("削除04 LoginDto:"+loginDto);
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM SENSEKI_TBL M1 ");
		sql.append(" WHERE M1.MATCH_ID = '").append(matchId).append("' ");

		super.update(sql.toString());

	}

	/**
	 * 個人マスタを検索する
	 * @return 個人マスタ
	 */
	public Map<String, String> findSenseki(Map<String, Object> formMap) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT M1.SENSEKI_ID ");
		sql.append("     , M1.SETAI_ID ");
		sql.append("     , M1.PASS ");
		sql.append("     , M1.SENSEKI_NM ");
		sql.append("     , M1.SENSEKI_NM_KANA ");
		sql.append("     , M1.SEIBETSU_KBN ");
		sql.append("     , M1.ZOKUGARA ");
		sql.append("     , M1.SETAINUSHI_FLG ");
		sql.append("     , M1.REVISION ");
		sql.append("  FROM MST_SENSEKI M1 ");
		sql.append(" WHERE M1.DEL_FLG  = '0' ");
		sql.append("   AND M1.SENSEKI_ID = '").append(formMap.get(SensekiConst.KEY_SENSEKI_ID)).append("' ");

		return super.find(sql.toString());
	}

	/**
	 * 個人マスタを登録する
	 * @throws Exception
	 */
	public void registSenseki(Map<String, Object> formMap, LoginDto loginDto) {

		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO MST_SENSEKI M1 ( ");
		sql.append("     M1.SENSEKI_ID ");
		sql.append("   , M1.SETAI_ID ");
		sql.append("   , M1.PASS ");
		sql.append("   , M1.SENSEKI_NM ");
		sql.append("   , M1.SENSEKI_NM_KANA ");
		sql.append("   , M1.SEIBETSU_KBN ");
		sql.append("   , M1.ZOKUGARA ");
		sql.append("   , M1.SETAINUSHI_FLG ");
		sql.append("   , M1.DEL_FLG ");
		sql.append("   , M1.INS_USER ");
		sql.append("   , M1.INS_DATE ");
		sql.append("   , M1.UPD_USER ");
		sql.append("   , M1.UPD_DATE ");
		sql.append("   , M1.REVISION ");
		sql.append(" ) VALUES ( ");
		sql.append("     '").append(formMap.get(SensekiConst.KEY_SENSEKI_ID)).append("' ");
		sql.append("   , '").append(formMap.get(SetaiConst.KEY_SETAI_ID)).append("' ");
		sql.append("   , '").append(formMap.get(SensekiConst.KEY_PASS)).append("' ");
		sql.append("   , '").append(formMap.get(SensekiConst.KEY_SENSEKI_NM)).append("' ");
		sql.append("   , '").append(formMap.get(SensekiConst.KEY_SENSEKI_NM_KANA)).append("' ");
		sql.append("   , '").append(formMap.get(SensekiConst.KEY_SEIBETSU_KBN)).append("' ");
		sql.append("   , '").append(formMap.get(SensekiConst.KEY_ZOKUGARA)).append("' ");
		sql.append("   , '").append(formMap.get(SensekiConst.KEY_SETAINUSI_FLG_VALUE)).append("' ");
		sql.append("   , '0' ");
		sql.append("   , '").append(loginDto.getKojinId()).append("' ");
		sql.append("   , SYSDATE ");
		sql.append("   , '").append(loginDto.getKojinId()).append("' ");
		sql.append("   , SYSDATE ");
		sql.append("   , 0 ");
		sql.append(" ) ");

		super.update(sql.toString());
	}

	/**
	 * 個人マスタを更新する
	 */
	public void updateSenseki(Map<String, Object> formMap, LoginDto loginDto) {

		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE MST_SENSEKI M1 ");
		sql.append("   SET M1.SETAI_ID = '").append(formMap.get(SetaiConst.KEY_SETAI_ID)).append("' ");
		sql.append("     , M1.PASS = '").append(formMap.get(SensekiConst.KEY_PASS)).append("' ");
		sql.append("     , M1.SENSEKI_NM = '").append(formMap.get(SensekiConst.KEY_SENSEKI_NM)).append("' ");
		sql.append("     , M1.SENSEKI_NM_KANA = '").append(formMap.get(SensekiConst.KEY_SENSEKI_NM_KANA)).append("' ");
		sql.append("     , M1.SEIBETSU_KBN = '").append(formMap.get(SensekiConst.KEY_SEIBETSU_KBN)).append("' ");
		sql.append("     , M1.ZOKUGARA = '").append(formMap.get(SensekiConst.KEY_ZOKUGARA)).append("' ");
		sql.append("     , M1.SETAINUSHI_FLG = '").append(formMap.get(SensekiConst.KEY_SETAINUSI_FLG_VALUE)).append("' ");
		sql.append("     , M1.UPD_USER = '").append(loginDto.getKojinId()).append("' ");
		sql.append("     , M1.UPD_DATE = SYSDATE ");
		sql.append("     , M1.REVISION = M1.REVISION + 1 ");
		sql.append(" WHERE M1.SENSEKI_ID = '").append(formMap.get(SensekiConst.KEY_SENSEKI_ID)).append("' ");

		super.update(sql.toString());
	}

	/**
	 * 重複チェック
	 * @return true：正常、false：重複エラー
	 */
	public boolean checkOverlapSenseki(Map<String, Object> formMap) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT M1.SENSEKI_ID ");
		sql.append("  FROM MST_SENSEKI M1 ");
		sql.append(" WHERE M1.SENSEKI_ID = '").append(formMap.get(SensekiConst.KEY_SENSEKI_ID)).append("' ");
		sql.append("   AND ROWNUM = 1 ");

		return super.find(sql.toString()).size() == 0;
	}

	/**
	 * 行ロック及び、排他チェック
	 * @return true：正常、false：排他エラー
	 */
	public boolean lockSenseki(Map<String, Object> formMap) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT M1.SENSEKI_ID ");
		sql.append("  FROM MST_SENSEKI M1 ");
		sql.append(" WHERE M1.SENSEKI_ID = '").append(formMap.get(SensekiConst.KEY_SENSEKI_ID)).append("' ");
		sql.append("   AND M1.REVISION = '").append(formMap.get(ITEM_REVISION)).append("' ");
		sql.append("   FOR UPDATE NOWAIT ");
		try {

			return super.find(sql.toString()).size() != 0;

		} catch (CannotAcquireLockException e) {
			// 対象データがロックされている場合はエラー
			return false;
		}
	}

	/**
	 * 世帯主フラグ確認
	 * @return false：正常、true：整合性エラー
	 */
	public boolean checkSetainushiFlg(Map<String, Object> formMap) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT A.SENSEKI_ID ");
		sql.append("  FROM MST_SENSEKI A ");
		sql.append(" WHERE A.SETAI_ID = '").append(formMap.get(SetaiConst.KEY_SETAI_ID)).append("' ");
		sql.append("   AND A.SETAINUSHI_FLG = '1' ");
		sql.append("   AND A.SENSEKI_ID != '").append(formMap.get(SensekiConst.KEY_SENSEKI_ID)).append("' ");

		return super.find(sql.toString()).size() != 0;
	}
}
