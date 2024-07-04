package cashbook.service.seiseki;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cashbook.dao.seiseki.SeisekiDao;
import cashbook.dto.common.LoginDto;
import cashbook.dto.seiseki.SeisekiListDto;

/**
 * 成績サービス
 * @author soppra
 */
public class SeisekiServiceImpl implements SeisekiService {

	/** 成績Dao */
	private SeisekiDao seisekiDao;
	
	/**
	 * 成績DAOのsetter
	 * @param seisekiDao
	 */
	public void setSeisekiDao(SeisekiDao seisekiDao) {
		this.seisekiDao = seisekiDao;
	}

	/**
	 * 成績画面初期表示メソッド
	 * @param loginDto
	 */
	public SeisekiListDto listInit(LoginDto loginDto) {
		//------------------------------------------
		// ヘッダ
		//------------------------------------------
		SeisekiListDto result = new SeisekiListDto();
		
		//------------------------------------------
		// 一覧
		//------------------------------------------
		List<SeisekiListDto> SeisekiList = new ArrayList<SeisekiListDto>();
		// 検索処理
		List<Map<String, String>> list = seisekiDao.searchSeiseki(loginDto);
		Iterator<Map<String, String>> it = list.iterator();
		while (it.hasNext()) {
			Map<String, String> map = it.next();
			SeisekiListDto dto = new SeisekiListDto();
			dto.setSenshuId(map.get("PLAYER_ID"));
			dto.setSenshuNm(map.get("PLAYER_NAME"));
			dto.setSouInning(map.get("SOU_INNING"));
			dto.setSouShitten(map.get("SOU_SHITTEN"));
			dto.setSouJisekiten(map.get("SOU_JISEKITEN"));
			dto.setBougyoRitsu(map.get("BOUGYO_RITSU"));

			SeisekiList.add(dto);
		}
		result.setList(SeisekiList);
		return result;
	}

	/**
	 * 新規選手登録メソッド
	 * @param formMap
	 * @param loginDto
	 */
	public void registNewSenshu(Map<String, Object> formMap, LoginDto loginDto) throws Exception {

		// 登録処理
		seisekiDao.registSenshu(formMap, loginDto);
	}

}