package com.example.dell.testviewpagerxlistdemo;

import java.util.List;

/**
 * Created by DELL on 2017/4/21.
 */

public class NewsBean {

    /**
     * ret_code : 200
     * ret_msg : ok
     * listViewPager : ["https://img10.360buyimg.com/da/jfs/t4747/277/1368712300/170619/35098d7f/58f038e0N9b3a0ca5.jpg","https://img14.360buyimg.com/da/jfs/t4915/21/1427207714/81116/b005bb06/58f08963Ndb295b3c.jpg","https://img13.360buyimg.com/da/jfs/t4651/104/2867456043/68336/99da4c16/58f41eaeN5b614a63.jpg"]
     * list : [{"date":"7小时前","id":8,"pic":"http://pic7.nipic.com/20100517/3409334_180613088650_2.jpg|http://pic9.nipic.com/20100820/2531170_182750402288_2.jpg|http://pic1a.nipic.com/2008-10-07/20081079019381_2.jpg","title":"镜头中的中朝边境，两人背对背却在不同的国家","type":2},{"date":"9小时前","id":10,"pic":"http://img0.imgtn.bdimg.com/it/u=105550316,1243681444&fm=23&gp=0.jpg|http://img2.imgtn.bdimg.com/it/u=3108305815,518549389&fm=23&gp=0.jpg|http://img2.imgtn.bdimg.com/it/u=2236312605,3722185191&fm=23&gp=0.jpg","title":"镜头下：1976年唐山发生7.8级大地震后的真实写照","type":2},{"date":"5分钟前","id":13,"pic":"http://img5.imgtn.bdimg.com/it/u=2451261816,2335595583&fm=23&gp=0.jpg|http://img2.imgtn.bdimg.com/it/u=294748347,2057171981&fm=23&gp=0.jpg|http://img5.imgtn.bdimg.com/it/u=4077182999,3637750066&fm=23&gp=0.jpg","title":"【莱克】魔洁大吸力无线吸尘器，多功能一键切换","type":2},{"date":"9分钟前","id":14,"pic":"http://p3.pstatp.com/list/190x124/1bf6000d3aa7569f07e4","title":" \n梁洛施带儿子返港，李嘉诚每年见孙子两次，李泽楷反对前女友定居\n \n梁洛施带儿子返港，李嘉诚每年见孙子两次，李泽楷反对前女友定居\n \n梁洛施带儿子返港，李嘉诚每年见孙子两次，李泽楷反对前女友定居","type":1},{"date":"9分钟前","id":15,"pic":"http://p3.pstatp.com/list/190x124/1c5c000661637502e36b|http://p3.pstatp.com/list/190x124/1c5f0005465e52ee0fe1|http://p1.pstatp.com/list/190x124/1c5f0005465fb4ec1c29","title":"2块钱一个馍，吃一口一生难忘！","type":2},{"date":"3小时前","id":17,"pic":"http://p3.pstatp.com/list/190x124/1bf5000f4a8dc5fec183","title":" \n银行卡突然多几亿，你以银行的名义捐给穷地方会怎么样？","type":1},{"date":"9小时前","id":20,"pic":"http://p1.pstatp.com/list/190x124/18a10004f6a0fb66f371","title":" \n100万元人民币的现金到底有多重？","type":1}]
     */

    private int ret_code;
    private String ret_msg;
    private List<String> listViewPager;
    private List<ListBean> list;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public List<String> getListViewPager() {
        return listViewPager;
    }

    public void setListViewPager(List<String> listViewPager) {
        this.listViewPager = listViewPager;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * date : 7小时前
         * id : 8
         * pic : http://pic7.nipic.com/20100517/3409334_180613088650_2.jpg|http://pic9.nipic.com/20100820/2531170_182750402288_2.jpg|http://pic1a.nipic.com/2008-10-07/20081079019381_2.jpg
         * title : 镜头中的中朝边境，两人背对背却在不同的国家
         * type : 2
         */

        private String date;
        private int id;
        private String pic;
        private String title;
        private int type;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
