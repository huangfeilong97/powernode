package com.hfl.dao;

import com.hfl.entity.Goods;

public interface GoodsDao {

    //更新商品库存信息
    int updateGoodsAmount(Goods goods);

    //查找商品
    Goods selectGoods(Integer goodsId);
}
