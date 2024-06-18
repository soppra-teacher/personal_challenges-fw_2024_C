package cashbook.service.user;

import static cashbook.util.Const.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;

import cashbook.dao.common.CommonDao;
import cashbook.dao.user.UserDao;
import cashbook.dto.common.LoginDto;
import cashbook.dto.user.UserListDto;
import cashbook.dto.user.UserRegistDto;
import cashbook.exception.CommonValidateException;
import cashbook.util.CommonUtil;
import cashbook.util.Const;
import cashbook.util.UserConst;

/**
 * ユーザーマスタサービス
 * @author soppra
 */
public class UserServiceImpl implements UserService {

	/** ユーザーマスタDao */
	private UserDao userDao;

	/** 共通Dao */
	private CommonDao commonDao;

	/**
	 * 一覧画面初期表示メソッド
	 */
	public UserListDto listInit() {
		UserListDto result = new UserListDto();
		// 性別コンボボックスの設定
		result.setSeibetsuKbn(commonDao.getCode(CD_BUNRUI_002));
		// 続柄区分コンボボックスの設定
		result.setzokugara(commonDao.getCode(CD_BUNRUI_003));
		return result;
	}

	/**
	 * 一覧画面検索メソッド
	 */
	public UserListDto listSearch(Map<String, Object> formMap) {
		//------------------------------------------
		// ヘッダ
		//------------------------------------------
		UserListDto result = new UserListDto();
		// 入力項目を保持
		result.setUserNm(CommonUtil.getStr(formMap.get(UserConst.KEY_USER_NM)));
		result.setUserNmkana(CommonUtil.getStr(formMap.get(UserConst.KEY_USER_NM_KANA)));
		result.setSeibetsuKbnKey(CommonUtil.getStr(formMap.get(UserConst.KEY_SEIBETSU_KBN_KEY)));
		result.setZokugaraKey(CommonUtil.getStr(formMap.get(UserConst.KEY_ZOKUGARA)));
		result.setSetaiNusiFlg(CommonUtil.getStr(formMap.get(UserConst.KEY_SETAINUSI_FLG)));
		// 性別区分コンボボックスの設定
		result.setSeibetsuKbn(commonDao.getCode(CD_BUNRUI_002));
		// 続柄区分コンボボックスの設定
		result.setzokugara(commonDao.getCode(CD_BUNRUI_003));

		//------------------------------------------
		// 一覧
		//------------------------------------------
		List<UserRegistDto> UserList = new ArrayList<UserRegistDto>();
		// 検索処理
		List<Map<String, String>> list = userDao.searchUser(formMap);
		Iterator<Map<String, String>> it = list.iterator();
		while (it.hasNext()) {
			Map<String, String> map = it.next();
			UserRegistDto dto = new UserRegistDto();
			dto.setUserId(map.get("USER_ID"));
			dto.setSetaiId(map.get("SETAI_ID"));
			dto.setUserNm(map.get("USER_NM"));
			dto.setUserNmkana(map.get("USER_NM_KANA"));
			dto.setSeibetsuNm(commonDao.getCode(CD_BUNRUI_002).get(map.get("SEIBETSU_KBN")));
			dto.setZokugaraNm(commonDao.getCode(CD_BUNRUI_003).get(map.get("ZOKUGARA")));
			dto.setSetaiNusiFlg(map.get("SETAINUSHI_FLG"));
			if (SETAINUSHI_ON.equals(map.get("SETAINUSHI_FLG"))) {
				dto.setSetaiNusiNm(commonDao.getCodeName(CD_BUNRUI_004, CD_004_1));
			}
			UserList.add(dto);
		}
		result.setList(UserList);
		return result;
	}

	/**
	 * 一覧画面削除メソッド
	 */
	public void listDelete(Map<String, Object> formMap, LoginDto loginDto) {
		List<String> list = CommonUtil.convFormMapToList(formMap);
		for (String checkDel : list) {
			userDao.deleteUser(checkDel, loginDto);
		}
	}

	/**
	 * 登録画面初期表示メソッド
	 */

	public UserRegistDto registInit() {
		UserRegistDto result = new UserRegistDto();

		// 続柄区分コンボボックスの設定
		result.setZokugara(commonDao.getCode(CD_BUNRUI_003));
		// 世帯名コンボボックスの設定
		//result.setSetaiNm(setaiDao.searchSelectboxSetai());

		return result;
	}

	public UserRegistDto registInit(Map<String, Object> formMap) {

		UserRegistDto result = new UserRegistDto();

		// 続柄区分コンボボックスの設定
		result.setZokugara(commonDao.getCode(CD_BUNRUI_003));
		// 世帯名コンボボックスの設定
		//result.setSetaiNm(setaiDao.searchSelectboxSetai());

		// 更新モードの場合は、対象のユーザーマスタを取得する
		if (formMap != null && !CommonUtil.isNull(CommonUtil.getStr(formMap.get(UserConst.KEY_USER_ID)))) {
			Map<String, String> map = userDao.findUser(formMap);
			if (map != null) {
				result.setUserId(map.get("USER_ID"));
				result.setSetaiNmKey(map.get("SETAI_ID"));
				result.setPass(map.get("PASS"));
				result.setUserNm(map.get("USER_NM"));
				result.setUserNmkana(map.get("USER_NM_KANA"));
				result.setSeibetsuKbn(map.get("SEIBETSU_KBN"));
				result.setZokugaraKey(map.get("ZOKUGARA"));
				if (SETAINUSHI_ON.equals(map.get("SETAINUSHI_FLG"))) {
					result.setSetaiNusiFlg(SETAINUSHI_FLG_ON);
				}
				result.setRevision(map.get("REVISION"));
			}
		} else {
			result.setSeibetsuKbn(SEIBETSU_KBN_MAN); // 初期値："1"(男)
		}
		return result;
	}

	/**
	 * 登録画面登録・更新メソッド
	 * @return 
	 * @throws CommonValidateException
	 */  //ここの戻り値を変更 VOID => booleanへ
	public void registInsUpd(Map<String, Object> formMap) throws Exception {

		// 世帯主フラグ="1" 且つ 世帯主チェック
		//		if (SETAINUSHI_ON.equals(formMap.get(UserConst.KEY_SETAINUSI_FLG_VALUE))
		//				&& formMap.get(UserConst.KEY_SETAINUSI_FLG_VALUE) != null &&
		//				userDao.checkSetainushiFlg(formMap)) {
		//			throw new CommonValidateException(MSG_USER_CONSIS_1);
		//		}

		// 性別、続柄の整合性チェック
		//		if (check2(formMap)) {
		//			throw new CommonValidateException(MSG_USER_CONSIS_2);
		//		}
		String user_pass = CommonUtil.getStr(formMap.get(UserConst.KEY_PASS));
		String user_pass2 = CommonUtil.getStr(formMap.get(UserConst.KEY_PASS2));
		
		
		System.out.println("UserServiceImplのregistInsUpd" + formMap);
		// 登録の場合
		if (CommonUtil.isNull(CommonUtil.getStr(formMap.get(Const.ITEM_REVISION)))) {
			System.out.println("UserServiceImplの登録の場合");
			System.out.println("UserServiceImpl登録処理");
			System.out.println("registInsUpdの" + "user_passを" + user_pass + "表示してるよん");
			System.out.println("registInsUpdの" + "user_pass2を" + user_pass2 + "表示してるよん");
			// 存在チェック
			if (!userDao.checkOverlapUser(formMap)) {
				System.out.println("UserServiceImpl存在チェック");
				throw new CommonValidateException(MSG_ERRORS_PRIMARY_KEY);
			}
			
			//パスワードのチェックをおこなう
			
			//=============変更箇所================================================================
//			if (!CommonUtil.isNull(userID)) {
			if (!user_pass.equals(user_pass2)) {
				throw new CommonValidateException(MSG_ERRORS_LOGIN_ERROR);
			}

			//=====================================================================================
			userDao.registUser(formMap);

			// 登録処理

			/*
			 * Copyright 2024 the original author or authors.
			 *
			 * Licensed under the Apache License, Version 2.0 (the "License");
			 * you may not use this file except in compliance with the License.
			 * You may obtain a copy of the License at
			 *
			 *      https://www.apache.org/licenses/LICENSE-2.0
			 *
			 * Unless required by applicable law or agreed to in writing, software
			 * distributed under the License is distributed on an "AS IS" BASIS,
			 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
			 * See the License for the specific language governing permissions and
			 * limitations under the License.
			 */

			// 更新の場合
		} else {
			// 排他処理
			//			if (!userDao.lockUser(formMap)) {
			//				throw new CommonValidateException(MSG_ERRORS_DATA_LOCK);
			//			}

		}
	}

	/**
	 * 登録画面登録・更新メソッド
	 * @param  formMap 画面入力項目
	 * @return True:NG, False:OK
	 */
	private boolean check2(Map<String, Object> formMap) {
		boolean bRet = false;
		String seibetsuKbn = CommonUtil.getStr(formMap.get(UserConst.KEY_SEIBETSU_KBN));
		String zokugaraKbn = CommonUtil.getStr(formMap.get(UserConst.KEY_ZOKUGARA));

		// 性別・続柄の相関チェック
		// 続柄がブランクの場合は、チェックを行わない
		if (!CommonUtil.isNull(zokugaraKbn)) {
			if (SEIBETSU_KBN_MAN.equals(seibetsuKbn)) {
				if (!(ZOKUGARA_FATHER.equals(zokugaraKbn)
						|| ZOKUGARA_ELDEST_SON.equals(zokugaraKbn)
						|| ZOKUGARA_SECOND_SON.equals(zokugaraKbn)
						|| ZOKUGARA_THIRD_SON.equals(zokugaraKbn))) {
					bRet = true;
				}
			} else if (SEIBETSU_KBN_WOMAN.equals(seibetsuKbn)) {
				if (!(ZOKUGARA_MOTHER.equals(zokugaraKbn)
						|| ZOKUGARA_ELDEST_DAUGHTER.equals(zokugaraKbn)
						|| ZOKUGARA_SECOND_DAUGHTER.equals(zokugaraKbn)
						|| ZOKUGARA_THIRD_DAUGHTER.equals(zokugaraKbn))) {
					bRet = true;
				}
			}
		}

		return bRet;
	}

	/**
	 * DAOのsetter
	 * @param userDao
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * DAOのsetter
	 * @param commonDao
	 */
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	@Override
	public void registInsUpd(ActionForm form) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}