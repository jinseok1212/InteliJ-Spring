package com.simple.basic.memo;

import com.simple.basic.command.MemoVO;

import java.util.ArrayList;

public interface MemoService {
    public void insertMemo(MemoVO vo);
    public ArrayList<MemoVO> getList();
}
