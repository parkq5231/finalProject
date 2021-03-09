package com.company.temp.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.temp.user.service.UserService;
import com.company.temp.user.service.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserMapper dao;

	@Override
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		dao.updateUser(vo);
	}

	@Override
	public int deleteUser(UserVO vo) {
		return dao.deleteUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

	@Override
	public List<UserVO> getSearchUser(UserVO vo) {
		return dao.getSearchUser(vo);
	}

	@Override
	public boolean logCheck(UserVO vo) {
		// 단건조회
		UserVO uservo = dao.getUser(vo);
		// id일치여부 채크
		if (uservo == null) {
			return false;
		}
		// pw일치여부 채크
		if (uservo.getPassword().equals(vo.getPassword())) {
			return true;
		} else {
			return false;
		}
	}// end of logCheck

	@Override
	public int updatePw(UserVO vo) {
		// 단건조회
		UserVO uservo = dao.getUser(vo);
		// 기존패스워드와 일치하는지 채크
		if (uservo.getPassword().equals(vo.getOldpassword())) {
			// 일치한다면 패스워드 업데이트
			dao.updateUser(vo);
			return 1;
		}
		return 0;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("========================userService 실행");
		UserVO uservo = new UserVO();
		uservo.setId(username);
		uservo = dao.getUser(uservo);

		if (uservo == null) {
			throw new UsernameNotFoundException("no user");
		}
		return uservo;
	}
}
