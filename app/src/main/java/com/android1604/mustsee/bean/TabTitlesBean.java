package com.android1604.mustsee.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public class TabTitlesBean {

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
        private String status;
        private boolean hasMore;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
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
         * category : 100
         * title : 推荐
         * keyword : 推荐
         */

        private List<DataListBean> dataList;

        public List<DataListBean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListBean> dataList) {
            this.dataList = dataList;
        }

        public static class DataListBean {
            private String category;
            private String title;
            private String keyword;
            private String id;
            private String sortNum;
            private String srpId;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSortNum() {
                return sortNum;
            }

            public void setSortNum(String sortNum) {
                this.sortNum = sortNum;
            }

            public String getSrpId() {
                return srpId;
            }

            public void setSrpId(String srpId) {
                this.srpId = srpId;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }
        }
    }
}
