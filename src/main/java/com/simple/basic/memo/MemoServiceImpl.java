package com.simple.basic.memo;

import com.simple.basic.command.MemberVO;
import com.simple.basic.command.MemoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("memoService")
public class MemoServiceImpl implements MemoService{

    @Autowired
    MemoMapper memoMapper; //매퍼 구현체를 넣어줌..


    @Override
    public void insertMemo(MemoVO vo) {
        memoMapper.insertMemo(vo);
    }

    @Override
    public ArrayList<MemoVO> getList() {

        return memoMapper.getList();
    }
}
