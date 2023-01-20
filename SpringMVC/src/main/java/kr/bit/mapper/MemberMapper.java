package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.bit.model.MemberVO;

@Mapper
public interface MemberMapper {
	
	public List<MemberVO> memberList();
	public int memberInsert (MemberVO memberVO);
	public int memberDelete (Integer num);
	public MemberVO memberContent(Integer num);
	public int memberUpdate(MemberVO memberVO);
	
}
