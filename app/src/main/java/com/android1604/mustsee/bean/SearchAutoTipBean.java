package com.android1604.mustsee.bean;

import java.util.List;

/**
 * Created by Kevin on 2016/9/10.
 * 搜索栏中的自动搜索数据
 */
public class SearchAutoTipBean {

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
         * category : 1
         * title : 楚游酒店开发
         * keyword : 楚游酒店开发
         * srpId : 045de5a10563361b8efd0a54af924b34
         * image : http://edit.zhongsou.com/Img/getSrpImg?srpId=045de5a10563361b8efd0a54af924b34&itkey=subsmail
         * desc :
         */

        private List<DataListBean> dataList;

        public List<DataListBean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListBean> dataList) {
            this.dataList = dataList;
        }

        public static class DataListBean {
            private int category;
            private String title;
            private String keyword;
            private String srpId;
            private String image;
            private String desc;

            public int getCategory() {
                return category;
            }

            public void setCategory(int category) {
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

            public String getSrpId() {
                return srpId;
            }

            public void setSrpId(String srpId) {
                this.srpId = srpId;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }
    }
}
