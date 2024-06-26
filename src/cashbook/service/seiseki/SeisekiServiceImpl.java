package cashbook.service.seiseki;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cashbook.dao.seiseki.SeisekiDao;
import cashbook.dto.common.LoginDto;
import cashbook.dto.seiseki.SeisekiListDto;
import cashbook.exception.CommonValidateException;

/**
 * 成績マスタサービス
 * @author soppra
 */
public class SeisekiServiceImpl implements SeisekiService {

	/** 成績マスタDao */
	private SeisekiDao seisekiDao;

	/**
	 * 一覧画面初期化メソッド
	 */
	public SeisekiListDto listInit() {
		SeisekiListDto result = new SeisekiListDto();
		return result;
	}

	/**
	 * 一覧画面検索メソッド
	 */
	public SeisekiListDto listSearch(LoginDto loginDto) {
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
			dto.setSenshuId(map.get("選手ID"));
			dto.setSenshuNm(map.get("選手名"));
			dto.setSouInning(map.get("総イニング"));
			dto.setSouShitten(map.get("総失点"));
			dto.setSouJisekiten(map.get("総自責点"));
			dto.setBougyoRitsu(map.get("防御率"));

			SeisekiList.add(dto);
		}
		result.setList(SeisekiList);
		return result;
	}

	/**
	 * 新規選手登録メソッド
	 * @throws CommonValidateException
	 */
	public void registNewSenshu(Map<String, Object> formMap, LoginDto loginDto) throws Exception {

		// 登録処理
		seisekiDao.registSenshu(formMap, loginDto);
	}
	
	
	/**
	 * DAOのsetter
	 * @param seisekiDao
	 */
	public void setSeisekiDao(SeisekiDao seisekiDao) {
		this.seisekiDao = seisekiDao;
	}

}