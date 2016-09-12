package com.android1604.mustsee.bean;

import java.util.List;

/**
 * Created by Kevin on 2016/9/10.
 * 搜索栏中的热搜榜数据
 */
public class SearchHotBean {

    /**
     * status : 200
     * hasMore : false
     */

    private HeadBean head;
    private BodyBean body;

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
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

    public static class BodyBean {
        /**
         * keyword : 只有中国在帮我们
         */

        private List<DataListBean> dataList;

        public List<DataListBean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListBean> dataList) {
            this.dataList = dataList;
        }

        public static class DataListBean {
            private String keyword;

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }
        }
    }
}
