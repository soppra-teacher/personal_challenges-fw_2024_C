package cashbook.dao.senseki;

import java.util.List;
import java.util.Map;

import cashbook.dao.common.BaseDaoImpl;
import cashbook.dto.common.LoginDto;
import cashbook.util.SensekiConst;

/**
 * 個人戦績DAOクラス
 * @author soppra
 */
public class SensekiDaoImpl extends BaseDaoImpl implements SensekiDao {

	/**
	 * 個人戦績一覧を検索する
	 * @param formMap フォーム項目
	 * @param loginDto
	 * @param formMap
	 * @return 個人戦績一覧
	 */
	public List<Map<String, String>> searchSenseki(Map<String, Object> formMap,LoginDto loginDto) {

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
		sql.append("  FROM SENSEKI_TBL M1");
		sql.append(" WHERE M1.PLAYER_ID = '").append(formMap.get(SensekiConst.KEY_SENSHU_ID)).append("' ");
		sql.append("  AND INS_USER= '").append(loginDto.getUserId()).append("' "); // 登録ユーザーとログインユーザーの合致で絞り込み
		sql.append("  ORDER BY MATCH_DATE DESC ");

		result = super.search(sql.toString());

		return result;
	}

	/**
	 * 個人戦績を削除する
	 * @param checkDel
	 * @param loginDto
	 */
	public void deleteSenseki(String matchId, LoginDto loginDto) {

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM SENSEKI_TBL M1 ");
		sql.append(" WHERE M1.MATCH_ID = '").append(matchId).append("' ");

		super.update(sql.toString());

	}

	/**
	 * 選手名を検索する
	 * @param formMap
	 * @return 選手名
	 */
	public String getPlayerName(Map<String, Object> formMap) {
		Map<String, String> result;
		StringBuffer sql = new StringBuffer();

		sql.append(" SELECT P1.PLAYER_NAME AS PNAME");
		sql.append(" FROM MST_PLAYER P1 ");
		sql.append(" WHERE P1.PLAYER_ID = '").append(formMap.get(SensekiConst.KEY_SENSHU_ID)).append("' ");

		result = super.find(sql.toString());
		return result.get("PNAME");
	}

}
