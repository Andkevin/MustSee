package com.android1604.mustsee.bean;

/**
 * Created by Administrator on 2016/9/12.
 */
public class SortBean {

    /**
     * status : 601
     * hasMore : false
     * msg : 用户信息丢失，请重新登录
     */

    private HeadBean head;

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public static class HeadBean {
        private int status;
        private boolean hasMore;
        private String msg;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public boolean isHasMore() {
            return hasMore;
        }

        public void setHasMore(boolean hasMore) {
            this.hasMore = hasMore;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
