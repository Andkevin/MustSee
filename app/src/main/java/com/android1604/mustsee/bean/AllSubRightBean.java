package com.android1604.mustsee.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public class AllSubRightBean {
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
         * id : 3964
         * keyword : 大咖秀
         * logo : http://souyue-xqq.b0.upaiyun.com/newssource/1606/lgtaabt2s5eo14667299591944-20160624085919_90_90.jpg
         * srpId : 117
         * category : 10
         * subscriber : 0
         * invokeType : 0
         * subCount : 0
         */

        private List<DataListBean> dataList;

        public List<DataListBean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListBean> dataList) {
            this.dataList = dataList;
        }

        public static class DataListBean {
            private String id;
            private String keyword;
            private String logo;
            private String srpId;
            private String category;
            private String subscriber;
            private String invokeType;
            private String subCount;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
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

            public String getSubscriber() {
                return subscriber;
            }

            public void setSubscriber(String subscriber) {
                this.subscriber = subscriber;
            }

            public String getInvokeType() {
                return invokeType;
            }

            public void setInvokeType(String invokeType) {
                this.invokeType = invokeType;
            }

            public String getSubCount() {
                return subCount;
            }

            public void setSubCount(String subCount) {
                this.subCount = subCount;
            }
        }
    }
}
