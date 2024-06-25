package cashbook.dao.seiseki;

import java.util.List;
import java.util.Map;

import cashbook.dao.common.BaseDaoImpl;
import cashbook.dto.common.LoginDto;
import cashbook.util.SeisekiConst;

/**
 * 成績DAOクラス
 * @author soppra
 */
public class SeisekiDaoImpl extends BaseDaoImpl implements SeisekiDao {

	/**
	 * 成績マスタ一覧を検索する
	 * @return 成績マスタ一覧
	 */
	public List<Map<String, String>> searchSeiseki(Map<String, Object> formMap, LoginDto loginDto) {

		List<Map<String, String>> result;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT  S1.PLAYER_ID AS 選手ID");
		sql.append("       ,M1.PLAYER_NAME AS 選手名");
		sql.append("       ,TRUNC((SUM(S1.INNING)/3),0)||'.'||MOD(SUM(S1.INNING),3)  AS 総イニング");
		sql.append("       ,SUM(S1.SITTEN) AS 総失点 ");
		sql.append("       ,SUM(S1.JISEKITEN) AS 総自責点 ");
		sql.append("       ,TO_CHAR((SUM(S1.JISEKITEN))*9/(SUM(S1.INNING)/3),'0.00') AS 防御率 ");
		sql.append("  FROM SENSEKI_TBL S1 ");
		sql.append("  LEFT JOIN MST_PLAYER M1 ");
		sql.append("  ON S1.PLAYER_ID=M1.PLAYER_ID ");
		sql.append("  WHERE S1.INS_USER= '").append(loginDto.getUserId()).append("' "); // 登録ユーザーとログインユーザーの合致で絞り込み
		sql.append("  GROUP BY M1.PLAYER_NAME,S1.PLAYER_ID ");
		sql.append("  ORDER BY S1.PLAYER_ID ");
		result = super.search(sql.toString());

		return result;
	}
	
	
	/**
	 * 選手マスタに新規選手登録する
	 * @throws Exception
	 */
	public void registSenshu(Map<String, Object> formMap, LoginDto loginDto) {
		
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO MST_PLAYER M1 ( ");
		sql.append("     M1.PLAYER_ID ");
		sql.append("   ,M1.PLAYER_NAME ");
		sql.append("   ,M1.INS_USER ");
		sql.append("   ,M1.INS_DATE ");
		sql.append(" ) VALUES ( ");
		sql.append("     (SELECT MAX(PLAYER_ID)+1 FROM MST_PLAYER)");
		sql.append("   , '").append(formMap.get(SeisekiConst.KEY_NEW_SENSHU_NM)).append("' ");
		sql.append("   , '").append(loginDto.getUserId()).append("' ");
		sql.append("   , SYSDATE ");
		sql.append(" ) ");

		super.update(sql.toString());
	}


}
