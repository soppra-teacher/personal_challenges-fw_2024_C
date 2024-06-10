package cashbook.dao.seiseki;

import static cashbook.util.Const.*;

import java.util.List;
import java.util.Map;

import org.springframework.dao.CannotAcquireLockException;

import cashbook.dao.common.BaseDaoImpl;
import cashbook.dto.common.LoginDto;
import cashbook.util.SeisekiConst;
import cashbook.util.SetaiConst;

/**
 * 成績DAOクラス
 * @author soppra
 */
public class SeisekiDaoImpl extends BaseDaoImpl implements SeisekiDao {

	/**
	 * 成績マスタ一覧を検索する
	 * @return 成績マスタ一覧
	 */
	public List<Map<String, String>> searchSeiseki(Map<String, Object> formMap) {

		List<Map<String, String>> result;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT  M1.PLAYER_ID ");
		sql.append("       ,M1.INNING_3 ");
		sql.append("       ,M1.SITTEN ");
		sql.append("       ,M1.JISEKITEN ");
		sql.append("       ,M1.JISEKITEN ");
		sql.append("  FROM SENSEKI_TBL M1 ");

		sql.append(" ORDER BY M1.PLAYER_ID ");
		result = super.search(sql.toString());

		return result;
	}

	/**
	 * 成績マスタを削除する
	 */
	public void deleteSeiseki(String seisekiId, LoginDto loginDto) {

		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE MST_SEISEKI M1 ");
		sql.append("   SET M1.DEL_FLG = '1' ");
		sql.append("     , M1.UPD_USER = '").append(loginDto.getKojinId()).append("' ");
		sql.append("     , M1.UPD_DATE = SYSDATE ");
		sql.append("     , M1.REVISION = M1.REVISION + 1 ");
		sql.append(" WHERE M1.SEISEKI_ID = '").append(seisekiId).append("' ");

		super.update(sql.toString());
	}

	/**
	 * 成績マスタを検索する
	 * @return 成績マスタ
	 */
	public Map<String, String> findSeiseki(Map<String, Object> formMap) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT M1.SEISEKI_ID ");
		sql.append("     , M1.SETAI_ID ");
		sql.append("     , M1.PASS ");
		sql.append("     , M1.SEISEKI_NM ");
		sql.append("     , M1.SEISEKI_NM_KANA ");
		sql.append("     , M1.SEIBETSU_KBN ");
		sql.append("     , M1.ZOKUGARA ");
		sql.append("     , M1.SETAINUSHI_FLG ");
		sql.append("     , M1.REVISION ");
		sql.append("  FROM MST_SEISEKI M1 ");
		sql.append(" WHERE M1.DEL_FLG  = '0' ");
		sql.append("   AND M1.SEISEKI_ID = '").append(formMap.get(SeisekiConst.KEY_SEISEKI_ID)).append("' ");

		return super.find(sql.toString());
	}

	/**
	 * 成績マスタを登録する
	 * @throws Exception
	 */
	public void registSeiseki(Map<String, Object> formMap, LoginDto loginDto) {

		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO MST_SEISEKI M1 ( ");
		sql.append("     M1.SEISEKI_ID ");
		sql.append("   , M1.SETAI_ID ");
		sql.append("   , M1.PASS ");
		sql.append("   , M1.SEISEKI_NM ");
		sql.append("   , M1.SEISEKI_NM_KANA ");
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
		sql.append("     '").append(formMap.get(SeisekiConst.KEY_SEISEKI_ID)).append("' ");
		sql.append("   , '").append(formMap.get(SetaiConst.KEY_SETAI_ID)).append("' ");
		sql.append("   , '").append(formMap.get(SeisekiConst.KEY_PASS)).append("' ");
		sql.append("   , '").append(formMap.get(SeisekiConst.KEY_SEISEKI_NM)).append("' ");
		sql.append("   , '").append(formMap.get(SeisekiConst.KEY_SEISEKI_NM_KANA)).append("' ");
		sql.append("   , '").append(formMap.get(SeisekiConst.KEY_SEIBETSU_KBN)).append("' ");
		sql.append("   , '").append(formMap.get(SeisekiConst.KEY_ZOKUGARA)).append("' ");
		sql.append("   , '").append(formMap.get(SeisekiConst.KEY_SETAINUSI_FLG_VALUE)).append("' ");
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
	 * 選手マスタを登録する
	 * @throws Exception
	 */
	public void registSenshu(Map<String, Object> formMap, LoginDto loginDto) {
		
		System.out.println("選手登録実行開始");
		System.out.println(formMap);
		
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO MST_PLAYER M1 ( ");
		sql.append("     M1.PLAYER_ID ");
		sql.append("   ,M1.PLAYER_NAME ");
		sql.append("   ,M1.INS_USER ");
		sql.append("   ,M1.INS_DATE ");
		sql.append(" ) VALUES ( ");
		sql.append("     (SELECT SUBSTR('0000000' || (MAX(PLAYER_ID) + 1), LENGTH('0000000' || (MAX(PLAYER_ID) + 1)) - 7, 8)FROM MST_PLAYER)");
		sql.append("   , '").append(formMap.get(SeisekiConst.KEY_NEW_SENSHU_NM)).append("' ");
		sql.append("   , '").append(loginDto.getKojinId()).append("' ");
		sql.append("   , SYSDATE ");
		sql.append(" ) ");

		super.update(sql.toString());
	}
	
	
	
	
	
	
	
	/**
	 * 成績マスタを更新する
	 */
	public void updateSeiseki(Map<String, Object> formMap, LoginDto loginDto) {

		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE MST_SEISEKI M1 ");
		sql.append("   SET M1.SETAI_ID = '").append(formMap.get(SetaiConst.KEY_SETAI_ID)).append("' ");
		sql.append("     , M1.PASS = '").append(formMap.get(SeisekiConst.KEY_PASS)).append("' ");
		sql.append("     , M1.SEISEKI_NM = '").append(formMap.get(SeisekiConst.KEY_SEISEKI_NM)).append("' ");
		sql.append("     , M1.SEISEKI_NM_KANA = '").append(formMap.get(SeisekiConst.KEY_SEISEKI_NM_KANA)).append("' ");
		sql.append("     , M1.SEIBETSU_KBN = '").append(formMap.get(SeisekiConst.KEY_SEIBETSU_KBN)).append("' ");
		sql.append("     , M1.ZOKUGARA = '").append(formMap.get(SeisekiConst.KEY_ZOKUGARA)).append("' ");
		sql.append("     , M1.SETAINUSHI_FLG = '").append(formMap.get(SeisekiConst.KEY_SETAINUSI_FLG_VALUE)).append("' ");
		sql.append("     , M1.UPD_USER = '").append(loginDto.getKojinId()).append("' ");
		sql.append("     , M1.UPD_DATE = SYSDATE ");
		sql.append("     , M1.REVISION = M1.REVISION + 1 ");
		sql.append(" WHERE M1.SEISEKI_ID = '").append(formMap.get(SeisekiConst.KEY_SEISEKI_ID)).append("' ");

		super.update(sql.toString());
	}
	
	
	
	/**
	 * 総成績一覧の初期表示
	 * @return 成績マスタ
	 */
//	public Map<String, String> firstSeiseki(Map<String, Object> formMap) {
//
//		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT P.PLAYER_ID ");	// 選手ID
//		sql.append("     ,P.PLAYER_NAME ");	// 選手名
//		sql.append("     ,SUM(S.INNING) ");	// 総イニング
//		sql.append("     ,SUM(S.SITTEN) ");	// 総失点
//		sql.append("     ,SUM(S.JISEKITEN) ");	// 総自責点
//		sql.append("     ,TRUNC(SUM(S.JISEKITEN) * 9 / SUM(S.INNING),2) ");	// 防御率
//		sql.append("FROM SENSEKI_TBL S ");
//		sql.append("LEFT JOIN MST_PLAYER P ");
//		sql.append("ON S.PLAYER_ID = P.PLAYER_ID ");
//		sql.append("GROUP BY P.PLAYER_NAME,P.PLAYER_ID ");
//		//sql.append("WHERE M1.DEL_FLG  = '0' "); 登録者とユーザーIDの合致確認
//		sql.append("ORDER BY P.PLAYER_ID");
//
//		return super.find(sql.toString());
////	}
//	
//	public SeisekiListDto listSetting(Map<String, Object> formMap) {
//		SeisekiListDto result = new SeisekiListDto();
//		List<SeisekiRegistDto> SeisekiList = new ArrayList<SeisekiRegistDto>();
//		// 検索処理
//		List<Map<String, String>> list = seisekiDao.firstSeiseki(formMap);
//		Iterator<Map<String, String>> it = list.iterator();
//		while (it.hasNext()) {
//			Map<String, String> map = it.next();
//			SeisekiRegistDto dto = new SeisekiRegistDto();
//			dto.setSenshuId(map.get("選手ID"));
//			dto.setsenshuNm(map.get("選手名"));
//			dto.setsouIning(map.get("総イニング"));
//			dto.setsouShitten(map.get("総失点"));
//			dto.setsouJisekiten(map.get("総自責点 "));
//			dto.setbougyoRitsu(map.get("防御率"));
//			SeisekiList.add(dto);
//			
//		}
//		result.setList(SeisekiList);
//		return result;
//	}

	/**
	 * 重複チェック
	 * @return true：正常、false：重複エラー
	 */
	public boolean checkOverlapSeiseki(Map<String, Object> formMap) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT M1.SEISEKI_ID ");
		sql.append("  FROM MST_SEISEKI M1 ");
		sql.append(" WHERE M1.SEISEKI_ID = '").append(formMap.get(SeisekiConst.KEY_SEISEKI_ID)).append("' ");
		sql.append("   AND ROWNUM = 1 ");

		return super.find(sql.toString()).size() == 0;
	}

	/**
	 * 行ロック及び、排他チェック
	 * @return true：正常、false：排他エラー
	 */
	public boolean lockSeiseki(Map<String, Object> formMap) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT M1.SEISEKI_ID ");
		sql.append("  FROM MST_SEISEKI M1 ");
		sql.append(" WHERE M1.SEISEKI_ID = '").append(formMap.get(SeisekiConst.KEY_SEISEKI_ID)).append("' ");
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
		sql.append("SELECT A.SEISEKI_ID ");
		sql.append("  FROM MST_SEISEKI A ");
		sql.append(" WHERE A.SETAI_ID = '").append(formMap.get(SetaiConst.KEY_SETAI_ID)).append("' ");
		sql.append("   AND A.SETAINUSHI_FLG = '1' ");
		sql.append("   AND A.SEISEKI_ID != '").append(formMap.get(SeisekiConst.KEY_SEISEKI_ID)).append("' ");

		return super.find(sql.toString()).size() != 0;
	}
}
