package cashbook.dao.sensekireg;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cashbook.dao.common.BaseDaoImpl;
import cashbook.dto.common.LoginDto;
import cashbook.util.CommonUtil;
import cashbook.util.SensekiRegConst;

/**
 * 個人戦績DAOクラス
 * @author soppra
 */
public class SensekiRegDaoImpl extends BaseDaoImpl implements SensekiRegDao {
	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>登録処理
	 * </b></p>
	 * @param フォーム項目
	 * @param ログイン情報DTO
	 */
	public void registSenseki(Map<String, Object> formMap, LoginDto loginDto) {

		int ining = Integer.parseInt(CommonUtil.getStr(formMap.get(SensekiRegConst.KEY_ININGU)));
		int ininMini = Integer.parseInt(CommonUtil.getStr(formMap.get(SensekiRegConst.KEY_ININGU_MINI_KEY)));	
		int iningSum = ining * 3 + ininMini;//INING + INING_MINI

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
		sql.append(",'").append(formMap.get(SensekiRegConst.KEY_SENSHU_NM_KEY)).append("'");//PLAYER_ID
		sql.append(",'").append(iningSum).append("'");//INING + INING_MINI
		sql.append(",'").append(formMap.get(SensekiRegConst.KEY_TAMAKAZU)).append("'");//TAMAKAZU
		sql.append(",'").append(formMap.get(SensekiRegConst.KEY_HIANDA)).append("'");//HIANDA
		sql.append(",'").append(formMap.get(SensekiRegConst.KEY_YOSHISHIKYU)).append("'");//YOSHIKYU
		sql.append(",'").append(formMap.get(SensekiRegConst.KEY_DATSUSANSHIN)).append("'");//DATSUSANSHIN
		sql.append(",'").append(formMap.get(SensekiRegConst.KEY_SHITTEN)).append("'");//SITTEN
		sql.append(",'").append(formMap.get(SensekiRegConst.KEY_JISEKITEN)).append("'");//JISEKITEN
		sql.append(",'").append(formMap.get(SensekiRegConst.KEY_TAISENNM)).append("'");//E_TEAM
		sql.append(",'").append(formMap.get(SensekiRegConst.KEY_SHIAIBI)).append("'");//E_TEAM//MATCH_DATE
		sql.append("   , '").append(loginDto.getUserId()).append("' ");//INS_USER
		sql.append(", SYSDATE ");//INS_DATE
		sql.append(" ) ");

		super.update(sql.toString());

	}

	/**
	 * セレクトボックス用選手名取得
	 * @param loginDto
	 * @return 選手名
	 */
	public Map<String, String> searchSelectboxSenshuNm(LoginDto loginDto) {

		List<Map<String, String>> result;
		Map<String, String> ret = new LinkedHashMap<String, String>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT PLAYER_ID AS ID");
		sql.append(",PLAYER_ID || ':' || PLAYER_NAME AS NAME    ");
		sql.append("FROM MST_PLAYER                             ");
		sql.append("ORDER BY  PLAYER_ID                         ");
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