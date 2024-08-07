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
	 * 成績一覧を検索する
	 * @param loginDto
	 * @return 成績一覧
	 */
	public List<Map<String, String>> searchSeiseki(LoginDto loginDto) {

		List<Map<String, String>> result;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT  S1.PLAYER_ID AS PLAYER_ID");
		sql.append("       ,M1.PLAYER_NAME AS PLAYER_NAME");
		sql.append("       ,TRUNC((SUM(S1.INNING)/3),0)||'.'||MOD(SUM(S1.INNING),3)  AS SOU_INNING");
		sql.append("       ,SUM(S1.SITTEN) AS SOU_SHITTEN ");
		sql.append("       ,SUM(S1.JISEKITEN) AS SOU_JISEKITEN ");
		sql.append("       ,CASE WHEN SUM(S1.INNING) = 0 AND SUM(S1.JISEKITEN) > 0 THEN '99.99' ");	// 小数点以下を2桁で表記するCASE文
		sql.append("             WHEN SUM(S1.INNING) = 0 AND SUM(S1.JISEKITEN) = 0 THEN '0.00' ");
		sql.append("             WHEN TRUNC(((SUM(S1.JISEKITEN))*9)/(SUM(S1.INNING)/3),2)<10 THEN TO_CHAR(TRUNC(((SUM(S1.JISEKITEN))*9)/(SUM(S1.INNING)/3),2),'0.00') ");
		sql.append("             WHEN TRUNC(((SUM(S1.JISEKITEN))*9)/(SUM(S1.INNING)/3),2) BETWEEN 10 AND 99 THEN TO_CHAR(TRUNC(((SUM(S1.JISEKITEN))*9)/(SUM(S1.INNING)/3),2),'00.00') ");
		sql.append("             WHEN TRUNC(((SUM(S1.JISEKITEN))*9)/(SUM(S1.INNING)/3),2) > 99.99 THEN '99.99' ");
		sql.append("        END AS BOUGYO_RITSU ");
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
	 * @param formMap
	 * @param loginDto
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
