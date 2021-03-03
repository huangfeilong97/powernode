package com.hfl.service.impl;

import com.hfl.dao.GoodsDao;
import com.hfl.dao.SaleDao;
import com.hfl.entity.Goods;
import com.hfl.entity.Sale;
import com.hfl.except.NotEnoughException;
import com.hfl.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BuyServiceImpl implements BuyService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private SaleDao saleDao;

    /*//set注入
    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }*/

    /**
     *
     * rollbackFor:表示发生指定的异常一定回滚.
     *   处理逻辑是：
     *     1) spring框架会首先检查方法抛出的异常是不是在rollbackFor的属性值中
     *         如果异常在rollbackFor列表中，不管是什么类型的异常，一定回滚。
     *     2) 如果你的抛出的异常不在rollbackFor列表中，spring会判断异常是不是RuntimeException,
     *         如果是一定回滚。
     *
     */
   /* @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,  NotEnoughException.class
            }
    )*/

    //使用的是事务控制的默认值， 默认的传播行为是REQUIRED，默认的隔离级别DEFAULT
    //默认抛出运行时异常，回滚事务。
    @Transactional
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("=====buy方法的开始====");
        Sale sale=new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);

        saleDao.insertSale(sale);

        Goods goods=goodsDao.selectGoods(goodsId);
        if(goods==null){
            throw new NullPointerException("编号是："+goodsId+",商品不存在");
        }else if(goods.getAmount()<nums){
            throw new NotEnoughException("编号是："+goodsId+",商品库存不足");
        }

        goods.setAmount(goods.getAmount()-nums);
        goodsDao.updateGoodsAmount(goods);
        System.out.println("=====buy方法的完成====");

    }
}
