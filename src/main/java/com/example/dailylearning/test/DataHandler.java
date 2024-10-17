package com.example.dailylearning.test;

import com.example.dailylearning.web.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataHandler {

    private static final Logger log = LoggerFactory.getLogger(DataHandler.class);

    //自定义数据库连接对象
    private DBHelper db;

    private PreparedStatement statement;

    //prepareStatement的sql语句是使用?（占位符）赋值。
    private String insertUser = "insert into td_order_relation9 (id," +
            "order_id," +
            "origin_order_id,product_code,product_name,charge_type,product_type,prm_code,cb_code,user_id," +
            "phone_type,order_time,effect_time,order_channel,cancel_order_time,lose_effect_time,operation_time,cancel_order_channel," +
            "order_state,province,is_first_order,channel_name,channel_code,one_level_channel,two_level_channel,three_level_channel," +
            "handle_state,insert_time,update_time,lose_effect_status,trigger_time,order_cycle,account,account_type) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public DataHandler() {
        //new一个
        db = new DBHelper();
        //开启数据库连接
        db.openConnection();
        try {
            //预编译sql语句，返回PreparedStatement实例
            statement = db.conn.prepareStatement(insertUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //入库总数
    private long totalLine = 0;
    //入库数量
    private int counter = 0;
    //最大入库数量
    private int maxBatch =500;

    /**
     * 处理数据：解析添加到批量SQL中，达到入库最大批次后批量入库
     * @author xiafan
     * @param user 处理数据
     * @param count 行标识
     * @throws Exception
     */
    public void insertUser(User user, long count) throws Exception {
        try {
            totalLine++;
            counter++;
            if (user != null) {
                statement.setObject(1, 1);
//                statement.setObject(2, user.getOrder_id());
//                statement.setObject(3, user.getOrigin_order_id());
//                statement.setObject(4, user.getProduct_code());
//                statement.setObject(5, user.getProduct_name());
//                statement.setObject(6, user.getCharge_type());
//                statement.setObject(7, user.getProduct_type());
//                statement.setObject(8, user.getPrm_code());
//                statement.setObject(9, user.getCb_code());
//                statement.setObject(10, user.getUser_id());
//                statement.setObject(11, user.getPhone_type());
//                statement.setObject(12, user.getOrder_time());
//                statement.setObject(13, user.getEffect_time());
//                statement.setObject(14, user.getOrder_channel());
//                statement.setObject(15, user.getCancel_order_time());
//                statement.setObject(16, user.getLose_effect_time());
//                statement.setObject(17, user.getOperation_time());
//                statement.setObject(18, user.getCancel_order_channel());
//                statement.setObject(19, user.getOrder_state());
//                statement.setObject(20, user.getProvince());
//                statement.setObject(21, user.getIs_first_order());
//                statement.setObject(22, user.getChannel_name());
//                statement.setObject(23, user.getChannel_code());
//                statement.setObject(24, user.getOne_level_channel());
//                statement.setObject(25, user.getTwo_level_channel());
//                statement.setObject(26, user.getThree_level_channel());
//                statement.setObject(27, user.getHandle_state());
//                statement.setObject(28, user.getInsert_time());
//                statement.setObject(29, user.getUpdate_time());
//                statement.setObject(30, user.getLose_effect_status());
//                statement.setObject(31, user.getTrigger_time());
//                statement.setObject(32, user.getOrder_cycle());
//                statement.setObject(33, user.getAccount());
//                statement.setObject(34, user.getAccount_type());
                statement.addBatch();//将数据转为一条sql语句

                // 达到一个批次最大值，入库
                if (counter == maxBatch) {
                    // 批量处理
                    statement.executeBatch();
                    // 清空缓存数据，结合最大入库数量的判断，做到双重防止内存溢出问题。
                    statement.clearBatch();
                    // 记录读取数量重置为0，重新累加最大入库数量。
                    counter = 0;
                }
            }

            //数据量小于最大批次入库量，且是最后一行则收尾。
            if (count < maxBatch &&  count == 1) {
                statement.executeBatch();
                statement.clearBatch();
                //关闭PreparedStatement实例
                statement.close();
                //为了防止预编译过程中程序异常，故改为手动提交sql
                db.conn.commit();
                //关闭数据库连接
                db.closeConnection();
                log.info(Thread.currentThread().getName() + " parse total line is:" + totalLine);
            }
        } catch (Exception e){
            throw new Exception("预编译插入语句出现问题，请联系运维人员排查！",e);
        }
    }
}
