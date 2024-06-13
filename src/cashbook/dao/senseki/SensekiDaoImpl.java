package cashbook.dao.senseki;

import static cashbook.util.Const.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.CannotAcquireLockException;

import cashbook.dao.common.BaseDaoImpl;
import cashbook.dto.common.LoginDto;
import cashbook.util.CommonUtil;
import cashbook.util.SensekiConst;

/**
 * 戦績DAOクラス
 * @author soppra
 */
public class SensekiDaoImpl extends BaseDaoImpl implements SensekiDao {

	/**
	 * <p><b>
	 * 戦績画面
	 * <br>検索処理
	 * </b></p>
	 * @param フォーム項目
	 * @return List<Map<String, String>> 検索結果
	 */
	public List<Map<String, String>> searchSensekiList(Map<String, Object> formMap) {

		// フォーム項目の入力値でSQLを組み立てる。
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT M1.senseki_cd ");
		sql.append("      ,M1.senseki_nm ");
		sql.append("      ,M1.senseki_kbn ");
		sql.append("      ,M1.del_flg ");
		sql.append("      ,M1.ins_user ");
		sql.append("      ,M1.ins_date ");
		sql.append("      ,M1.upd_user ");
		sql.append("      ,M1.upd_date ");
		sql.append("      ,M1.revision ");
		sql.append("  FROM MST_SENSEKI M1 ");
		sql.append(" WHERE M1.DEL_FLG = '0' ");

		// 戦績名
		if (!CommonUtil.isNull(CommonUtil.getStr(formMap.get(SensekiConst.KEY_SENSEKI_NM)))) {
			sql.append(" AND M1.SENSEKI_NM LIKE '%").append(formMap.get(SensekiConst.KEY_SENSEKI_NM)).append("%' ");
		}
		// 戦績区分
		if (!CommonUtil.isNull(CommonUtil.getStr(formMap.get(SensekiConst.KEY_SENSEKI_KBN_KEY)))) {
			sql.append(" AND M1.SENSEKI_KBN = '").append(formMap.get(SensekiConst.KEY_SENSEKI_KBN_KEY)).append("' ");
		}
		sql.append(" ORDER BY M1.SENSEKI_CD ");

		// 組み立てたSQLで検索処理を行う。
		List<Map<String, String>> result = super.search(sql.toString());

		// 処理結果を戻す
		return result;
	}

	/**
	 * <p><b>
	 * 戦績画面
	 * <br>削除処理(論理削除)
	 * </b></p>
	 * @param 戦績コード
	 * @param ログイン情報DTO
	 */
	public void deleteSenseki(String sensekiCd, LoginDto loginDto) {

		// 論理削除用のSQLを組み立てる。
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE MST_SENSEKI M1 ");
		sql.append("   SET M1.DEL_FLG   = '1' ");
		sql.append("     , M1.UPD_USER  = '").append(loginDto.getKojinId()).append("' ");
		sql.append("     , M1.UPD_DATE  = SYSDATE ");
		sql.append("     , M1.REVISION  = M1.REVISION + 1 ");
		sql.append(" WHERE M1.SENSEKI_CD = '").append(sensekiCd).append("' ");

		// 組み立てたSQLで更新処理(論理削除)を行う。
		super.update(sql.toString());
	}

	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>検索処理
	 * </b></p>
	 * @param フォーム項目
	 * @return Map<String, String> 検索結果
	 */
	public Map<String, String> findSenseki(Map<String, Object> formMap) {

		// 検索用のSQLを組み立てる。
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT M1.SENSEKI_CD ");
		sql.append("     , M1.SENSEKI_NM ");
		sql.append("     , M1.SENSEKI_KBN ");
		sql.append("     , M1.REVISION ");
		sql.append("  FROM MST_SENSEKI M1 ");
		sql.append(" WHERE M1.DEL_FLG   = '0' ");
		sql.append("   AND M1.SENSEKI_CD = '").append(formMap.get(SensekiConst.KEY_SENSEKI_CD)).append("' ");

		// 組み立てたSQLで検索処理を行う。
		Map<String, String> result = super.find(sql.toString());
		// 検索結果を戻す。
		return result;
	}

	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>登録処理
	 * </b></p>
	 * @param フォーム項目
	 * @param ログイン情報DTO
	 */
	public void registSenseki(Map<String, Object> formMap, LoginDto loginDto) {
        System.out.println("-------------------registSenseki-------------------------------");
        

        
		// 登録用のSQLを組み立てる。
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO SENSEKI_TBL( ");
		sql.append("MATCH_ID");
		sql.append(",PLAYER_ID");
		sql.append(",INNING");
		sql.append(",TAMAKAZU");
		sql.append(",HIANDA");
		sql.append(",YOSHIKYU");
		sql.append(",DATSUSANSHIN");
		sql.append(",SITTEN");
		sql.append(",JISEKITEN");
		sql.append(",E_TEAM");
		sql.append(",MATCH_DATE");
		sql.append(",INS_USER");
		sql.append(",INS_DATE");
		sql.append(")VALUES(");
		sql.append("(SELECT MAX(MATCH_ID)+1 FROM SENSEKI_TBL)");//MATCH_ID
		sql.append(",'").append(formMap.get(SensekiConst.KEY_SENSEKI_KBN_KEY)).append("'");//PLAYER_ID 
		sql.append(",TO_CHAR('").append(formMap.get(SensekiConst.KEY_ININGU)).append("')*3");
		sql.append(",'").append(formMap.get(SensekiConst.KEY_TAMAKAZU)).append("'");//TAMAKAZU
		sql.append(",'").append(formMap.get(SensekiConst.KEY_HIANDA)).append("'");//HIANDA
		sql.append(",'").append(formMap.get(SensekiConst.KEY_YOSHISHIKYU)).append("'");//YOSHIKYU
		sql.append(",'").append(formMap.get(SensekiConst.KEY_DATSUSANSHIN)).append("'");//DATSUSANSHIN
		sql.append(",'").append(formMap.get(SensekiConst.KEY_SHITTEN)).append("'");//SITTEN
		sql.append(",'").append(formMap.get(SensekiConst.KEY_JISEKITEN)).append("'");//JISEKITEN
		sql.append(",'").append(formMap.get(SensekiConst.KEY_TAISENNM)).append("'");//E_TEAM
		sql.append(",'").append(formMap.get(SensekiConst.KEY_SHIAIBI)).append("'");//E_TEAM//MATCH_DATE
		sql.append(",'").append(formMap.get(SensekiConst.KEY_ININGU)).append("'");//INS_USER
		sql.append(", SYSDATE ");//INS_DATE
		sql.append(" ) ");
		// 組み立てたSQLで登録処理を行う。
		super.update(sql.toString());

	}

	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>更新処理
	 * </b></p>
	 * @param フォーム項目
	 * @param ログイン情報DTO
	 */
	public void updateSenseki(Map<String, Object> formMap, LoginDto loginDto) {

		// 更新用のSQLを組み立てる。
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE MST_SENSEKI M1 ");
		sql.append("   SET M1.SENSEKI_NM  = '").append(formMap.get(SensekiConst.KEY_SENSEKI_NM)).append("' ");
		sql.append("     , M1.SENSEKI_KBN = '").append(formMap.get(SensekiConst.KEY_SENSEKI_KBN_KEY)).append("' ");
		sql.append("     , M1.UPD_USER   = '").append(loginDto.getKojinId()).append("' ");
		sql.append("     , M1.UPD_DATE   = SYSDATE ");
		sql.append("     , M1.REVISION   = M1.REVISION + 1 ");
		sql.append(" WHERE M1.SENSEKI_CD  = '").append(formMap.get(SensekiConst.KEY_SENSEKI_CD)).append("' ");

		// 組み立てたSQLで更新処理を行う。
		super.update(sql.toString());
	}

	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>重複チェック
	 * </b></p>
	 * @param フォーム項目
	 */
	public boolean checkOverlapSenseki(Map<String, Object> formMap) {

		// 検索用のSQLを組み立てる。
		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT M1.SENSEKI_CD ");
//		sql.append("  FROM MST_SENSEKI M1 ");
//		sql.append(" WHERE M1.SENSEKI_CD = '").append(formMap.get(SensekiConst.KEY_SENSEKI_CD)).append("' ");
//		sql.append("   AND ROWNUM = 1 ");

		// 組み立てたSQLで検索処理を行う。
		return super.find(sql.toString()).size() == 0;
	}

	/**
	 * 行ロック及び、排他チェック
	 * @param formMap フォーム項目
	 * @return true：正常、false：排他エラー
	 */
	public boolean lockSenseki(Map<String, Object> formMap) {

		// 検索用のSQLを組み立てる。
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT M1.SENSEKI_CD ");
		sql.append("  FROM MST_SENSEKI M1 ");
		sql.append(" WHERE M1.SENSEKI_CD = '").append(formMap.get(SensekiConst.KEY_SENSEKI_CD)).append("' ");
		sql.append("   AND M1.REVISION  = '").append(formMap.get(ITEM_REVISION)).append("' ");
		sql.append("   FOR UPDATE NOWAIT ");
		try {

			// 組み立てたSQLで検索処理を行う。
			return super.find(sql.toString()).size() != 0;

		} catch (CannotAcquireLockException e) {
			// 対象データがロックされている場合はエラー
			return false;
		}
	}
	
	/**
	 * セレクトボックス用選手名取得
	 * @return 選手名
	 */
	public Map<String, String> searchSelectboxSenshuNm() {

		List<Map<String, String>> result;
		Map<String, String> ret = new LinkedHashMap<String, String>();
		StringBuffer sql = new StringBuffer();
		sql.append("	SELECT PLAYER_ID AS ID						");
		sql.append("	,PLAYER_ID || ':' || PLAYER_NAME AS NAME    ");
		sql.append("	FROM MST_PLAYER                             ");
		sql.append("	ORDER BY  PLAYER_ID                         ");
		result = super.search(sql.toString());
		for (Map<String, String> map : result) {
			if (ret.size() == 0) {
				ret.put("", "");
			}
			ret.put(map.get("ID"), map.get("NAME"));
		}

		return ret;
	}
	
	
	
	/**
	 * セレクトボックス用イニング取得
	 * @return 選手名
	 */
	public Map<String, String> searchSelectboxIning() {

		List<Map<String, String>> result;
		Map<String, String> ret = new LinkedHashMap<String, String>();
		StringBuffer sql = new StringBuffer();
		sql.append("	SELECT PLAYER_ID AS ID						");
		sql.append("	,PLAYER_ID || ':' || PLAYER_NAME AS NAME    ");
		sql.append("	FROM MST_PLAYER                             ");
		sql.append("	ORDER BY  PLAYER_ID                         ");
		result = super.search(sql.toString());
		for (Map<String, String> map : result) {
			if (ret.size() == 0) {
				ret.put("", "");
			}
			ret.put(map.get("ID"), map.get("NAME"));
		}

		return ret;
	}
	

}







