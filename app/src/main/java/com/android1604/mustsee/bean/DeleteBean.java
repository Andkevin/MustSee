package com.android1604.mustsee.bean;

/**
 * Created by Administrator on 2016/9/12.
 *
 */
public class DeleteBean {

    /**
     * status : 200
     * hasMore : false
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
    }
}
