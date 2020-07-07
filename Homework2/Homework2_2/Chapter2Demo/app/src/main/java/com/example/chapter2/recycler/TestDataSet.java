package com.example.chapter2.recycler;

import java.util.ArrayList;
import java.util.List;


public class TestDataSet {

    public static List<TestData> getData() {
        List<TestData> result = new ArrayList();
        result.add(new TestData("撸起袖子加油干", "刚刚", "剩女：上面那个可以手写可以打字",1));
        result.add(new TestData("文件传输助手", "下午2:00","[图片]",2));
        result.add(new TestData("盒子精", "下午1:59","那ok",3));
        result.add(new TestData("rop工作组", "下午1:32","那就，如果问起，跟他们说有考虑换组织自己...",1));
        result.add(new TestData("剩女", "上午10:33","等二倍速",1));
        result.add(new TestData("杭州王妃小队", "昨天","老晨伯：够刺激",1));
        result.add(new TestData("兰德力自助洗", "7月5日","服务完成提醒",1));
        result.add(new TestData("QSC Neo", "6月29日","老晨伯：哦莫俺又来了！麻烦有高...",1));
        result.add(new TestData("srtp小分队", "6月22日","王浚哲：之前问起辅导员她是这么说的",1));
        result.add(new TestData("已经不知道起啥名了", "6月20日","爱说啥说啥",1));
        result.add(new TestData("哈哈哈哈", "5月20日","祝天下有情人终成眷属",1));
        return result;
    }

}
